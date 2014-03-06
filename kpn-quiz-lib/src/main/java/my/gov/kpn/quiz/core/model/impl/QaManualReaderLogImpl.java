package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.QaManualReaderLog;

import javax.naming.ldap.PagedResultsControl;
import javax.persistence.*;
import java.util.Date;

@Table(name = "MA_RD_LG")
@Entity(name = "MaReaderLog")
@Inheritance(strategy = InheritanceType.JOINED)
public class QaManualReaderLogImpl implements QaManualReaderLog {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_MA_RD_LG")
    @SequenceGenerator(name = "SEQ_MA_RD_LG", sequenceName = "SEQ_MA_RD_LG", allocationSize = 1)
    private Long id;

    @Column(name = "FILENAME")
    private String filename;

    @Column(name = "STATUS")
    private Boolean status;

    @Column(name = "ERROR")
    private String error;

    @Column(name = "M_TS")
    private Date timestamp;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public Date getTimestamp() {
        return null;
    }

    @Override
    public void setTimestamp(Date timestamp) {

    }
}
