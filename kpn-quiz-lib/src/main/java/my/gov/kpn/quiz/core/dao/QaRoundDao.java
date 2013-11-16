package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.model.QaParticipant;
import my.gov.kpn.quiz.core.model.QaQuiz;
import my.gov.kpn.quiz.core.model.QaRound;
import my.gov.kpn.quiz.core.model.QaUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public interface QaRoundDao {

    QaRound findById(Long id);

    List<QaRound> findAll();

    List<QaRound> find(Integer offset, Integer limit);

    Integer count();

    Integer countParticipant(QaRound round);

    void save(QaRound round, QaUser user);

    void update(QaRound round, QaUser user);

    void deactivate(QaRound round, QaUser user);

    void addQuiz(QaRound round, QaQuiz quiz, QaUser user);

    void removeQuiz(QaRound round, QaQuiz quiz, QaUser user);

    void addParticipant(QaRound round, QaParticipant participant, QaUser user);

    void removeParticipant(QaRound round, QaParticipant participant, QaUser user);

}
