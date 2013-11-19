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

    QaQuiz findQuizById(Long id);

    QaQuiz finQuizByRound(Integer round);

    QaQuiz getCurrentQuiz();

    QaParticipant findCurrentParticipant(QaQuiz quiz);

    QaQuestion findQuestionById(Long id);

    QaGradebook findGradebook(QaParticipant participant, QaQuiz quiz);

    QaGradebookItem findGradebookItem(QaParticipant participant, QaQuiz quiz, QaQuestion question);

    List<QaQuiz> findQuizzes();

    List<QaQuestion> findQuestions(QaQuiz quiz);

    List<QaParticipant> findParticipants(QaQuiz quiz);

    List<QaParticipant> findParticipants(QaQuiz quiz, Integer limit, Integer offset);

    void processGradebook(QaQuiz quiz);

    void processParticipant(QaQuiz quiz);

    void saveQuiz(QaQuiz quiz);

    void updateQuiz(QaQuiz quiz);

    void saveQuestion(QaQuestion question);

    void updateQuestion(QaQuestion question);

    void setCurrentQuiz(QaQuiz quiz);

    void updateAnswer(QaParticipant participant, QaQuestion question, Integer answerIndex);

    void updateAnswer(QaParticipant participant, QaQuestion question, String answerResponse);

    Integer countParticipant(QaQuiz quiz);

    void resetParticipants(QaQuiz quiz);

    void tabulateResult(QaQuiz quiz);

    void selectRandomParticipants(QaQuiz quiz, QaQuiz nextQuiz, Integer limit);

    void selectTopParticipants(QaQuiz quiz, QaQuiz nextQuiz, Integer limit);

    void selectFairPlayParticipants(QaQuiz quiz, QaQuiz nextQuiz, Integer limit);


}
