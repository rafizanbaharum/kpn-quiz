package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 11/7/13
 */
public interface QaQuestion {

    /**
     * @return
     */
    String getTitle();

    void setTitle(String title);

    /**
     * @return
     */
    Double getWeight();

    void setWeight(Double weight);

    /**
     * @return
     */
    QaQuiz getQuiz();

    void setQuiz(QaQuiz quiz);

}
