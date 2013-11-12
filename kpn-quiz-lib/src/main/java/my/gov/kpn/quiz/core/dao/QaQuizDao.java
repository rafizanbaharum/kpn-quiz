package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.model.QaQuestion;
import my.gov.kpn.quiz.core.model.QaQuiz;
import my.gov.kpn.quiz.core.model.QaUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public interface QaQuizDao {

    QaQuiz findById(Long id);

    QaQuiz findCurrent();

    List<QaQuiz> findAll();

    List<QaQuiz> find(Integer offset, Integer limit);

    List<QaQuestion> findQuestions(QaQuiz quiz);

    Integer count();

    void save(QaQuiz quiz, QaUser user);

    void update(QaQuiz quiz, QaUser user);

    void deactivate(QaQuiz quiz, QaUser user);

    void addQuestion(QaQuiz quiz, QaQuestion question, QaUser user);

    void removeQuestion(QaQuiz quiz, QaQuestion question, QaUser user);
}
