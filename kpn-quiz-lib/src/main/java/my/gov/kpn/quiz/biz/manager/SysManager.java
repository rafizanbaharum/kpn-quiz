package my.gov.kpn.quiz.biz.manager;


import my.gov.kpn.quiz.core.model.QaAudit;
import my.gov.kpn.quiz.core.model.QaUser;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public interface SysManager {

    void recoverPassword(QaUser user);

    void saveAudit(QaAudit audit);
}
