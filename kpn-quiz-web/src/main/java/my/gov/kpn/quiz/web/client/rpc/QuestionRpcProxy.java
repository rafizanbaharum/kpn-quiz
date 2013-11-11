package my.gov.kpn.quiz.web.client.rpc;

import com.extjs.gxt.ui.client.data.*;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.google.gwt.user.client.rpc.AsyncCallback;
import my.gov.kpn.quiz.web.client.QuizDelegateAsync;
import my.gov.kpn.quiz.web.client.model.QuestionModel;
import my.gov.kpn.quiz.web.client.model.QuizModel;

import java.util.logging.Logger;

/**
 * @author rafizan.baharum
 * @since 11/11/13
 */
public class QuestionRpcProxy extends RpcProxy<ListLoadResult<QuestionModel>> {

    private static final Logger log = Logger.getLogger(QuestionRpcProxy.class.getName());

    public static final String QUIZ = "quiz";

    private QuizDelegateAsync delegate;

    public QuestionRpcProxy(QuizDelegateAsync delegate) {
        this.delegate = delegate;
    }

    @Override
    protected void load(Object loadConfig, final AsyncCallback<ListLoadResult<QuestionModel>> callback) {
        final LoadConfig config = (LoadConfig) loadConfig;

        delegate.findQuestions(
                (QuizModel) config.get(QUIZ),
                new SessionAwareAsyncCallback<ListLoadResult<QuestionModel>>() {
                    @Override
                    public void doOnFailure(Throwable throwable) {
                        callback.onFailure(throwable);
                        MessageBox.alert("Error", "Error while loading data", null);
                    }

                    @Override
                    public void doOnSuccess(ListLoadResult<QuestionModel> results) {
                        callback.onSuccess(results);
                    }
                });
    }
}
