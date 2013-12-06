package my.gov.kpn.quiz.web.client.model;

/**
 * @author rafizan.baharum
 * @since 11/12/13
 */
public class SubjectiveQuestionModel extends QuestionModel {

    public static final String WORD_LIMIT = "wordLimit";

    public Integer getWordLimit() {
        return get(WORD_LIMIT);
    }

    public void setWordLimit(Integer wordLimit) {
        set(WORD_LIMIT, wordLimit);
    }
}
