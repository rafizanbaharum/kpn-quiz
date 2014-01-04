package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.model.*;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public interface QaQuizDao {

    QaQuiz findById(Long id);

    QaQuiz findByRound(Integer round);

    QaQuiz findCurrent();

    List<QaQuiz> findAll();

    List<QaQuiz> find(QaCompetition competition);

    List<QaQuiz> find(Integer offset, Integer limit);

    List<QaQuestion> findQuestions(QaQuiz quiz);

    List<QaParticipant> findParticipants(QaQuiz quiz);

    List<QaParticipant> findParticipants(QaQuiz quiz, Integer offset, Integer limit);

    List<QaParticipant> findParticipants(QaQuiz quiz, QaParticipantSortType sortType, Integer offset, Integer limit);

    Integer count();

    Integer countParticipant(QaQuiz quiz);

    Integer countQuestion(QaQuiz quiz);

    Integer countAnsweredQuestion(QaQuiz quiz, QaParticipant participant);

    Integer countUnansweredQuestion(QaQuiz quiz, QaParticipant participant);

    boolean hasQuestion(QaQuiz quiz);

    boolean hasAnswer(QaQuestion question, QaParticipant participant);

    boolean hasParticipant(QaQuiz quiz);

    boolean isParticipant(QaQuiz quiz, QaUser user);

    void save(QaQuiz quiz, QaUser user);

    void update(QaQuiz quiz, QaUser user);

    void deactivate(QaQuiz quiz, QaUser user);

    void addQuestion(QaQuiz quiz, QaQuestion question, QaUser user);

    void removeQuestion(QaQuiz quiz, QaQuestion question, QaUser user);

    void addParticipant(QaQuiz quiz, QaParticipant participant, QaUser user);

    void removeParticipant(QaQuiz quiz, QaParticipant participant, QaUser user);

    void resetParticipants(QaQuiz quiz, QaUser currentUser);

    void resetGradebooks(QaQuiz quiz, QaUser currentUser);

}
