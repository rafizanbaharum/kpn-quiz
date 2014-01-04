package my.gov.kpn.quiz.web.server;

import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.ListLoadResult;
import my.gov.kpn.quiz.biz.manager.CompetitionManager;
import my.gov.kpn.quiz.core.model.QaGradebookItem;
import my.gov.kpn.quiz.core.model.QaParticipant;
import my.gov.kpn.quiz.core.model.QaQuestion;
import my.gov.kpn.quiz.core.model.QaQuiz;
import my.gov.kpn.quiz.web.client.QuizDelegate;
import my.gov.kpn.quiz.web.client.model.QuestionModel;
import my.gov.kpn.quiz.web.client.model.QuizModel;
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
    private CompetitionManager competitionManager;

    @Autowired
    private QuizConverter quizConverter;

    @Override
    public ListLoadResult<QuestionModel> findCurrentQuestions() {
        ArrayList<QuestionModel> models = new ArrayList<QuestionModel>();
        QaQuiz quiz = GlobalRegistry.getQuiz();
        QaParticipant participant = competitionManager.findCurrentParticipant(quiz);
        List<QaQuestion> questions = competitionManager.findQuestions(quiz, participant);
        int index = 1;
        for (QaQuestion question : questions) {
            QuestionModel convert = quizConverter.convert(question);
            convert.setIndex("Question " + index++);
            models.add(convert);
        }
        return new BaseListLoadResult(models);
    }

    @Override
    public QuizModel loadCurrentQuiz() {
        QaQuiz quiz = competitionManager.getCurrentQuiz();
        return quizConverter.convert(quiz);
    }

    @Override
    public void updateAnswer(QuestionModel model, Integer answerIndex) {
        QaQuestion question = competitionManager.findQuestionById(model.getId());
        QaQuiz quiz = GlobalRegistry.getQuiz();
        QaParticipant participant = competitionManager.findCurrentParticipant(quiz);
        competitionManager.updateAnswer(participant, question, answerIndex);
    }

    @Override
    public void updateAnswer(QuestionModel model, String answerResponse) {
        QaQuestion question = competitionManager.findQuestionById(model.getId());
        QaQuiz quiz = GlobalRegistry.getQuiz();
        QaParticipant participant = competitionManager.findCurrentParticipant(quiz);
        competitionManager.updateAnswer(participant, question, answerResponse);
    }

    @Override
    public Integer loadAnswerIndex(QuestionModel model) {
        QaQuestion question = competitionManager.findQuestionById(model.getId());
        QaQuiz quiz = GlobalRegistry.getQuiz();
        QaParticipant participant = competitionManager.findCurrentParticipant(quiz);
        QaGradebookItem item = competitionManager.findGradebookItem(participant, quiz, question);
        return item.getAnswerIndex();
    }

    @Override
    public String loadAnswerResponse(QuestionModel model) {
        QaQuestion question = competitionManager.findQuestionById(model.getId());
        QaQuiz quiz = GlobalRegistry.getQuiz();
        QaParticipant participant = competitionManager.findCurrentParticipant(quiz);
        QaGradebookItem item = competitionManager.findGradebookItem(participant, quiz, question);
        return item.getAnswerResponse();
    }

    @Override
    public String loadResponseStatus() {
        QaQuiz quiz = GlobalRegistry.getQuiz();
        QaParticipant participant = competitionManager.findCurrentParticipant(quiz);
        Integer questionCount = competitionManager.countQuestion(quiz);
        Integer answeredCount = competitionManager.countAnsweredQuestion(quiz, participant);
        return answeredCount + "/" + questionCount;
    }
}
