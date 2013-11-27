package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.model.QaConfiguration;
import my.gov.kpn.quiz.core.model.QaUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/27/13
 */
public interface QaConfigurationDao {

    // ====================================================================================================
    // HELPERS
    // ====================================================================================================

    QaConfiguration newInstance();

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    QaConfiguration findById(Long id);

    QaConfiguration findByKey(String key);

    List<QaConfiguration> find(Integer offset, Integer limit);

    List<QaConfiguration> find(String filter, Integer offset, Integer limit);

    Integer count();

    Integer count(String filter);

    // ====================================================================================================
    // CRUD
    // ====================================================================================================

    void save(QaConfiguration configuration, QaUser user);

    void update(QaConfiguration configuration, QaUser user);

    void deactivate(QaConfiguration configuration, QaUser user);

    void remove(QaConfiguration configuration, QaUser user);
}
