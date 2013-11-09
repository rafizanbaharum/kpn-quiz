package my.gov.kpn.quiz.core.dao.impl;

import my.gov.kpn.quiz.core.dao.QaGroupDao;
import my.gov.kpn.quiz.core.exception.LockedGroupException;
import my.gov.kpn.quiz.core.exception.RecursiveGroupException;
import my.gov.kpn.quiz.core.model.*;
import my.gov.kpn.quiz.core.model.impl.QaGroupImpl;
import my.gov.kpn.quiz.core.model.impl.QaGroupMemberImpl;
import org.apache.commons.lang.Validate;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.LongType;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
@Repository("groupDao")
public class QaGroupDaoImpl extends DaoSupport<Long, QaGroup, QaGroupImpl> implements QaGroupDao {

    private static final Logger log = Logger.getLogger(QaGroupDaoImpl.class);

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public QaGroup findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (QaGroup) session.get(QaGroupImpl.class, id);
    }

    @Override
    public List<QaGroup> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select g from QaGroup g order by g.name");
        return (List<QaGroup>) query.list();
    }

    @Override
    public List<String> findAllGroupName() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select g.name from QaGroup g");
        return (List<String>) query.list();
    }

    @Override
    public QaGroup findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select g from QaGroup g where g.name = :name");
        query.setString("name", name);
        return (QaGroup) query.uniqueResult();
    }

    @Override
    public List<QaPrincipal> findMembers(QaGroup group) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select gm.principal from QaGroupMember gm where " +
                "gm.group = :group " +
                "order by gm.principal.name");
        query.setEntity("group", group);
        return (List<QaPrincipal>) query.list();
    }

    /**
     * XXX: ClassCastException issues
     * XXX: select gm.principal wil get you abstract QaPrincipal
     * XXX: not extension classes
     *
     * @param group
     * @param type
     * @return
     */
    @Override
    public List<QaPrincipal> findMembers(QaGroup group, QaPrincipalType type) {
        Session session = sessionFactory.getCurrentSession();
        Query query = null;

        String selectGroup = "select g from QaGroup g where " +
                "id in (select gm.principal.id from QaGroupMember gm where " +
                "gm.group = :group " +
                "and gm.principal.principalType = :type )" +
                "order by g.name";
        String selectUser = "select u from QaUser u where " +
                "id in (select gm.principal.id from QaGroupMember gm where " +
                "gm.group = :group " +
                "and gm.principal.principalType = :type )" +
                "order by u.name";
        switch (type) {
            case USER:
                query = session.createQuery(selectUser);
                break;
            case GROUP:
                query = session.createQuery(selectGroup);
                break;
        }
        query.setEntity("group", group);
        query.setInteger("type", type.ordinal());
        return (List<QaPrincipal>) query.list();
    }

    @Override
    public List<QaGroup> findMemberships(QaPrincipal principal) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select gm.group from QaGroupMember gm inner join gm.principal where " +
                "gm.principal = :principal");
        query.setEntity("principal", principal);
        return (List<QaGroup>) query.list();
    }

    @Override
    public List<QaPrincipal> findMembers(QaGroup group, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select gm.principal from QaGroupMember gm where " +
                "gm.group = :group " +
                "order by gm.principal.name");
        query.setEntity("group", group);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<QaPrincipal>) query.list();
    }

    @Override
    public List<QaGroup> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select g from QaGroup g order by g.name");
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<QaGroup>) query.list();
    }


    @Override
    public List<QaGroup> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct g from QaGroup g where " +
                "g.name like upper(:filter) " +
                "and g.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<QaGroup>) query.list();
    }

    @Override
    public List<QaGroup> findParentGroup(QaGroup group) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select g from QaGroup g inner join g.groupMembers m where m.principal = :group");
        query.setEntity("group", group);
        return (List<QaGroup>) query.list();
    }

    @Override
    public Set<QaGroup> findHierarchicalGroupAsNative(QaPrincipal principal) {
        Session session = sessionFactory.getCurrentSession();
        String sqlQuery = "SELECT CONNECT_BY_ROOT p.id parent " +
                "FROM fs_principal p, fs_group g, fs_group_member m, fs_principal u " +
                "WHERE p.id = g.id " +
                "AND m.group_id = g.id " +
                "AND m.principal_id = u.id " +
                "and u.name = '" + principal.getName() + "' " +
                "connect by prior m.principal_id = m.group_id";
        sqlQuery = "SELECT DISTINCT parent FROM ( " + sqlQuery + ")";
        SQLQuery query = session.createSQLQuery(sqlQuery);
        query.addScalar("parent", LongType.INSTANCE);
        List<Long> results = (List<Long>) query.list();
        Set<QaGroup> groups = new HashSet<QaGroup>();
        for (Long result : results) {
            groups.add(findById(result));
        }
        return groups;
    }

    @Override
    public Integer count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(g) from QaGroup g where " +
                "g.metadata.state = :state");
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(g) from QaGroup g where " +
                "g.name like upper(:filter) " +
                "and g.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isMemberOf(QaGroup group, QaPrincipal principal) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(g) from QaGroupMember g where " +
                "g.group = :group " +
                "and g.principal = :principal");
        query.setEntity("group", group);
        query.setEntity("principal", principal);
        return ((Long) query.uniqueResult()).intValue() >= 1;
    }

    @Override
    public QaGroupMember findGroupMember(QaGroup group, QaPrincipal principal) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select g from QaGroupMember g where " +
                "g.group = :group " +
                "and g.principal = :principal");
        query.setEntity("group", group);
        query.setEntity("principal", principal);
        return (QaGroupMember) query.uniqueResult();
    }

// =============================================================================
    // CRUD METHODS
    // =============================================================================

    @Override
    public void addMember(QaGroup group, QaPrincipal member, QaUser user) throws RecursiveGroupException, LockedGroupException {

        // validate
        Validate.notNull(group, "Group should not be null");
        Validate.notNull(member, "Group member should not be null");

        // check locked group
        if (group.isLocked()) {
            log.error("Group is locked");
            throw new LockedGroupException("Locked group");
        }

        // check recursive add
//        if (member instanceof QaGroup) {
//            if (isInRecursive(group, (QaGroup) member))
//                throw new RecursiveGroupException("Recursive user group detected");
//        }

        // session
        Session session = sessionFactory.getCurrentSession();

        // populate
        QaGroupMember groupMember = new QaGroupMemberImpl();
        groupMember.setGroup(group);
        groupMember.setMember(member);

        // prepare metadata
        QaMetadata metadata = new QaMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreator(user.getId());
        groupMember.setMetadata(metadata);
        session.save(groupMember);
    }

    @Override
    public void addMembers(QaGroup group, List<QaPrincipal> principals, QaUser user) throws RecursiveGroupException, LockedGroupException {
        List<QaPrincipal> principalGroups = findMembers(group);
        List<QaPrincipal> newPrincipals = new ArrayList<QaPrincipal>();

        for (QaPrincipal principal : principals) {
            newPrincipals.add(principal);
        }

        for (QaPrincipal principalGroup : principalGroups) {
            if (!newPrincipals.contains(principalGroup)) {
                removeMember(group, principalGroup);
            }
        }

        for (QaPrincipal newGroup : newPrincipals) {
            if (!principalGroups.contains(newGroup)) {
                addMember(group, newGroup, user);
            }
        }
    }

    @Override
    public void removeMember(QaGroup group, QaPrincipal principal) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select g from QaGroupMember g where g.group = :group and g.principal = :principal");
        query.setEntity("group", group);
        query.setEntity("principal", principal);
        QaGroupMember groupMember = (QaGroupMember) query.uniqueResult();
        session.delete(groupMember);
    }

    private boolean isInRecursive(QaGroup parent, QaGroup child) {
        Set<QaGroup> hierarchicalGroup = findHierarchicalGroupAsNative(parent);
        return !hierarchicalGroup.add(child);
    }

}
