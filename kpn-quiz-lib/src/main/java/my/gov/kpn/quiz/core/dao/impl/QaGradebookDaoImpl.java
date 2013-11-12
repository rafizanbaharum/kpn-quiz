package my.gov.kpn.quiz.core.dao.impl;

import my.gov.kpn.quiz.core.dao.QaGradebookDao;
import my.gov.kpn.quiz.core.model.*;
import my.gov.kpn.quiz.core.model.impl.QaGradebookImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/11/13
 */
@Repository("gradebookDao")
public class QaGradebookDaoImpl extends DaoSupport<Long, QaGradebook, QaGradebookImpl> implements QaGradebookDao {

    @Override
    public QaGradebook findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (QaGradebook) session.get(QaGradebookImpl.class, id);
    }

    @Override
    public List<QaGradebook> find(QaParticipant participant, QaQuiz quiz) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaGradebook a where " +
                "a.quiz = :quiz " +
                "and a.participant = :participant " +
                "and a.metadata.state = :state ");
        query.setEntity("quiz", quiz);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return query.list();
    }

    @Override
    public List<QaGradebook> find(QaParticipant participant, QaQuiz quiz, QaQuestion question) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaGradebook a where " +
                "a.quiz = :quiz " +
                "and a.participant = :participant " +
                "and a.metadata.state = :state ");
        query.setEntity("quiz", quiz);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return query.list();
    }

    @Override
    public List<QaGradebook> find(QaQuiz quiz) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaGradebook a where " +
                "a.quiz = :quiz" +
                "and a.metadata.state = :state ");
        query.setEntity("quiz", quiz);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return query.list();
    }

    @Override
    public Integer count(QaQuiz quiz) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from QaGradebook a where " +
                "a.metadata.state = :state");
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public void addItem(QaGradebook Gradebook, QaGradebookItem item, QaUser user) {
        // TODO:

    }

    @Override
    public void removeItem(QaGradebook Gradebook, QaGradebookItem item, QaUser user) {
        // TODO:

    }

    @Override
    public void deleteItem(QaGradebook Gradebook, QaGradebookItem item, QaUser user) {
        // TODO:

    }
}
