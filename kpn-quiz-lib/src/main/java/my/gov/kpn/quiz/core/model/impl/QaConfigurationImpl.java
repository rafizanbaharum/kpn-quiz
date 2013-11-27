package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.QaConfiguration;
import my.gov.kpn.quiz.core.model.QaMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author rafizan.baharum
 * @since 11/27/13
 */
@Entity(name = "QaConfiguration")
@Table(name = "QA_CFGN")
public class QaConfigurationImpl implements QaConfiguration, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_QA_CFGN")
    @SequenceGenerator(name = "SEQ_QA_CFGN", sequenceName = "SEQ_QA_CFGN", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "CONFIG_KEY", nullable = false)
    private String key;

    @Column(name = "CONFIG_VALUE")
    private String value;

    @Column(name = "DESCRIPTION")
    private String description;

    @Embedded
    private QaMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public QaMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(QaMetadata metadata) {
        this.metadata = metadata;
    }

    @Transient
    public Integer getValueAsInteger() {
        if (null != getValue())
            return new Integer(getValue());
        else return 0;
    }

    @Transient
    public Double getValueAsDouble() {
        if (null != getValue())
            return new Double(getValue());
        else return 0d;
    }

    @Transient
    public Long getValueAsLong() {
        if (null != getValue())
            return new Long(getValue());
        else return 0l;
    }

    @Transient
    public BigDecimal getValueAsBigDecimal() {
        if (null != getValue())
            return new BigDecimal(getValue());
        else return BigDecimal.ZERO;
    }

}
