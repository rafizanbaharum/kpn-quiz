package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.model.*;
import my.gov.kpn.quiz.core.model.impl.QaActorImpl;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public interface QaActorDao extends DaoSupport<Long, QaActor, QaActorImpl> {

    QaActor findById(Long id);

    QaActor findByIdentityNo(String identityNo);

    QaActor findByNricNo(String nricNo);

    List<QaActor> find(Integer offset, Integer limit);

    List<QaActor> find(String filter, Integer offset, Integer limit);

    List<QaActor> find(QaActorType type, Integer offset, Integer limit);

    List<QaActor> find(QaActorType type, String filter, Integer offset, Integer limit);

    List<QaStudent> findStudent(QaInstructor instructor);

    Boolean isCustodian(QaInstructor instructor, QaStudent student);

    Integer count();

    Integer count(String filter);

    Integer count(QaActorType type);

    void save(QaActor actor, QaUser user);

    void update(QaActor actor, QaUser user);

    void deactivate(QaActor actor, QaUser user);

    void delete(QaActor actor, QaUser user);
}
