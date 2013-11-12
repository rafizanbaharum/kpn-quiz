package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.exception.RecursiveGroupException;
import my.gov.kpn.quiz.core.model.QaGroup;
import my.gov.kpn.quiz.core.model.QaPrincipal;
import my.gov.kpn.quiz.core.model.QaPrincipalType;
import my.gov.kpn.quiz.core.model.QaUser;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.Set;

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

        Set<QaGroup> loadEffectiveGroups(QaPrincipal principal) throws RecursiveGroupException;

        Set<GrantedAuthority> loadEffectiveAuthorities(QaPrincipal principal) throws RecursiveGroupException;

        // cruds

        void save(QaPrincipal principal, QaUser user);

        void update(QaPrincipal principal, QaUser user);

        void deactivate(QaPrincipal principal, QaUser user);

    }
