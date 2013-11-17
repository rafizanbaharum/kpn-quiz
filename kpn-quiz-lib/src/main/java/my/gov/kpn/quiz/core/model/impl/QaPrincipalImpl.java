package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.QaMetadata;
import my.gov.kpn.quiz.core.model.QaPrincipal;
import my.gov.kpn.quiz.core.model.QaPrincipalRole;
import my.gov.kpn.quiz.core.model.QaPrincipalType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "QA_PCPL")
@Entity(name = "QaPrincipal")
@Inheritance(strategy = InheritanceType.JOINED)
public class QaPrincipalImpl implements QaPrincipal, Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_QA_PCPL")
    @SequenceGenerator(name = "SEQ_QA_PCPL", sequenceName = "SEQ_QA_PCPL", allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ENABLED")
    private boolean enabled = true; // default to enabled

    @Column(name = "LOCKED")
    private boolean locked;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "PRINCIPAL_TYPE")
    private QaPrincipalType principalType;

    @OneToMany(targetEntity = QaPrincipalRoleImpl.class, mappedBy = "principal", fetch = FetchType.EAGER)
    private Set<QaPrincipalRole> roles;

    @Embedded
    private QaMetadata metadata = new QaMetadata();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public QaPrincipalType getPrincipalType() {
        return principalType;
    }

    public void setPrincipalType(QaPrincipalType principalType) {
        this.principalType = principalType;
    }

    public Set<QaPrincipalRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<QaPrincipalRole> roles) {
        this.roles = roles;
    }

    public QaMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(QaMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "CmPrincipalImpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + locked +
                '}';
    }
}
