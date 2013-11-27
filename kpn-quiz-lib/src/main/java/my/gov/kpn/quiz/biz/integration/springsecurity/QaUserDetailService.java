package my.gov.kpn.quiz.biz.integration.springsecurity;

import my.gov.kpn.quiz.core.dao.QaPrincipalDao;
import my.gov.kpn.quiz.core.model.QaMetaState;
import my.gov.kpn.quiz.core.model.QaPrincipalRole;
import my.gov.kpn.quiz.core.model.QaUser;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 9/11/13
 */
@Service("userDetailService")
@Transactional
public class QaUserDetailService implements UserDetailsService {

    private static final Logger log = Logger.getLogger(QaUserDetailService.class);

    @Autowired
    protected SessionFactory sessionFactory;

    @Autowired
    private QaPrincipalDao principalDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException, DataAccessException {
        log.debug("loading username: " + s);
        QaUser user = null;
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from QaUser u " +
                "inner join u.actor a " +
                "where u.name = :username " +
                "and a.actorType in (:actorTypes) " +
                "and u.metadata.state = :state");
        query.setString("username", s);
        query.setParameterList("actorTypes", new Integer[]{0, 2});
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        user = (QaUser) query.uniqueResult();
        if (user == null)
            throw new UsernameNotFoundException("No such user");
        log.debug(user.getUsername() + " " + user.getPassword());
        return new QaUserDetails(user, loadGrantedAuthoritiesFor(user));
    }

    private Set<GrantedAuthority> loadGrantedAuthoritiesFor(QaUser user) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
//        try {
        //load all roles which ties to user
        for (QaPrincipalRole role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleType().name()));
        }
        log.info("load auth for " + user.getName() + "#" + user.getId());
        // XXX: will hook this up later
//            grantedAuthorities.addAll(principalDao.loadEffectiveAuthorities(user));
//        } catch (RecursiveGroupException e) {
//            log.error(e.getMessage());
//            grantedAuthorities.clear();
//        }
        return grantedAuthorities;
    }


}
