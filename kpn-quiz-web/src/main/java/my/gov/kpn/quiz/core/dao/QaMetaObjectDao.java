package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.model.QaMetaObject;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public interface QaMetaObjectDao {

    QaMetaObject findObjectById(String entityName, Long id);

}
