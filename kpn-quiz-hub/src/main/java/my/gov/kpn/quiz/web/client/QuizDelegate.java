package my.gov.kpn.quiz.web.client;

import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.google.gwt.user.client.rpc.RemoteService;
import my.gov.kpn.quiz.web.client.model.QuestionModel;
import my.gov.kpn.quiz.web.client.model.QuizModel;

/**
 * @author rafizan.baharum
 * @since 11/11/13
 */
public interface QuizDelegate extends RemoteService {

    ListLoadResult<QuestionModel> findCurrentQuestions();

    QuizModel loadCurrentQuiz();

    void updateAnswer(QuestionModel model, Integer answerIndex);

    void updateAnswer(QuestionModel model, String answerResponse);

    // for multiple choice and boolean
    Integer loadAnswerIndex(QuestionModel model);

    // for subjective
    String loadAnswerResponse(QuestionModel model);

    String loadResponseStatus();
}
