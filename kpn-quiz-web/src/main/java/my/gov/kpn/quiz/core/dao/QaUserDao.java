package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.model.QaActor;
import my.gov.kpn.quiz.core.model.QaGroup;
import my.gov.kpn.quiz.core.model.QaUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public interface QaUserDao {

    QaUser findById(Long id);

    QaUser findByUsername(String username);

    QaUser findByActor(QaActor actor);

    QaUser findByRealName(String realname);

    // TODO: satu malaysia?? maybe chunk it?
    List<QaUser> findAll();

    List<QaUser> find(Integer offset, Integer limit);

    List<QaUser> find(String filter, Integer offset, Integer limit);

    List<QaGroup> findUserGroups(QaUser user);

    Integer count();

    Integer count(String filter);

    boolean isExists(String username);

    // cruds

    void save(QaUser suser, QaUser user);

    void update(QaUser suser, QaUser user);

    void deactivate(QaUser suser, QaUser user);

    void remove(QaUser suser, QaUser user);

}
