package my.gov.kpn.quiz.biz.manager;

import my.gov.kpn.quiz.core.model.QaParticipant;
import my.gov.kpn.quiz.core.model.QaQuestion;
import my.gov.kpn.quiz.core.model.QaQuiz;
import my.gov.kpn.quiz.core.model.QaRound;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/10/13
 */
public interface QuizManager {

    /**
     * set this quiz current
     * and all others false
     *
     * @param quiz
     */
    void setCurrentQuiz(QaQuiz quiz);

    QaQuiz getCurrentQuiz();

    void processRound(QaRound round);

    QaQuiz findQuestionById(Long id);

    List<QaQuestion> findQuestions(QaQuiz quiz);

    void updateAnswer(QaParticipant participant, QaQuestion question);

}
