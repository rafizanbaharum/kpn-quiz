package my.gov.kpn.quiz.biz.event;

import my.gov.kpn.quiz.biz.manager.SysManager;
import my.gov.kpn.quiz.core.model.QaAudit;
import my.gov.kpn.quiz.core.model.QaUser;
import my.gov.kpn.quiz.core.model.impl.QaAuditImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 12/20/13
 */
@Component("auditListener")
public class AuditListener implements ApplicationListener<AuditEvent> {

    @Autowired
    private SysManager sysManager;

    @Override
    public void onApplicationEvent(AuditEvent event) {
        QaUser user = event.getUser();
        Date dateLogged = event.getDateLogged();

        if (null != user && null != dateLogged) {
            QaAudit audit = new QaAuditImpl();
            audit.setUsername(user.getUsername());
            audit.setDateLogged(dateLogged);
            sysManager.saveAudit(audit);
        }
    }
}
