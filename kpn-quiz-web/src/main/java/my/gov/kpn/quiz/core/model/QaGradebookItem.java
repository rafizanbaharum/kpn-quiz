package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 11/8/13
 */
public interface QaGradebookItem {

    /**
     * @return
     */
    QaQuestion getQuestion();

    void setQuestion(QaQuestion question);

    /**
     * @return
     */
    QaAnswer getAnswer();

    void setAnswer(QaAnswer answer);


}
