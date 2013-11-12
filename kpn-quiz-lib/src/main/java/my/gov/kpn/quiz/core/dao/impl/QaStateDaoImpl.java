package my.gov.kpn.quiz.core.dao.impl;

import my.gov.kpn.quiz.core.dao.QaStateDao;
import my.gov.kpn.quiz.core.model.QaState;
import my.gov.kpn.quiz.core.model.QaMetaState;
import my.gov.kpn.quiz.core.model.impl.QaStateImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
@Repository("stateDao")
public class QaStateDaoImpl extends DaoSupport<Long, QaState, QaStateImpl> implements QaStateDao {

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public QaState findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (QaState) session.get(QaStateImpl.class, id);
    }

    @Override
    public QaState findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaState a where " +
                "a.code = :code " +
                "and a.metadata.state = :state ");
        query.setString("identityNo", code);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return (QaState) query.uniqueResult();
    }

    public List<QaState> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaState a");
        return (List<QaState>)query.list();
    }
    @Override
    public List<QaState> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaState a where " +
                "a.metadata.state = :state " +
                "order by a.code");
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<QaState> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaState a where " +
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
    public Integer count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from QaState a where " +
                "a.metadata.state = :state");
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from QaState a where " +
                "(a.name like upper(:filter) " +
                "or upper(a.identityNo) like upper(:filter)) " +
                "and a.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    // =============================================================================
    // CRUD METHODS
    // =============================================================================

}
