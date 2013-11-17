package my.gov.kpn.quiz.web.server;

import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.ListLoadResult;
import my.gov.kpn.quiz.biz.manager.CompetitionManager;
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
    private CompetitionManager competitionManager;

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
        List<QaQuestion> questions = competitionManager.findQuestions(quiz);
        for (QaQuestion question : questions) {
            models.add(quizConverter.convert(question));
        }
        return new BaseListLoadResult(models);
    }

    @Override
    public void updateAnswer(QuestionModel model, String answerIndex) {
        log.debug("question: " + model.getStatement());
        log.debug("answer: " + answerIndex);

        QaQuestion question = competitionManager.findQuestionById(model.getId());
        QaQuiz quiz = GlobalRegistry.getQuiz();
        QaUser user = Utils.getCurrentUser();
        QaParticipant participant = competitionManager.findParticipant(quiz, user);

        competitionManager.updateAnswer(participant, question);
    }
}
