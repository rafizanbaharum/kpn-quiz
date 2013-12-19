package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.QaAudit;
import my.gov.kpn.quiz.core.model.QaMetadata;

import javax.persistence.*;
import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 12/19/13
 */
@Table(name = "QA_AUDT")
@Entity(name = "QaAudit")
public class QaAuditImpl implements QaAudit {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_QA_AUDT")
    @SequenceGenerator(name = "SEQ_QA_AUDT", sequenceName = "SEQ_QA_AUDT", allocationSize = 1)
    private Long id;

    @Column(name = "USERNAME", unique = true)
    private String username;

    @Column(name = "DATE_LOGGED", unique = true)
    private Date dateLogged;

    @Embedded
    private QaMetadata metadata = new QaMetadata();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDateLogged() {
        return dateLogged;
    }

    public void setDateLogged(Date dateLogged) {
        this.dateLogged = dateLogged;
    }

    public QaMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(QaMetadata metadata) {
        this.metadata = metadata;
    }
}

