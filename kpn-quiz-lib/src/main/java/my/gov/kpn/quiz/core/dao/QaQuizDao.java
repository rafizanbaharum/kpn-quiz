package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.model.*;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public interface QaQuizDao {

    QaQuiz findById(Long id);

    QaQuiz findCurrent();

    List<QaQuiz> findAll();

    List<QaQuiz> find(QaCompetition competition);

    List<QaQuiz> find(Integer offset, Integer limit);

    List<QaQuestion> findQuestions(QaQuiz quiz);

    Integer count();

    Integer countParticipant(QaQuiz quiz);

    void save(QaQuiz quiz, QaUser user);

    void update(QaQuiz quiz, QaUser user);

    void deactivate(QaQuiz quiz, QaUser user);

    void addQuestion(QaQuiz quiz, QaQuestion question, QaUser user);

    void removeQuestion(QaQuiz quiz, QaQuestion question, QaUser user);

    void addParticipant(QaQuiz quiz, QaParticipant participant, QaUser user);

    void removeParticipant(QaQuiz quiz, QaParticipant participant, QaUser user);

}
