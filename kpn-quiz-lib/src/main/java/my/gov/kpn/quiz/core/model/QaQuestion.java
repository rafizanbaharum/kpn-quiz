package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 11/7/13
 */
public interface QaQuestion extends QaMetaObject {

    /**
     * @return
     */
    String getStatement();

    void setStatement(String statement);

    /**
     * @return
     */
    Integer getAnswerIndex();

    void setAnswerIndex(Integer answerIndex);

    /**
     * @return
     */
    String getAnswerKey();

    void setAnswerKey(String answerKey);

    /**
     * @return
     */
    Double getWeight();

    void setWeight(Double weight);

    /**
     * @return
     */
    QaDifficulty getDifficulty();

    void setDifficulty(QaDifficulty difficulty);


    /**
     * @return
     */
    QaQuestionType getQuestionType();

    void setQuestionType(QaQuestionType questionType);


    /**
     * @return
     */
    QaQuiz getQuiz();

    void setQuiz(QaQuiz quiz);

}
