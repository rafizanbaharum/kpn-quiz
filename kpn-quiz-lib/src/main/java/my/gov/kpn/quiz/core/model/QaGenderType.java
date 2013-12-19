package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 12/19/13
 */
public enum QaGenderType {
    MALE,
    FEMALE;

    public static QaGenderType get(int index) {
        return values()[index];
    }

}
