package my.gov.kpn.quiz.core.model;

import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 11/7/13
 */
public interface QaAudit extends QaMetaObject {

    /**
     * @return
     */
    String getUsername();

    void setUsername(String username);

    /**
     * @return
     */
    Date getDateLogged();

    void setDateLogged(Date dateLogged);

}
