package my.gov.kpn.quiz.core.dao.impl;

import my.gov.kpn.quiz.core.dao.QaParticipantDao;
import my.gov.kpn.quiz.core.model.QaMetaState;
import my.gov.kpn.quiz.core.model.QaParticipant;
import my.gov.kpn.quiz.core.model.QaRound;
import my.gov.kpn.quiz.core.model.QaUser;
import my.gov.kpn.quiz.core.model.impl.QaParticipantImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
@Repository("participantDao")
public class QaParticipantDaoImpl extends DaoSupport<Long, QaParticipant, QaParticipantImpl> implements QaParticipantDao {

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public QaParticipant findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (QaParticipant) session.get(QaParticipantImpl.class, id);
    }

    @Override
    public QaParticipant find(QaRound round, QaUser user) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaParticipant a where " +
                "a.round = :round " +
                "and a.user = :user " +
                "and a.metadata.state = :state " +
                "order by a.id");
        query.setEntity("round", round);
        query.setEntity("user", user);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return (QaParticipant) query.uniqueResult();
    }

    @Override
    public List<QaParticipant> findAll(QaRound round) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaParticipant a where " +
                "a.round = :round " +
                "and a.metadata.state = :state " +
                "order by a.id");
        query.setEntity("round", round);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return (List<QaParticipant>) query.uniqueResult();
    }

    @Override
    public List<QaParticipant> find(QaRound round, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaParticipant a where " +
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
        Query query = session.createQuery("select count(a) from QaParticipant a where " +
                "a.metadata.state = :state");
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    // =============================================================================
    // CRUD METHODS
    // =============================================================================
}

