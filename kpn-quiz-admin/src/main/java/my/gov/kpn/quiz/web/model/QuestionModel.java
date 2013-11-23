package my.gov.kpn.quiz.web.model;


import org.apache.commons.lang.StringUtils;

/**
 * @author rafizan.baharum
 * @since 11/15/13
 */
public abstract class QuestionModel extends MetaModel {

    private String statement;
    private String statementAbbreviated;
    private int questionType;
    private String questionTypeString;
    private int answerIndex;
    private int difficulty;
    private QuizModel quiz;

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
        this.setStatementAbbreviated(StringUtils.abbreviate(statement, 40));
    }

    public String getStatementAbbreviated() {
        return statementAbbreviated;
    }

    public void setStatementAbbreviated(String statementAbbreviated) {
        this.statementAbbreviated = statementAbbreviated;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getAnswerIndex() {
        return answerIndex;
    }

    public void setAnswerIndex(int answerIndex) {
        this.answerIndex = answerIndex;
    }

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public String getQuestionTypeString() {
        return questionTypeString;
    }

    public void setQuestionTypeString(String questionTypeString) {
        this.questionTypeString = questionTypeString;
    }

    public QuizModel getQuiz() {
        return quiz;
    }

    public void setQuiz(QuizModel quiz) {
        this.quiz = quiz;
    }

    @Override
    public String toString() {
        return "QuestionModel{" +
                "id='" + getId() + '\'' +
                '}';
    }
}
