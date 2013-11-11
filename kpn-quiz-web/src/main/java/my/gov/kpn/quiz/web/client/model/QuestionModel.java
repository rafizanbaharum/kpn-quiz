package my.gov.kpn.quiz.web.client.model;

/**
 * @author : alif haikal razak
 */
public class QuestionModel extends MetaModel {

    public static final String ID = "id";
    public static final String STATEMENT = "statement";

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

    public String toString() {
        return getStatement();
    }

}
