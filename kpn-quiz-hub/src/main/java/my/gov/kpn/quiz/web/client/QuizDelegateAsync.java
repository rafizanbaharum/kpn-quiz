package my.gov.kpn.quiz.web.client;

import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;
import my.gov.kpn.quiz.web.client.model.QuestionModel;
import my.gov.kpn.quiz.web.client.model.QuizModel;

/**
 * @author rafizan.baharum
 * @since 11/11/13
 */
public interface QuizDelegateAsync {

    void loadCurrentQuiz(AsyncCallback<QuizModel> async);

    void findCurrentQuestions(AsyncCallback<ListLoadResult<QuestionModel>> async);

    // ==================================================================================================== //
    // UPDATE ANSWER
    // ==================================================================================================== //

    // for multiple choice and boolean
    void updateAnswer(QuestionModel model, Integer answerIndex, AsyncCallback<Void> async);

    // for subjective
    void updateAnswer(QuestionModel model, String answerResponse, AsyncCallback<Void> async);

    // for multiple choice and boolean
    void updateAnswer(Long id, Integer answerIndex, AsyncCallback<Void> async);

    // for subjective
    void updateAnswer(Long id, String answerResponse, AsyncCallback<Void> async);

    // ==================================================================================================== //
    // LOAD ANSWER
    // ==================================================================================================== //

    // for multiple choice and boolean
    void loadAnswerIndex(QuestionModel model, AsyncCallback<Integer> async);

    // for subjective
    void loadAnswerResponse(QuestionModel model, AsyncCallback<String> async);

    // for multiple choice and boolean
    void loadAnswerIndex(Long id, AsyncCallback<Integer> async);

    // for subjective
    void loadAnswerResponse(Long id, AsyncCallback<String> async);

}
