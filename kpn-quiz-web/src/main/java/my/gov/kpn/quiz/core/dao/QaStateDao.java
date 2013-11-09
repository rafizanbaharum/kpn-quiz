package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.model.QaState;
import my.gov.kpn.quiz.core.model.QaUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public interface QaStateDao {

    QaState findById(Long id);

    QaState findByCode(String code);

    List<QaState> find(Integer offset, Integer limit);

    List<QaState> find(String filter, Integer offset, Integer limit);

    Integer count();

    Integer count(String filter);

    void save(QaState State, QaUser user);

    void update(QaState State, QaUser user);

    void deactivate(QaState State, QaUser user);

}
