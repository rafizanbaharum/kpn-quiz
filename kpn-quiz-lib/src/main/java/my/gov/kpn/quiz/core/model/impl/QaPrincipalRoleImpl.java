package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.QaMetadata;
import my.gov.kpn.quiz.core.model.QaPrincipal;
import my.gov.kpn.quiz.core.model.QaPrincipalRole;
import my.gov.kpn.quiz.core.model.QaRoleType;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/12/13
 */
@Table(name = "QA_PCPL_ROLE")
@Entity(name = "QaPrincipalRole")
public class QaPrincipalRoleImpl implements QaPrincipalRole {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_QA_PCPL_ROLE")
    @SequenceGenerator(name = "SEQ_QA_PCPL_ROLE", sequenceName = "SEQ_QA_PCPL_ROLE", allocationSize = 1)
    private Long id;

    @Column(name = "ROLE_TYPE")
    private QaRoleType roleType;

    @OneToOne(targetEntity = QaPrincipalImpl.class)
    @JoinColumn(name = "PRINCIPAL_ID")
    private QaPrincipal principal;

    @Embedded
    private QaMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QaRoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(QaRoleType roleType) {
        this.roleType = roleType;
    }

    public QaPrincipal getPrincipal() {
        return principal;
    }

    public void setPrincipal(QaPrincipal principal) {
        this.principal = principal;
    }

    public QaMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(QaMetadata metadata) {
        this.metadata = metadata;
    }
}
