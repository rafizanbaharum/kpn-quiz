package my.gov.kpn.quiz.web.client.model;

/**
 * @author rafizan.baharum
 * @since 11/12/13
 */
public enum QuestionType {
    MULTIPLE_CHOICE,
    BOOLEAN,
    SUBJECTIVE;

    public static QuestionType get(int index) {
        return values()[index];
    }

}
