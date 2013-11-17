package my.gov.kpn.quiz.web.model;

/**
 * @author rafizan.baharum
 * @since 11/15/13
 */
public class QuestionModel extends MetaModel {

    private String statement;
    private String answerKey;
    private int weight;
    private int difficulty;

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getAnswerKey() {
        return answerKey;
    }

    public void setAnswerKey(String answerKey) {
        this.answerKey = answerKey;
    }
}
