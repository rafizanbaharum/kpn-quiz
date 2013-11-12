package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 11/8/13
 */
public enum QaDifficulty {

    EASY,
    INTERMEDIATE,
    DIFFICULT;

    public static QaDifficulty get(int index) {
        return values()[index];
    }
}
