package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface QaStudent extends QaActor {

    /**
     * @return
     */
    QaInstitution getInstitution();

    void setInstitution(QaInstitution institution);

}
