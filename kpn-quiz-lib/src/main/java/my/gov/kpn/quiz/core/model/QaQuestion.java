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
     * 0-A
     * 1-B
     * 2-C
     * 3-D
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
