package my.gov.kpn.quiz.web.model;

/**
 * @author rafizan.baharum
 * @since 11/15/13
 */
public class SubjectiveQuestionModel extends QuestionModel {

    private String answerGuide;

    public String getAnswerGuide() {
        return answerGuide;
    }

    public void setAnswerGuide(String answerGuide) {
        this.answerGuide = answerGuide;
    }
}
