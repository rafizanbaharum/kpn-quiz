package my.gov.kpn.quiz.core.dao.impl;

import my.gov.kpn.quiz.core.dao.QaPrincipalDao;
import my.gov.kpn.quiz.core.exception.RecursiveGroupException;
import my.gov.kpn.quiz.core.model.QaGroup;
import my.gov.kpn.quiz.core.model.QaMetaState;
import my.gov.kpn.quiz.core.model.QaPrincipal;
import my.gov.kpn.quiz.core.model.QaPrincipalType;
import my.gov.kpn.quiz.core.model.impl.QaPrincipalImpl;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
@Repository("principalDao")
public class QaPrincipalDaoImpl extends DaoSupport<Long, QaPrincipal, QaPrincipalImpl> implements QaPrincipalDao {

    private static final Logger log = Logger.getLogger(QaPrincipalDaoImpl.class);

    private boolean allowRecursiveGroup = false;

    private Set<String> groupName = null;


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

    /**
     * find principal
     *
     * @param offset offset
     * @param limit  limit
     * @return list of principals
     */
    @Override
    public List<QaPrincipal> findPrincipals(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from QaPrincipal p");
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<QaPrincipal>) query.list();
    }

    @Override
    public Set<QaGroup> loadEffectiveGroups(QaPrincipal principal) throws RecursiveGroupException {
        /**
         with recursive q(user_name,group_name,member_id,group_id) as (
         select h.user_name,h.group_name,h.member_id,h.group_id, 1 as level from (
         select u1.name user_name,g1.name group_name,member_id,group_id from cf_pcpl u1, cf_user u2, cf_pcpl g1, cf_grop g2, cf_grop_mmbr g3
         where u1.id = u2.id
         and g1.id = g2.id and g1.id = g3.group_id
         and g3.member_id = u1.id
         ) h
         union all
         select hi.user_name,hi.group_name,hi.member_id,hi.group_id, q.level + 1 as level
         from q, (
         select u1.name user_name,g1.name group_name,member_id,group_id from cf_pcpl u1, cf_user u2, cf_pcpl g1, cf_grop g2, cf_grop_mmbr g3
         where u1.id = u2.id
         and g1.id = g2.id and g1.id = g3.group_id
         and g3.member_id = u1.id
         )hi where hi.member_id = q.group_id
         )
         select * from q;
         */


        return null;  // TODO:

    }

    public Set<GrantedAuthority> loadEffectiveAuthorities(QaPrincipal principal) throws RecursiveGroupException {
        return new HashSet<GrantedAuthority>(); // todo
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
