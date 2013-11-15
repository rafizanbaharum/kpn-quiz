package my.gov.kpn.quiz.web.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 10/20/13
 */
public class MetaModel implements Serializable {

    private Long id;
    private String metaState;
    private Date createdDate;
    private Date modifiedDate;
    private Date deletedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMetaState() {
        return metaState;
    }

    public void setMetaState(String metaState) {
        this.metaState = metaState;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Date getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }
}


