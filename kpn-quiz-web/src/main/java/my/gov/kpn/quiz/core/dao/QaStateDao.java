package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.dao.impl.QaStateDaoImpl;
import my.gov.kpn.quiz.core.model.QaState;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public interface QaStateDao extends DaoSupport<Long, QaState, QaStateDaoImpl> {

    QaState findByCode(String code);

    List<QaState> find(String filter, Integer offset, Integer limit);

    Integer count();

    Integer count(String filter);

}
