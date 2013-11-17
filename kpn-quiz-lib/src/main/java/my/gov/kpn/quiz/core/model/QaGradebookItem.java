package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 11/8/13
 */
public interface QaGradebookItem extends QaMetaObject {

    /**
     * @return
     */
    QaQuestion getQuestion();

    void setQuestion(QaQuestion question);

    /**
     * @return
     */
    Integer getAnswerIndex();

    void setAnswerIndex(Integer answerIndex);

    /**
     * @return
     */
    String getAnswerResponse();

    void setAnswerResponse(String answerResponse);

    /**
     * @return
     */
    QaGradebook getGradebook();

    void setGradebook(QaGradebook gradebook);

}
