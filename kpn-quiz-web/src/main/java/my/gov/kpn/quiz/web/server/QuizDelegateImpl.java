package my.gov.kpn.quiz.web.server;

import my.gov.kpn.quiz.biz.manager.QuizManager;
import my.gov.kpn.quiz.biz.manager.RoundManager;
import my.gov.kpn.quiz.core.dao.QaQuizDao;
import my.gov.kpn.quiz.core.model.QaQuiz;
import my.gov.kpn.quiz.core.model.QaRound;
import my.gov.kpn.quiz.web.client.QuizDelegate;
import my.gov.kpn.quiz.web.client.model.QuizModel;
import my.gov.kpn.quiz.web.client.model.RoundModel;
import my.gov.kpn.quiz.web.server.common.AutoInjectingRemoteServiceServlet;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author rafizan.baharum
 * @since 11/10/13
 */
public class QuizDelegateImpl extends AutoInjectingRemoteServiceServlet implements QuizDelegate {

    public static final String CURRENT_QUIZ = "__currentQuiz__";

    @Autowired
    private QaQuizDao quizDao;

    @Autowired
    private QuizManager quizManager;

    @Autowired
    private RoundManager roundManager;


    // TODO: put in global singleton
    // TODO: http://stackoverflow.com/questions/14645047/spring-injecting-a-static-global-singleton
    // TODO: is this feasible???? what if we have many instance of the app???
    public void startQuiz(QuizModel quizModel) {
        QaQuiz quiz = quizDao.findById(quizModel.getId());
        getThreadLocalRequest().getSession().setAttribute(CURRENT_QUIZ, quiz);
    }

    @Override
    public void processRound(RoundModel roundModel) throws Exception {
        QaRound round = roundManager.findRoundById(roundModel.getId());
        roundManager.processRound(round);
    }
}
