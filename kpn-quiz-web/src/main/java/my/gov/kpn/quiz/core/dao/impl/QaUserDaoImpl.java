package my.gov.kpn.quiz.core.dao.impl;

import my.gov.kpn.quiz.core.dao.QaPrincipalDao;
import my.gov.kpn.quiz.core.dao.QaUserDao;
import my.gov.kpn.quiz.core.model.QaActor;
import my.gov.kpn.quiz.core.model.QaGroup;
import my.gov.kpn.quiz.core.model.QaMetaState;
import my.gov.kpn.quiz.core.model.QaUser;
import my.gov.kpn.quiz.core.model.impl.QaUserImpl;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
@Repository("userDao")
public class QaUserDaoImpl extends DaoSupport<Long, QaUser, QaUserImpl> implements QaUserDao {

    private static final Logger log = Logger.getLogger(QaUserDaoImpl.class);

    @Autowired
    private QaPrincipalDao principalDao;


    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public List<QaGroup> findUserGroups(QaUser user) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select r from QaGroup r inner join r.groupMembers m where m.principal = :user");
        query.setEntity("user", user);
        return (List<QaGroup>) query.list();
    }

    @Override
    public boolean isExists(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from QaUser u where " +
                "u.name = :username");
        query.setString("username", username);
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public QaUser findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (QaUser) session.get(QaUserImpl.class, id);
    }

    @Override
    public QaUser findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from QaUser u where u.name = :username and u.metadata.state = :state");
        query.setString("username", username);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return (QaUser) query.uniqueResult();
    }

    @Override
    public QaUser findByActor(QaActor actor) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from QaUser u where u.actor  = :actor");
        query.setEntity("actor", actor);
        return (QaUser) query.uniqueResult();
    }

    public QaUser findByRealName(String realname) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from QaUser u where u.realname = :realname");
        query.setString("realname", realname);
        return (QaUser) query.uniqueResult();
    }

    @Override
    public List<QaUser> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from QaUser s");
        return (List<QaUser>) query.list();
    }

    @Override
    public List<QaUser> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from QaUser s");
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<QaUser>) query.list();
    }

    @Override
    public List<QaUser> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from QaUser s where (s.name like :filter or s.realname like upper(:filter))");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<QaUser>) query.list();
    }

    @Override
    public Integer count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(u) from QaUser u");
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from QaUser s where s.name like :filter " +
                "or s.realname like upper(:filter)");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        return ((Long) query.uniqueResult()).intValue();
    }
}
