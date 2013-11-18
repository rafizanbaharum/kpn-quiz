package my.gov.kpn.quiz.core.model;

import java.util.Date;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/7/13
 */
public interface QaQuiz extends QaMetaObject {

    /**
     * @return
     */
    String getTitle();

    void setTitle(String title);

    /**
     * @return
     */
    Integer getRound();

    void setRound(Integer round);

    /**
     * @return
     */
    Date getStartDate();

    void setStartDate(Date startDate);

    /**
     * @return
     */
    Date getEndDate();

    void setEndDate(Date endDate);

    /**
     * @return
     */
    boolean isCurrent();

    void setCurrent(boolean current);

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
    List<QaQuestion> getQuestions();

    void setQuestions(List<QaQuestion> questions);

    /**
     * @return
     */
    List<QaParticipant> getParticipants();

    void setParticipants(List<QaParticipant> participants);


    /**
     * @return
     */
    List<QaGradebook> getGradebooks();

    void setGradebooks(List<QaGradebook> gradebooks);

}

