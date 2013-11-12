package my.gov.kpn.quiz.web.server;

import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.ListLoadResult;
import my.gov.kpn.quiz.biz.manager.QuizManager;
import my.gov.kpn.quiz.biz.manager.RoundManager;
import my.gov.kpn.quiz.core.dao.QaQuizDao;
import my.gov.kpn.quiz.core.model.QaQuestion;
import my.gov.kpn.quiz.core.model.QaQuiz;
import my.gov.kpn.quiz.core.model.QaRound;
import my.gov.kpn.quiz.web.client.QuizDelegate;
import my.gov.kpn.quiz.web.client.model.QuestionModel;
import my.gov.kpn.quiz.web.client.model.QuizModel;
import my.gov.kpn.quiz.web.client.model.RoundModel;
import my.gov.kpn.quiz.web.server.common.AutoInjectingRemoteServiceServlet;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

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
    public ListLoadResult<QuestionModel> findQuestions(QuizModel quizModel) {
        ArrayList<QuestionModel> models = new ArrayList<QuestionModel>();
        QaQuiz quiz = quizManager.findQuestionById(quizModel.getId());
        List<QaQuestion> questions = quizManager.findQuestions(quiz);
        for (QaQuestion question : questions) {
            models.add(quizConverter.convert(question));
        }
        return new BaseListLoadResult(models);
    }
}
