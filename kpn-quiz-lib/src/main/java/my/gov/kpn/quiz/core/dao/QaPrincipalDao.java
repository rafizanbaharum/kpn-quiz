package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.model.QaPrincipal;
import my.gov.kpn.quiz.core.model.QaPrincipalType;
import my.gov.kpn.quiz.core.model.QaUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public interface QaPrincipalDao {

        //principal

        QaPrincipal findById(Long id);

        QaPrincipal findByName(String name);

        List<QaPrincipal> findAllPrincipals();

        List<QaPrincipal> findPrincipals(String filter);

        List<QaPrincipal> findPrincipals(String filter, QaPrincipalType type);

        List<QaPrincipal> findPrincipals(Integer offset, Integer limit);

        // cruds

        void save(QaPrincipal principal, QaUser user);

        void update(QaPrincipal principal, QaUser user);

        void deactivate(QaPrincipal principal, QaUser user);

    }
