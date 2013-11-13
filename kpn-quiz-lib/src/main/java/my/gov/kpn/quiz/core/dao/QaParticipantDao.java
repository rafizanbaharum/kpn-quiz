package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.model.*;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public interface QaParticipantDao {

    QaParticipant findById(Long id);

    QaParticipant find(QaRound round, QaUser user);

    List<QaParticipant> findAll(QaRound round);

    List<QaParticipant> find(QaRound round, Integer offset, Integer limit);

    Integer count();

    void save(QaParticipant participant, QaUser user);

    void update(QaParticipant participant, QaUser user);

    void deactivate(QaParticipant participant, QaUser user);
}
