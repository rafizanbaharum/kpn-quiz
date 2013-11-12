package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.model.QaActor;
import my.gov.kpn.quiz.core.model.QaActorType;
import my.gov.kpn.quiz.core.model.QaUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public interface QaActorDao {

    QaActor findById(Long id);

    QaActor findByIdentityNo(String identityNo);

    QaActor findByNricNo(String nricNo);

    List<QaActor> find(Integer offset, Integer limit);

    List<QaActor> find(String filter, Integer offset, Integer limit);

    List<QaActor> find(QaActorType type, Integer offset, Integer limit);

    List<QaActor> find(QaActorType type, String filter, Integer offset, Integer limit);

    Integer count();

    Integer count(String filter);

    Integer count(QaActorType type);

    void save(QaActor actor, QaUser user);

    void update(QaActor actor, QaUser user);

    void deactivate(QaActor actor, QaUser user);
}
