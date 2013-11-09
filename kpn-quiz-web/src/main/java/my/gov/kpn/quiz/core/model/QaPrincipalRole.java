package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface QaPrincipalRole extends QaMetaObject {

    /**
     * @return
     */
    QaRoleType getRoleType();

    void setRoleType(QaRoleType roleType);

    /**
     * @return
     */
    QaPrincipal getPrincipal();

    void setPrincipal(QaPrincipal principal);

}
