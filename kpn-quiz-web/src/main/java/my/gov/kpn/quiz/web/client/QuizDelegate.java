package my.gov.kpn.quiz.web.client;

import com.google.gwt.user.client.rpc.RemoteService;
import my.gov.kpn.quiz.web.client.model.QuizModel;
import my.gov.kpn.quiz.web.client.model.RoundModel;

/**
 * @author rafizan.baharum
 * @since 11/11/13
 */
public interface QuizDelegate extends RemoteService {

    void processRound(RoundModel roundModel) throws Exception;

    void startQuiz(QuizModel quizModel) throws Exception;
}
