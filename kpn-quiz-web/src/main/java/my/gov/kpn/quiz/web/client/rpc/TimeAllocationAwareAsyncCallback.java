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
public abstract class TimeAllocationAwareAsyncCallback<T> extends SessionAwareAsyncCallback<T> {

    protected TimeAllocationAwareAsyncCallback() {
    }

    @Override
    public void onSuccess(T returnObject) {
        doOnSuccess(returnObject);
    }


    @Override
    public void onFailure(Throwable exception) {
        if (exception instanceof StatusCodeException) {
            if (504 == ((StatusCodeException) exception).getStatusCode()) {
                MessageBox.info("Session timeout", "Please log in",
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
