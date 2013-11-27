package my.gov.kpn.quiz.core.model;

import java.util.Date;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/7/13
 */
public interface QaCompetition extends QaMetaObject {

    /**
     * @return
     */
    Integer getYear();

    void setYear(Integer year);


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
    boolean isLocked();

    void setLocked(boolean locked);

    /**
     * @return
     */
    List<QaQuiz> getQuizzes();

    void setQuizzes(List<QaQuiz> quizzes);
}
