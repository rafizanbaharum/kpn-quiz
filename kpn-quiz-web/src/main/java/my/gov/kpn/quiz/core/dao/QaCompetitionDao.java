package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.model.QaCompetition;
import my.gov.kpn.quiz.core.model.QaRound;
import my.gov.kpn.quiz.core.model.QaUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public interface QaCompetitionDao {

    QaCompetition findById(Long id);

    List<QaCompetition> find(Integer offset, Integer limit);

    Integer count();

    void save(QaCompetition competition, QaUser user);

    void update(QaCompetition competition, QaUser user);

    void deactivate(QaCompetition competition, QaUser user);

    void addQuiz(QaCompetition competition, QaRound round, QaUser user);

    void removeQuiz(QaCompetition competition, QaRound round, QaUser user);
}
