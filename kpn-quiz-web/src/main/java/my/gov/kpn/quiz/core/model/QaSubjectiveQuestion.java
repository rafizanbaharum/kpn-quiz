package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 11/7/13
 */
public interface QaSubjectiveQuestion extends QaQuestion {

    /**
     * @return
     */
    String getAnswerGuide();

    void setAnswerGuide(String answerGuide);

}
