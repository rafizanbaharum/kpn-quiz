package my.gov.kpn.quiz.web.client.model;

/**
 * @author : alif haikal razak
 */
public class QuestionModel extends MetaModel {

    private static final String RED = "red";
    private static final String GREEN = "green";

    public static final String ID = "id";
    public static final String STATEMENT = "statement";
    public static final String STR_INDEX = "index";
    public static final String QUESTION_TYPE = "questionType";
    public static final String DIFFICULTY = "difficulty";
    public static final String IS_ANSWERED = "isAnswered";
    public static final String COLOUR = "color";

    private QuestionType questionType;

    public QuestionModel() {
        setColour(RED);
    }

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

    public String getIndex() {
        return get(STR_INDEX);
    }

    public void setIndex(String index) {
        set(STR_INDEX, index);
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

    public Boolean isAnswered() {
        return get(IS_ANSWERED);
    }

    public void setAnswered(Boolean answered) {
        if (answered) setColour(GREEN);
        set(IS_ANSWERED, answered);
    }

    public String getColour() {
        return get(COLOUR);
    }

    public void setColour(String colour) {
        set(COLOUR, colour);
    }

    public String toString() {
        return getStatement();
    }

}
