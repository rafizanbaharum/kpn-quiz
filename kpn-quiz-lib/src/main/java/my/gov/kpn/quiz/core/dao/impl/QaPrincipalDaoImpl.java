package my.gov.kpn.quiz.core.dao.impl;

import my.gov.kpn.quiz.core.dao.QaPrincipalDao;
import my.gov.kpn.quiz.core.model.QaMetaState;
import my.gov.kpn.quiz.core.model.QaPrincipal;
import my.gov.kpn.quiz.core.model.QaPrincipalType;
import my.gov.kpn.quiz.core.model.impl.QaPrincipalImpl;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
@Repository("principalDao")
public class QaPrincipalDaoImpl extends DaoSupport<Long, QaPrincipal, QaPrincipalImpl> implements QaPrincipalDao {

    private static final Logger log = Logger.getLogger(QaPrincipalDaoImpl.class);

    @Override
    public List<QaPrincipal> findAllPrincipals() {
        Session session = sessionFactory.getCurrentSession();
        List<QaPrincipal> results = new ArrayList<QaPrincipal>();
        Query query = session.createQuery("select p from QaUser p where p.metadata.state = :state order by p.name");
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        results.addAll((List<QaPrincipal>) query.list());

        Query queryGroup = session.createQuery("select p from QaGroup p where p.metadata.state = :state order by p.name ");
        queryGroup.setInteger("state", QaMetaState.ACTIVE.ordinal());
        results.addAll((List<QaPrincipal>) queryGroup.list());
        return results;
    }

    @Override
    public List<QaPrincipal> findPrincipals(String filter) {
        Session session = sessionFactory.getCurrentSession();
        List<QaPrincipal> results = new ArrayList<QaPrincipal>();
        Query query = session.createQuery("select p from QaPrincipal p where p.metadata.state = :state and p.name like :filter order by p.name");
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        query.setString("filter", WILDCARD + filter + WILDCARD);
        results.addAll((List<QaPrincipal>) query.list());
        return results;
    }

    @Override
    public List<QaPrincipal> findPrincipals(String filter, QaPrincipalType type) {
        Session session = sessionFactory.getCurrentSession();
        List<QaPrincipal> results = new ArrayList<QaPrincipal>();
        Query query = session.createQuery("select p from QaPrincipal p where " +
                "p.metadata.state = :state " +
                "and p.name like :filter " +
                "and p.principalType = :principalType " +
                "order by p.name");
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("principalType", type.ordinal());
        results.addAll((List<QaPrincipal>) query.list());
        return results;
    }

    @Override
    public List<QaPrincipal> findPrincipals(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from QaPrincipal p");
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<QaPrincipal>) query.list();
    }

    @Override
    public QaPrincipal findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        log.debug("Searching for principal " + name);
        Query query = session.createQuery("select p from QaPrincipal p where p.name = :name");
        query.setString("name", name);
        return (QaPrincipal) query.uniqueResult();
    }
}
