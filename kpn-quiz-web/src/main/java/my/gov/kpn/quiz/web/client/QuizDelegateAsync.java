package my.gov.kpn.quiz.web.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import my.gov.kpn.quiz.web.client.model.QuizModel;
import my.gov.kpn.quiz.web.client.model.RoundModel;

/**
 * @author rafizan.baharum
 * @since 11/11/13
 */
public interface QuizDelegateAsync {

    void processRound(RoundModel roundModel, AsyncCallback<Void> async);

    void startQuiz(QuizModel quizModel, AsyncCallback<Void> async);
}