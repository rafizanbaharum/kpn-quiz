package my.gov.kpn.quiz.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/7/13
 */
public interface QaRound {

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
    List<QaParticipant> getParticipants();

    void setParticipants(List<QaParticipant> participants);
}
