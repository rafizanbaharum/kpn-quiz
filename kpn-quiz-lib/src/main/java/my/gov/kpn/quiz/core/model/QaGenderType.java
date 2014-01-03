package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 12/19/13
 */
public enum QaGenderType {
    MALE("MALE"),
    FEMALE("FEMALE");

    private String description;

    private QaGenderType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static QaGenderType get(int index) {
        return values()[index];
    }


}
