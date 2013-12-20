package my.gov.kpn.quiz.biz.event;

import my.gov.kpn.quiz.core.model.QaUser;
import org.springframework.context.ApplicationEvent;

import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 12/20/13
 */
public class AuditEvent extends ApplicationEvent {

    private QaUser user;
    private Date dateLogged;

    public AuditEvent(QaUser user, Date dateLogged) {
        super(user);
        this.user = user;
        this.dateLogged = dateLogged;
    }

    public QaUser getUser() {
        return user;
    }

    public void setUser(QaUser user) {
        this.user = user;
    }

    public Date getDateLogged() {
        return dateLogged;
    }

    public void setDateLogged(Date dateLogged) {
        this.dateLogged = dateLogged;
    }
}
