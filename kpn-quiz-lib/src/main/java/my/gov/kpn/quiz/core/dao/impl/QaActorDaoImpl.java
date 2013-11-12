package my.gov.kpn.quiz.core.dao.impl;

import my.gov.kpn.quiz.core.dao.QaActorDao;
import my.gov.kpn.quiz.core.model.QaActor;
import my.gov.kpn.quiz.core.model.QaActorType;
import my.gov.kpn.quiz.core.model.QaMetaState;
import my.gov.kpn.quiz.core.model.impl.QaActorImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
@Repository("actorDao")
public class QaActorDaoImpl extends DaoSupport<Long, QaActor, QaActorImpl> implements QaActorDao {

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public QaActor findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (QaActor) session.get(QaActorImpl.class, id);
    }

    @Override
    public QaActor findByIdentityNo(String identityNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaActor a where " +
                "a.identityNo = :identityNo " +
                "and a.metadata.state = :state ");
        query.setString("identityNo", identityNo);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return (QaActor) query.uniqueResult();
    }

    @Override
    public QaActor findByNricNo(String nricNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaActor a where " +
                "a.nricNo = :nricNo " +
                "and a.metadata.state = :state ");
        query.setString("nricNo", nricNo);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return (QaActor) query.uniqueResult();
    }

    @Override
    public List<QaActor> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaActor a where " +
                "a.metadata.state = :state " +
                "order by a.code");
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<QaActor> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaActor a where " +
                "(a.code like upper(:filter) " +
                "or upper(a.description) like upper(:filter)) " +
                "and a.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<QaActor> find(QaActorType type, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaActor a where " +
                "a.actorType = :actorType " +
                "and a.metadata.state = :state");
        query.setInteger("actorType", type.ordinal());
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<QaActor> find(QaActorType type, String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaActor a where " +
                "(a.identityNo like upper(:filter) " +
                "or upper(a.name) like upper(:filter)) " +
                "and a.actorType = :actorType " +
                "and a.metadata.state = :state");
        query.setInteger("actorType", type.ordinal());
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public Integer count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from QaActor a where " +
                "a.metadata.state = :state");
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from QaActor a where " +
                "(a.name like upper(:filter) " +
                "or upper(a.identityNo) like upper(:filter)) " +
                "and a.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(QaActorType type) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from QaActor a where " +
                "a.actorType = :actorType " +
                "and a.metadata.state = :state");
        query.setInteger("actorType", type.ordinal());
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    // =============================================================================
    // CRUD METHODS
    // =============================================================================

}

