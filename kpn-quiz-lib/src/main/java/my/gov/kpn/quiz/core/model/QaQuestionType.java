package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 7/15/13
 */
public enum QaQuestionType {
    MULTIPLE_CHOICE,
    BOOLEAN,
    SUBJECTIVE;

    public static QaQuestionType get(int index) {
        return values()[index];
    }

}
