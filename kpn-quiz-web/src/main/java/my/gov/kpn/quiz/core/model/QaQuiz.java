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
    QaRound getRound();

    void setRound(QaRound round);


    /**
     * @return
     */
    List<QaQuestion> getQuestions();

    void setQuestions(List<QaQuestion> questions);
}
