package my.gov.kpn.quiz.core.dao.impl;

import my.gov.kpn.quiz.core.dao.QaConfigurationDao;
import my.gov.kpn.quiz.core.model.QaConfiguration;
import my.gov.kpn.quiz.core.model.QaMetaState;
import my.gov.kpn.quiz.core.model.impl.QaConfigurationImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

import static my.gov.kpn.quiz.core.model.QaMetaState.ACTIVE;

/**
 * @author rafizan.baharum
 * @since 11/27/13
 */
@Repository("configurationDao")
public class QaConfigurationDaoImpl extends DaoSupport<Long, QaConfiguration, QaConfigurationImpl> implements QaConfigurationDao {
    // =============================================================================
    // HELPER METHODS
    // =============================================================================

    @Override
    public QaConfiguration newInstance() {
        return new QaConfigurationImpl();
    }


    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public QaConfiguration findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (QaConfiguration) session.get(QaConfigurationImpl.class, id);
    }

    @Override
    public QaConfiguration findByKey(String key) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select rn from QaConfiguration rn where rn.key = :key");
        query.setString("key", key);
        query.setCacheable(true);
        return (QaConfiguration) query.uniqueResult();
    }

    @Override
    public List<QaConfiguration> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select rn from QaConfiguration rn where " +
                "rn.metadata.state = :state");
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return query.list();
    }

    @Override
    public List<QaConfiguration> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select rn from QaConfiguration rn where " +
                "(rn.key like upper(:filter) " +
                "or upper(rn.value) like upper(:filter)) " +
                "and rn.metadata.state = :state");
        query.setString("filter", filter);
        query.setInteger("state", ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public Integer count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(rn) from QaConfiguration rn where " +
                "rn.metadata.state = :state");
        query.setInteger("state", ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(rn) from QaConfiguration rn where " +
                "(rn.key like upper(:filter) " +
                "or upper(rn.value) like upper(:filter)) " +
                "and rn.metadata.state = :state");
        query.setString("filter", filter);
        query.setInteger("state", ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }
}
    