package my.gov.kpn.quiz.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/7/13
 */
public interface QaRound extends QaMetaObject{

    /**
     * @return
     */
    boolean isProcessed();

    void setProcessed(boolean processed);

    /**
     * @return
     */
    boolean isLocked();

    void setLocked(boolean locked);

    /**
     * @return
     */
    QaCompetition getCompetition();

    void setCompetition(QaCompetition competition);

    /**
     * @return
     */
    List<QaParticipant> getParticipants();

    void setParticipants(List<QaParticipant> participants);
}
