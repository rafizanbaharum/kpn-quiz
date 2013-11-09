package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 11/7/13
 */
public interface QaParticipant extends QaMetaObject{

    /**
     * @return
     */
    QaRound getRound();

    void setRound(QaRound round);

    /**
     * @return
     */
    QaUser getUser();

    void setUser(QaUser user);
}
