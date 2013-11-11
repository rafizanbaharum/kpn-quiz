package my.gov.kpn.quiz.web.server;

import my.gov.kpn.quiz.biz.manager.QuizManager;
import my.gov.kpn.quiz.biz.manager.RoundManager;
import my.gov.kpn.quiz.core.dao.QaQuizDao;
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

    @Autowired
    private QaQuizDao quizDao;

    @Autowired
    private QuizManager quizManager;

    @Autowired
    private RoundManager roundManager;

    public void startQuiz(QuizModel quizModel) {
        // do something
    }

    @Override
    public void processRound(RoundModel roundModel) throws Exception {
        QaRound round = roundManager.findRoundById(roundModel.getId());
        roundManager.processRound(round);
    }
}
