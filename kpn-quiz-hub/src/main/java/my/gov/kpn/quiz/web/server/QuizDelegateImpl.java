package my.gov.kpn.quiz.web.server;

import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.ListLoadResult;
import my.gov.kpn.quiz.biz.manager.QuizManager;
import my.gov.kpn.quiz.biz.manager.RoundManager;
import my.gov.kpn.quiz.biz.util.Utils;
import my.gov.kpn.quiz.core.dao.QaQuizDao;
import my.gov.kpn.quiz.core.model.*;
import my.gov.kpn.quiz.web.client.QuizDelegate;
import my.gov.kpn.quiz.web.client.model.QuestionModel;
import my.gov.kpn.quiz.web.client.model.QuizModel;
import my.gov.kpn.quiz.web.client.model.RoundModel;
import my.gov.kpn.quiz.web.common.AutoInjectingRemoteServiceServlet;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/10/13
 */
public class QuizDelegateImpl extends AutoInjectingRemoteServiceServlet implements QuizDelegate {

    private static final Logger log = Logger.getLogger(QuizDelegateImpl.class);

    @Autowired
    private QaQuizDao quizDao;

    @Autowired
    private QuizManager quizManager;

    @Autowired
    private RoundManager roundManager;

    @Autowired
    private QuizConverter quizConverter;

    public void startQuiz(QuizModel quizModel) {
        // do something
    }

    @Override
    public void processRound(RoundModel roundModel) throws Exception {
        QaRound round = roundManager.findRoundById(roundModel.getId());
        roundManager.processRound(round);
    }

    @Override
    public ListLoadResult<QuestionModel> findCurrentQuestions() {
        ArrayList<QuestionModel> models = new ArrayList<QuestionModel>();
        QaQuiz quiz = GlobalRegistry.getQuiz();
        List<QaQuestion> questions = quizManager.findQuestions(quiz);
        for (QaQuestion question : questions) {
            models.add(quizConverter.convert(question));
        }
        return new BaseListLoadResult(models);
    }

    @Override
    public void updateAnswer(QuestionModel model, String answerIndex) {
        log.debug("question: " + model.getStatement());
        log.debug("answer: " + answerIndex);

        QaQuestion question = quizManager.findQuestionById(model.getId());
        QaQuiz quiz = GlobalRegistry.getQuiz();
        QaUser user = Utils.getCurrentUser();
        QaParticipant participant = quizManager.findParticipant(quiz, user);

        quizManager.updateAnswer(participant, question);


    }
}
