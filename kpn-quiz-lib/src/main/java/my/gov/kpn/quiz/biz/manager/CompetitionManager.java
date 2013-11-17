package my.gov.kpn.quiz.biz.manager;

import my.gov.kpn.quiz.core.model.*;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/10/13
 */
public interface CompetitionManager {


    QaCompetition findCompetitionById(Long id);

    QaCompetition findCompetitionByYear(int year);

    QaRound findRoundById(Long id);

    QaQuiz findQuizById(Long id);

    QaQuiz getCurrentQuiz();

    QaParticipant findParticipant(QaQuiz quiz, QaUser user);

    QaQuestion findQuestionById(Long id);

    QaGradebook findGradebook(QaParticipant participant, QaQuiz quiz);

    QaGradebookItem findGradebookItem(QaParticipant participant, QaQuiz quiz, QaQuestion question);

    List<QaRound> findRounds();

    List<QaQuiz> findQuizzes(QaRound round);

    List<QaQuestion> findQuestions(QaQuiz quiz);

    void saveRound(QaRound round);

    void updateRound(QaRound round);

    void processGradebook(QaRound round);

    void processParticipant(QaRound round);

    void saveQuiz(QaQuiz quiz);

    void updateQuiz(QaQuiz quiz);

    void saveQuestion(QaQuestion question);

    void updateQuestion(QaQuestion question);

    void setCurrentQuiz(QaQuiz quiz);

    void updateAnswer(QaParticipant participant, QaQuestion question, Integer answerIndex);

    void updateAnswer(QaParticipant participant, QaQuestion question, String answerResponse);

    Integer countParticipant(QaRound round);

    void calculateResult(QaRound round, QaQuiz quiz);
}
