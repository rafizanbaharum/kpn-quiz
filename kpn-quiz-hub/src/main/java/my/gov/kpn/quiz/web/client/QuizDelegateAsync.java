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

    void findCurrentQuestions(AsyncCallback<ListLoadResult<QuestionModel>> async);

    // for multiple choice and boolean
    void updateAnswer(QuestionModel model, Integer answerIndex, AsyncCallback<Void> async);

    // for subjective
    void updateAnswer(QuestionModel model, String answerResponse, AsyncCallback<Void> async);

}
