package my.gov.kpn.quiz.web.listener;

import my.gov.kpn.quiz.biz.manager.QuizManager;
import my.gov.kpn.quiz.core.model.QaQuiz;
import my.gov.kpn.quiz.web.server.GlobalRegistry;
import my.gov.kpn.quiz.web.server.common.AutoInjectingServletContextListener;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author rafizan.baharum
 * @since 11/11/13
 */
public class QuizStartupListener extends AutoInjectingServletContextListener {

    @Autowired
    private QuizManager quizManager;

    @Override
    protected void doContextInitialized() {
        QaQuiz currentQuiz = quizManager.getCurrentQuiz();
        GlobalRegistry.setQuiz(currentQuiz);
    }

    @Override
    protected void doContextDestroyed() {
        // TODO:

    }
}
