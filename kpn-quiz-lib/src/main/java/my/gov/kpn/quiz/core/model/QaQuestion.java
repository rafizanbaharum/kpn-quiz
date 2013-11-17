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
     * For MultipleChoiceQuestion
     * 1-A
     * 2-B
     * 3-C
     * 4-D
     * <p/>
     * For BooleanQuestion
     * O-FALSE
     * 1-TRUE
     * <p/>
     * N/A to SubjectiveQuestion
     *
     * @return
     */
    Integer getAnswerIndex();

    void setAnswerIndex(Integer answerIndex);

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
