package my.gov.kpn.quiz.core.model;

import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface QaPrincipal extends QaMetaObject {

    String getName();

    void setName(String name);

    boolean isEnabled();

    void setEnabled(boolean enabled);

    boolean isLocked();

    void setLocked(boolean locked);

    QaPrincipalType getPrincipalType();

    void setPrincipalType(QaPrincipalType principalType);

    Set<QaPrincipalRole> getRoles();

    void setRoles(Set<QaPrincipalRole> roles);

}
