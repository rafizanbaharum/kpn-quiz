package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.QaMetadata;
import my.gov.kpn.quiz.core.model.QaModule;
import my.gov.kpn.quiz.core.model.QaSubModule;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "QA_MODL")
@Entity(name = "QaModule")
public class QaModuleImpl implements QaModule, Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_QA_MODL")
    @SequenceGenerator(name = "SEQ_QA_MODL", sequenceName = "SEQ_QA_MODL", allocationSize = 1)
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "ALIAS")
    private String alias;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ORDR")
    private Integer order;

    @OneToMany(targetEntity = QaSubModuleImpl.class, mappedBy = "module", fetch = FetchType.EAGER)
    private Set<QaSubModule> subModules;

    @Embedded
    private QaMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Set<QaSubModule> getSubModules() {
        return subModules;
    }

    public void setSubModules(Set<QaSubModule> subModules) {
        this.subModules = subModules;
    }

    public QaMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(QaMetadata metadata) {
        this.metadata = metadata;
    }
}
