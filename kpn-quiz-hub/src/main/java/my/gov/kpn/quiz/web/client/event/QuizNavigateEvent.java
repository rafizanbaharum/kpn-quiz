package my.gov.kpn.quiz.web.client.event;

import com.extjs.gxt.ui.client.event.BaseEvent;
import my.gov.kpn.quiz.web.client.model.QuestionModel;

/**
 * @author rafizan.baharum
 * @since 11/14/13
 */
public class QuizNavigateEvent extends BaseEvent {

    public QuizNavigateEvent(Object source, int nextQuestionIndex, int prevQuestionIndex) {
        super(source);
    }

    private int nextQuestionIndex;
    private int previousQuestionIndex;
    private int previousAnswerIndex;
    private String previousAnswer;
    private QuestionModel question;

    public int getNextQuestionIndex() {
        return nextQuestionIndex;
    }

    public void setNextQuestionIndex(int nextQuestionIndex) {
        this.nextQuestionIndex = nextQuestionIndex;
    }

    public int getPreviousQuestionIndex() {
        return previousQuestionIndex;
    }

    public void setPreviousQuestionIndex(int previousQuestionIndex) {
        this.previousQuestionIndex = previousQuestionIndex;
    }

    public int getPreviousAnswerIndex() {
        return previousAnswerIndex;
    }

    public void setPreviousAnswerIndex(int previousAnswerIndex) {
        this.previousAnswerIndex = previousAnswerIndex;
    }

    public String getPreviousAnswer() {
        return previousAnswer;
    }

    public void setPreviousAnswer(String previousAnswer) {
        this.previousAnswer = previousAnswer;
    }

    public QuestionModel getQuestion() {
        return question;
    }

    public void setQuestion(QuestionModel question) {
        this.question = question;
    }
}
