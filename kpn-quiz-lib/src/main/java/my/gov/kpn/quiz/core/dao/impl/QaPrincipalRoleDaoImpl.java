package my.gov.kpn.quiz.core.dao.impl;

import my.gov.kpn.quiz.core.dao.QaPrincipalRoleDao;
import my.gov.kpn.quiz.core.model.*;
import my.gov.kpn.quiz.core.model.impl.QaPrincipalRoleImpl;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static my.gov.kpn.quiz.core.model.QaPrincipalType.GROUP;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
@Repository("principalRoleDao")
public class QaPrincipalRoleDaoImpl implements QaPrincipalRoleDao {

    private static final Logger log = Logger.getLogger(QaPrincipalRoleDaoImpl.class);

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Override
    public void grant(QaPrincipal principal, QaRoleType roleType, QaUser user) {
        Session session = sessionFactory.getCurrentSession();
        // save principal role
        QaPrincipalRole principalRole = new QaPrincipalRoleImpl();
        principalRole = prepareMetadata(principalRole, user);
        principalRole.setRoleType(roleType);
        principalRole.setPrincipal(principal);
        session.save(principalRole);
    }

    @Override
    public void grant(QaPrincipal principal, QaRoleType[] roleTypes, QaUser user) {
        for (QaRoleType role : roleTypes) {
            grant(principal, role, user);
        }
    }

    private Query getQueryString(QaPrincipal principal) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select r from QaPrincipalRole r where r.principal = :principal and r.role = :role");
    }

    @Override
    public void revoke(QaPrincipal principal, QaRoleType roleType, QaUser user) {
        Session session = sessionFactory.getCurrentSession();
        Query query = getQueryString(principal);
        query.setEntity("principal", principal);
        query.setString("role", roleType.name());
        session.delete(query.uniqueResult());
    }

    @Override
    public void revoke(QaPrincipal principal, QaRoleType[] roleTypes, QaUser user) {
        // TODO:

    }

    @Override
    public void revokeAll(QaPrincipal principal, QaUser user) {
        if (principal.getPrincipalType().equals(GROUP)) {
            revokeAll(principal);
        } else if (principal.getPrincipalType().equals(QaPrincipalType.USER)) {
            revokeAll(principal);
        } else
            throw new IllegalArgumentException("Unknown principal type");
    }

    @Override
    public void overwrite(QaPrincipal principal, QaRoleType roleType, QaUser user) {
        // TODO:

    }

    @Override
    public void overwrite(QaPrincipal principal, QaRoleType[] roleTypes, QaUser user) {
        // TODO:
    }

    private void update(QaUser user, QaRoleType[] roleTypes, QaUser adminUser) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select r from QaPrincipalRole r where r.principal = :principal");
        query.setEntity("principal", user);
        List<QaPrincipalRole> userRoles = (List<QaPrincipalRole>) query.list();

        List<QaPrincipalRole> newUserRoles = new ArrayList<QaPrincipalRole>();
        for (QaRoleType roleType : roleTypes) {
            QaPrincipalRole principalRole = new QaPrincipalRoleImpl();
            principalRole = prepareMetadata(principalRole, user);
            principalRole.setRoleType(roleType);
            principalRole.setPrincipal(user);
            newUserRoles.add(principalRole);
        }
        for (QaPrincipalRole userRole : userRoles) {
            if (!newUserRoles.contains(userRole)) {
                System.out.println(userRole.getRoleType() + " removed");
                session.delete(userRole);
            }
        }

        for (QaPrincipalRole newUserRole : newUserRoles) {
            if (!userRoles.contains(newUserRole)) {
                session.save(newUserRole);
            }
        }
    }

    public void update(QaPrincipal principal, QaPrincipalRole[] roles, QaUser user) {
        if (principal.getPrincipalType().equals(GROUP)) {
            update((QaGroup) principal, roles, user);
        } else if (principal.getPrincipalType().equals(QaPrincipalType.USER)) {
            update((QaUser) principal, roles, user);
        } else
            throw new IllegalArgumentException("Unknown principal type");
    }

    private void revokeAll(QaPrincipal principal) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select r from QaPrincipalRole r where r.principal = :principal");
        query.setEntity("principal", principal);
        List<QaPrincipalRole> roles = (List<QaPrincipalRole>) query.list();
        for (QaPrincipalRole role : roles) {
            session.delete(role);
        }
    }

    protected QaPrincipalRole prepareMetadata(QaPrincipalRole principalRole, QaUser user) {
        QaMetadata metadata = new QaMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreator(user.getId());
        metadata.setState(QaMetaState.ACTIVE);
        principalRole.setMetadata(metadata);
        return principalRole;
    }
}