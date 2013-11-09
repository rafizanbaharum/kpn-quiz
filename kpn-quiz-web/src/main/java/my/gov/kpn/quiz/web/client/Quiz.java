package my.gov.kpn.quiz.web.client;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.util.Theme;
import com.extjs.gxt.ui.client.util.ThemeManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.logging.impl.FormatterImpl;
import my.gov.kpn.quiz.web.client.controller.QuizController;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Quiz implements EntryPoint {

    public static final Logger log = Logger.getLogger(Quiz.class.getName());

    static {
        Handler handlers[] = Logger.getLogger("").getHandlers();
        for (Handler handler : handlers) {
            handler.setFormatter(new CustomFormatter(false));
        }
    }

    public void onModuleLoad() {
        ThemeManager.register(Theme.GRAY);
        GXT.setDefaultTheme(Theme.GRAY, true);

        if (!GWT.isScript()) { // hosted
            GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {
                public void onUncaughtException(Throwable e) {
                    e.printStackTrace();
                }
            });
        }

        // loading system delegate
//        AmDelegateAsync amDelegate = (AmDelegateAsync) GWT.create(AmDelegate.class);
//        ((ServiceDefTarget) amDelegate).setServiceEntryPoint(GWT.getModuleBaseURL() + QuizConstants.ENDPOINT_AM);
//        Registry.register(QuizConstants.DELEGATE_AM, amDelegate);

        // add main application controller
        // trigger InitApplicationModel event
        Dispatcher dispatcher = Dispatcher.get();
        dispatcher.addController(new QuizController());
        dispatcher.dispatch(QuizEvents.InitApplicationModel);
    }

    /**
     * Custom logger formatter
     */
    static class CustomFormatter extends FormatterImpl {

        private boolean showStackTraces;
        private final DateTimeFormat dtFormat = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss");


        public CustomFormatter(boolean showStackTraces) {
            this.showStackTraces = showStackTraces;
        }

        @Override
        public String format(LogRecord event) {
            StringBuilder message = new StringBuilder();
            message.append(getRecordInfo(event, " "));
            message.append(event.getMessage());
            if (showStackTraces) {
                message.append(getStackTraceAsString(event.getThrown(), "\n", "\t"));
            }
            return message.toString();
        }

        /**
         * Date date = new Date(event.getMillis());
         * s.append(dtFormat.format(date));
         *
         * @param event
         * @param newline
         * @return
         */
        @Override
        protected String getRecordInfo(LogRecord event, String newline) {
            StringBuilder s = new StringBuilder();
            String loggerName = event.getLoggerName();
            s.append(event.getLevel().getName());
            s.append(": ");
            s.append(loggerName.substring(loggerName.lastIndexOf('.') + 1));
            s.append(": ");
            return s.toString();
        }
    }
}