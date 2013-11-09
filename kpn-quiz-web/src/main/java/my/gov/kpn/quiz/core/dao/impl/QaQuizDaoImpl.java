package my.gov.kpn.quiz.core.dao.impl;

import my.gov.kpn.quiz.core.dao.QaQuizDao;
import my.gov.kpn.quiz.core.model.*;
import my.gov.kpn.quiz.core.model.impl.QaQuizImpl;
import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
@Repository("quizDao")
public class QaQuizDaoImpl extends DaoSupport<Long, QaQuiz, QaQuizImpl> implements QaQuizDao {

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public QaQuiz findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (QaQuiz) session.get(QaQuizImpl.class, id);
    }

    @Override
    public List<QaQuiz> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaQuiz a where " +
                "a.metadata.state = :state " +
                "order by a.code");
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public Integer count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from QaQuiz a where " +
                "a.metadata.state = :state");
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    // =============================================================================
    // CRUD METHODS
    // =============================================================================


    @Override
    public void addQuestion(QaQuiz quiz, QaQuestion question, QaUser user) {
        Validate.notNull(quiz, "Quiz should not be null");
        Validate.notNull(question, "Question should not be null");

        Session session = sessionFactory.getCurrentSession();
        question.setQuiz(quiz);

        // prepare metadata
        QaMetadata metadata = new QaMetadata();
        metadata.setState(QaMetaState.ACTIVE);
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreator(user.getId());
        question.setMetadata(metadata);
        session.save(question);
    }

    @Override
    public void removeQuestion(QaQuiz quiz, QaQuestion question, QaUser user) {
        Validate.notNull(quiz, "Quiz should not be null");
        Validate.notNull(question, "Question should not be null");

        Session session = sessionFactory.getCurrentSession();
        question.setQuiz(quiz);

        // prepare metadata
        QaMetadata metadata = quiz.getMetadata();
        metadata.setState(QaMetaState.INACTIVE);
        metadata.setDeletedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setDeleter(user.getId());
        question.setMetadata(metadata);
        session.update(question);
    }
}

