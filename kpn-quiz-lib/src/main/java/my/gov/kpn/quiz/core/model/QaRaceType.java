package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 12/19/13
 */
public enum QaRaceType {

    MALAY("MELAYU"),
    CHINESE("CINA"),
    INDIAN("INDIA"),
    NATIVE_SABAH("BUMIPUTERA SABAH"),
    NATIVE_SARAWAK("BUMIPUTERA SARAWAK"),
    OTHERS("LAIN LAIN");

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
