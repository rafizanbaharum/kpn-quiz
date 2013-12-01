package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 7/15/13
 */
public enum QaParticipantSortType {

    SCHOOL,
    DISTRICT,
    STATE;

    public static QaParticipantSortType get(int index) {
        return values()[index];
    }

}
