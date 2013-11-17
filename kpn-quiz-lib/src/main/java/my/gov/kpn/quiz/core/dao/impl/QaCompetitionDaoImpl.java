package my.gov.kpn.quiz.core.dao.impl;

import my.gov.kpn.quiz.core.dao.QaCompetitionDao;
import my.gov.kpn.quiz.core.model.*;
import my.gov.kpn.quiz.core.model.impl.QaCompetitionImpl;
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
@Repository("competitionDao")
public class QaCompetitionDaoImpl extends DaoSupport<Long, QaCompetition, QaCompetitionImpl> implements QaCompetitionDao {

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public QaCompetition findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (QaCompetition) session.get(QaCompetitionImpl.class, id);
    }

    @Override
    public QaCompetition findByYear(Integer year) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaCompetition a where " +
                "a.year = :year " +
                "and a.metadata.state = :state ");
        query.setInteger("year", year);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return (QaCompetition) query.uniqueResult();
    }

    @Override
    public List<QaCompetition> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaCompetition a where " +
                "a.metadata.state = :state " +
                "order by a.id");
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public Integer count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from QaCompetition a where " +
                "a.metadata.state = :state");
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    // =============================================================================
    // CRUD METHODS
    // =============================================================================


    @Override
    public void addQuiz(QaCompetition competition, QaQuiz quiz, QaUser user) {
        Validate.notNull(competition, "Competition should not be null");
        Validate.notNull(quiz, "Quiz should not be null");

        Session session = sessionFactory.getCurrentSession();
        quiz.setCompetition(competition);

        // prepare metadata
        QaMetadata metadata = new QaMetadata();
        metadata.setState(QaMetaState.ACTIVE);
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreator(user.getId());
        quiz.setMetadata(metadata);
        session.save(quiz);
    }

    @Override
    public void removeQuiz(QaCompetition competition, QaQuiz quiz, QaUser user) {
        Validate.notNull(competition, "Competition should not be null");
        Validate.notNull(quiz, "Quiz should not be null");

        Session session = sessionFactory.getCurrentSession();
        quiz.setCompetition(competition);

        // prepare metadata
        QaMetadata metadata = quiz.getMetadata();
        metadata.setState(QaMetaState.INACTIVE);
        metadata.setDeletedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setDeleter(user.getId());
        quiz.setMetadata(metadata);
        session.update(quiz);
    }
}

