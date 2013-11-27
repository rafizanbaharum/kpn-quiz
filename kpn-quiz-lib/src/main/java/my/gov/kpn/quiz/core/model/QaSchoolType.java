package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 7/15/13
 */
public enum QaSchoolType {

    SMK,
    PRIVATEW,
    SBP,
    SMK_TEKNIK,
    SMKJ_C,
    SMKJ_T,
    SMA,
    MRSM;

    public static QaSchoolType get(int index) {
        return values()[index];
    }

}
