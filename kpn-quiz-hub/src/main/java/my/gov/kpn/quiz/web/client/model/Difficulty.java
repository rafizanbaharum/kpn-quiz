package my.gov.kpn.quiz.web.client.model;

/**
 * @author rafizan.baharum
 * @since 11/12/13
 */
public enum Difficulty {

    EASY,
    INTERMEDIATE,
    DIFFICULT;

    public static Difficulty get(int index) {
        return values()[index];
    }
}
