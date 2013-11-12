package my.gov.kpn.quiz.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/7/13
 */
public interface QaCompetition extends QaMetaObject{

    /**
     * @return
     */
    Integer getYear();

    void setYear(Integer year);

    /**
     * @return
     */
    boolean isLocked();

    void setLocked(boolean locked);

    /**
     * @return
     */
    List<QaRound> getRounds();

    void setRounds(List<QaRound> rounds);
}
