package my.gov.kpn.quiz.web.client.controller;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.View;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import my.gov.kpn.quiz.web.client.QuizConstants;
import my.gov.kpn.quiz.web.client.QuizDelegate;
import my.gov.kpn.quiz.web.client.QuizDelegateAsync;
import my.gov.kpn.quiz.web.client.QuizEvents;
import my.gov.kpn.quiz.web.client.view.QuizView;

import java.util.logging.Logger;

/**
 * @author rafizan.baharum
 * @since 10/20/13
 */
public class QuizController extends Controller {

    private static final Logger log = Logger.getLogger(QuizController.class.getName());
    protected View view;

    public QuizController() {
        registerEventTypes(QuizEvents.InitApplicationModel);
        registerEventTypes(QuizEvents.InitApplicationModule);
        registerEventTypes(QuizEvents.InitApplicationView);
        registerEventTypes(QuizEvents.InitApplicationController);
        registerEventTypes(QuizEvents.ApplicationError);
    }

    @Override
    protected void initialize() {
        super.initialize();

        QuizDelegateAsync delegate = (QuizDelegateAsync) GWT.create(QuizDelegate.class);
        ((ServiceDefTarget) delegate).setServiceEntryPoint(GWT.getModuleBaseURL() + QuizConstants.ENDPOINT_QUIZ);
        Registry.register(QuizConstants.DELEGATE_QUIZ, delegate);
//        Registry.register(QuizConstants.MESSAGE_APP, GWT.create(QuizMessage.class));
        view = new QuizView(this);
    }

    public void handleEvent(AppEvent event) {
        EventType type = event.getType();
        if (type == QuizEvents.InitApplicationModel) {
            forwardToView(view, event);
        } else if (type == QuizEvents.InitApplicationController) {
            forwardToView(view, event);
        } else if (type == QuizEvents.InitApplicationView) {
            forwardToView(view, event);
        } else if (type == QuizEvents.InitApplicationModule) {
            forwardToView(view, event);
        } else if (type == QuizEvents.ApplicationError) {
            onError(event);
        }
    }

    protected void onError(AppEvent ae) {
        log.severe("error: " + ae.toString());
    }
}
