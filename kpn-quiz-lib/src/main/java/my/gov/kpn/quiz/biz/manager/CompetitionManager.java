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

    QaCompetition getCurrentYearCompetition();

    List<QaCompetition> findAll();

    QaQuiz findQuizById(Long id);

    QaQuiz finQuizByRound(Integer round);

    QaQuiz getCurrentQuiz();

    QaParticipant findParticipantById(Long id);

    QaParticipant findCurrentParticipant(QaQuiz quiz);

    QaQuestion findQuestionById(Long id);

    QaGradebook findGradebook(QaParticipant participant, QaQuiz quiz);

    QaGradebookItem findGradebookItem(QaParticipant participant, QaQuiz quiz, QaQuestion question);

    List<QaQuiz> findQuizzes();

    List<QaQuestion> findQuestions(QaQuiz quiz);

    List<QaQuestion> findQuestions(QaQuiz quiz, QaParticipant participant);

    List<QaParticipant> findParticipants(QaQuiz quiz);

    List<QaParticipant> findParticipants(QaQuiz quiz, Integer offset, Integer limit);

    List<QaParticipant> findParticipants(QaQuiz quiz, QaParticipantSortType sortType, Integer offset, Integer limit);

    boolean hasQuestion(QaQuiz quiz);

    boolean hasParticipant(QaQuiz quiz);

    boolean hasGradebookItem(QaQuestion question);

    void processGradebook(QaQuiz quiz);

    void processParticipant(QaQuiz quiz);

    QaCompetition saveCompetition(QaCompetition competition);

    void updateCompetition(QaCompetition competition);

    void removeCompetition(QaCompetition competition);

    QaQuiz saveQuiz(QaQuiz quiz);

    void updateQuiz(QaQuiz quiz);

    void removeQuiz(QaQuiz quiz);

    QaQuestion saveQuestion(QaQuestion question);

    void updateQuestion(QaQuestion question);

    void removeQuestion(QaQuestion question);

    void setCurrentQuiz(QaQuiz quiz);

    void updateAnswer(QaParticipant participant, QaQuestion question, Integer answerIndex);

    void updateAnswer(QaParticipant participant, QaQuestion question, String answerResponse);

    Integer countParticipant(QaQuiz quiz);

    Integer countQuestion(QaQuiz quiz);

    Integer countAnsweredQuestion(QaQuiz quiz, QaParticipant participant);

    Integer countUnansweredQuestion(QaQuiz quiz, QaParticipant participant);

    void resetParticipants(QaQuiz quiz);

    void resetGradebooks(QaQuiz quiz);

    void tabulateResult(QaQuiz quiz);

    boolean tabulateResultPartial(QaQuiz quiz);

    void selectParticipantForNextRound(QaQuiz quiz, QaParticipant participant);
}
