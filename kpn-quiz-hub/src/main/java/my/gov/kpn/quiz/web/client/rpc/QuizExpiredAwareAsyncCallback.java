package my.gov.kpn.quiz.web.client.rpc;

import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.google.gwt.user.client.rpc.StatusCodeException;

import static com.extjs.gxt.ui.client.widget.Dialog.OK;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public abstract class QuizExpiredAwareAsyncCallback<T> extends SessionAwareAsyncCallback<T> {

    protected QuizExpiredAwareAsyncCallback() {
    }

    @Override
    public void onSuccess(T returnObject) {
        doOnSuccess(returnObject);
    }

    // check what quiz is running in ThreadLocal
    // then timeout based on quiz.endDate
    @Override
    public void onFailure(Throwable exception) {
        if (exception instanceof StatusCodeException) {
            if (410 == ((StatusCodeException) exception).getStatusCode()) {
                MessageBox.info("Quiz timeout", "Please log out",
                        new Listener<MessageBoxEvent>() {
                            @Override
                            public void handleEvent(MessageBoxEvent be) {
                                final Button button = be.getButtonClicked();
                                if ("OK".equals(button.getText())) {
                                    logout();
                                }
                            }
                        }
                ).setButtons(OK);
            }
        } else {
            doOnFailure(exception);
        }
    }

    protected abstract void doOnSuccess(T returnObject);

    protected abstract void doOnFailure(Throwable exception);
}
