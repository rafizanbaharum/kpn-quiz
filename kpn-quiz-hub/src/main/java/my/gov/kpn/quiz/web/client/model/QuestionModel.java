package my.gov.kpn.quiz.web.client.model;

/**
 * @author : alif haikal razak
 */
public class QuestionModel extends MetaModel {

    public static final String ID = "id";
    public static final String STATEMENT = "statement";
    public static final String QUESTION_TYPE = "questionType";
    public static final String DIFFICULTY = "difficulty";

    private QuestionType questionType;

    public Long getId() {
        return get(ID);
    }

    public void setId(Long id) {
        set(ID, id);
    }

    public String getStatement() {
        return get(STATEMENT);
    }

    public void setStatement(String statement) {
        set(STATEMENT, statement);
    }

    public QuestionType getQuestionType() {
        return get(QUESTION_TYPE);
    }

    public void setQuestionType(QuestionType questionType) {
        set(QUESTION_TYPE, questionType);
    }

    public Difficulty getDifficulty() {
        return get(DIFFICULTY);
    }

    public void setDifficulty(Difficulty difficulty) {
        set(DIFFICULTY, difficulty);
    }

    public String toString() {
        return getStatement();
    }

}
