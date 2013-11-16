package my.gov.kpn.quiz.biz.manager;

import my.gov.kpn.quiz.core.model.*;

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

    QaParticipant findParticipant(QaQuiz quiz, QaUser user);

    QaQuiz findQuizById(Long id);


    QaCompetition findCompetitionById(Long id);

    QaCompetition findCompetitionByYear(int year);

    QaRound findRoundById(Long id);

    QaQuestion findQuestionById(Long id);

    List<QaRound> findRounds();

    List<QaQuiz> findQuizzes(QaRound round);

    List<QaQuestion> findQuestions(QaQuiz quiz);

    void updateAnswer(QaParticipant participant, QaQuestion question);

    void saveQuiz(QaQuiz quiz);

    void updateQuiz(QaQuiz quiz);

    void saveRound(QaRound round);

    void updateRound(QaRound round);

}
