package my.gov.kpn.quiz.biz.manager;

import my.gov.kpn.quiz.core.model.QaQuiz;
import my.gov.kpn.quiz.core.model.QaRound;

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
}
