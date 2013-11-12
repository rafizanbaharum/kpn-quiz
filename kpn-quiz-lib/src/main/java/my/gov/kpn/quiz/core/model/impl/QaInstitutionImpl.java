package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.QaInstitution;
import my.gov.kpn.quiz.core.model.QaMetadata;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 11/7/13
 */
@Table(name = "QA_INST")
@Entity(name = "QaInstitution")
@Deprecated
public class QaInstitutionImpl implements QaInstitution, Serializable {


    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_QA_INST")
    @SequenceGenerator(name = "SEQ_QA_INST", sequenceName = "SEQ_QA_INST", allocationSize = 1)
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public QaMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(QaMetadata metadata) {
        this.metadata = metadata;
    }
}
