package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 7/15/13
 */
public enum QaQuestionType {
    MULTIPLE_CHOICE("Multiple Choice"),
    BOOLEAN("True/False"),
    SUBJECTIVE("Subjective");

    private String desc;

    QaQuestionType(String desc) {
        this.desc = desc;
    }

    public static QaQuestionType get(int index) {
        return values()[index];
    }

    public String getDesc() {
        return desc;
    }
}
