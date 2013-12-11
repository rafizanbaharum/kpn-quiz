package my.gov.kpn.quiz.web.client.rpc;

import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.extjs.gxt.ui.client.data.LoadConfig;
import com.extjs.gxt.ui.client.data.RpcProxy;
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
public class QuizRpcProxy extends RpcProxy<QuizModel> {

    private static final Logger log = Logger.getLogger(QuizRpcProxy.class.getName());

    private QuizDelegateAsync delegate;

    public QuizRpcProxy(QuizDelegateAsync delegate) {
        this.delegate = delegate;
    }

    @Override
    protected void load(Object loadConfig, final AsyncCallback<QuizModel> callback) {
        final LoadConfig config = (LoadConfig) loadConfig;

        delegate.loadCurrentQuiz(new SessionAwareAsyncCallback<QuizModel>() {
            @Override
            protected void doOnSuccess(QuizModel result) {
                        callback.onSuccess(result);
            }

            @Override
            protected void doOnFailure(Throwable throwable) {
                callback.onFailure(throwable);
                MessageBox.alert("Error", "Error while loading data", null);
            }
        });
//        delegate.findCurrentQuestions(
//                new SessionAwareAsyncCallback<ListLoadResult<QuestionModel>>() {
//                    @Override
//                    public void doOnFailure(Throwable throwable) {
//                        callback.onFailure(throwable);
//                        MessageBox.alert("Error", "Error while loading data", null);
//                    }
//
//                    @Override
//                    public void doOnSuccess(ListLoadResult<QuestionModel> results) {
//                        log.info("loading questions: " + results.getData().size());
//                        callback.onSuccess(results);
//                    }
//                });
    }
}
