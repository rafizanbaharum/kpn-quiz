package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.model.QaAudit;
import my.gov.kpn.quiz.core.model.QaUser;
import my.gov.kpn.quiz.core.model.impl.QaAuditImpl;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public interface QaAuditDao extends DaoSupport<Long, QaAudit, QaAuditImpl> {

    void save(QaAudit audit, QaUser user);
}
