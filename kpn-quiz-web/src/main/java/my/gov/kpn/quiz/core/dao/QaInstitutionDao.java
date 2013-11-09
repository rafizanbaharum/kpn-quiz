package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.model.QaInstitution;
import my.gov.kpn.quiz.core.model.QaUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public interface QaInstitutionDao {

    QaInstitution findById(Long id);

    QaInstitution findByCode(String code);

    List<QaInstitution> find(Integer offset, Integer limit);

    List<QaInstitution> find(String filter, Integer offset, Integer limit);

    Integer count();

    Integer count(String filter);

    void save(QaInstitution institution, QaUser user);

    void update(QaInstitution institution, QaUser user);

    void deactivate(QaInstitution institution, QaUser user);

}
