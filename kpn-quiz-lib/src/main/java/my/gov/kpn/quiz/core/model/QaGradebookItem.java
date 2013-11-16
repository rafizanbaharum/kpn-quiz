package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 11/8/13
 */
public interface QaGradebookItem extends QaMetaObject{

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


    /**
     * @return
     */
    QaGradebook getGradebook();

    void setGradebook(QaGradebook gradebook);


}
