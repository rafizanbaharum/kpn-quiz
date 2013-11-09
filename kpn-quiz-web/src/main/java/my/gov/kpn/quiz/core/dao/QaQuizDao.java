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

    List<QaQuiz> find(Integer offset, Integer limit);

    Integer count();

    void save(QaQuiz quiz, QaUser user);

    void update(QaQuiz quiz, QaUser user);

    void deactivate(QaQuiz quiz, QaUser user);

    void addQuestion(QaQuiz quiz, QaQuestion question, QaUser user);

    void removeQuestion(QaQuiz quiz, QaQuestion question, QaUser user);
}
