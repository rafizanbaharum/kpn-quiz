package my.gov.kpn.quiz.biz.manager;


import my.gov.kpn.quiz.core.model.QaActor;
import my.gov.kpn.quiz.core.model.QaInstructor;
import my.gov.kpn.quiz.core.model.QaStudent;
import my.gov.kpn.quiz.core.model.QaUser;

import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public interface SysManager {

    void recoverPassword(QaUser user);
}
