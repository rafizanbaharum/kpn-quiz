package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 12/19/13
 */
public enum QaRaceType {

    MALAY("MALAY"),
    CHINESE("CHINESE"),
    INDIAN("INDIAN"),
    NATIVE_SABAH("NATIVE SABAH"),
    NATIVE_SARAWAK("NATIVE SARAWAK"),
    OTHERS("OTHERS");

    String description;


    QaRaceType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static QaRaceType get(int index) {
        return values()[index];
    }
}
