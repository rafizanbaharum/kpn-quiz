package my.gov.kpn.quiz.web.model;

/**
 * @author rafizan.baharum
 * @since 11/15/13
 */
public class SubjectiveQuestionModel extends QuestionModel {

    private Integer wordLimit;
    private String answerGuide;

    public Integer getWordLimit() {
        return wordLimit;
    }

    public void setWordLimit(Integer wordLimit) {
        this.wordLimit = wordLimit;
    }

    public String getAnswerGuide() {
        return answerGuide;
    }

    public void setAnswerGuide(String answerGuide) {
        this.answerGuide = answerGuide;
    }
}
