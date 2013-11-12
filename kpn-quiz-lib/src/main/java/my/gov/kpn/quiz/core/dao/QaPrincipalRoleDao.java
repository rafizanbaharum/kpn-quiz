package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.model.QaPrincipal;
import my.gov.kpn.quiz.core.model.QaRoleType;
import my.gov.kpn.quiz.core.model.QaUser;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public interface QaPrincipalRoleDao {

    void grant(QaPrincipal principal, QaRoleType roleType, QaUser user);

    void grant(QaPrincipal principal, QaRoleType[] roleTypes, QaUser user);

    void revoke(QaPrincipal principal, QaRoleType roleType, QaUser user);

    void revoke(QaPrincipal principal, QaRoleType[] roleTypes, QaUser user);

    void revokeAll(QaPrincipal principal, QaUser user);

    void overwrite(QaPrincipal principal, QaRoleType roleType, QaUser user);

    void overwrite(QaPrincipal principal, QaRoleType[] roleTypes, QaUser user);

}
