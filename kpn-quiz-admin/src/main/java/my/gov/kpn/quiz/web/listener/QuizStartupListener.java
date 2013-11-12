package my.gov.kpn.quiz.web.listener;

import my.gov.kpn.quiz.biz.manager.QuizManager;
import my.gov.kpn.quiz.core.model.QaQuiz;
import my.gov.kpn.quiz.web.common.GlobalRegistry;
import my.gov.kpn.quiz.web.common.AutoInjectingServletContextListener;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author rafizan.baharum
 * @since 11/11/13
 */
public class QuizStartupListener extends AutoInjectingServletContextListener {

    private static final Logger log = Logger.getLogger(QuizStartupListener.class);

    @Autowired
    private QuizManager quizManager;

    @Override
    protected void doContextInitialized() {
        QaQuiz currentQuiz = quizManager.getCurrentQuiz();
        if (null != currentQuiz) {
            log.debug("loading quiz: " + currentQuiz.getTitle());
            GlobalRegistry.setQuiz(currentQuiz);
        }
    }

    @Override
    protected void doContextDestroyed() {
        // TODO:

    }
}
