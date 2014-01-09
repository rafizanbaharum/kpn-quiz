package my.gov.kpn.quiz.biz.integration.springsecurity;

import my.gov.kpn.quiz.core.model.QaUser;
import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 7/12/13
 */
@Component("userDetails")
@Transactional
public class QaUserDetails implements UserDetails {

    private static final Logger log = Logger.getLogger(QaUserDetails.class);

    private QaUser user;
    private Set<GrantedAuthority> grantedAuthorities;

    public QaUserDetails() {
    }

    public QaUserDetails(QaUser user, Set<GrantedAuthority> grantedAuthorities) {
        this.user = user;
        this.grantedAuthorities = grantedAuthorities;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    public String getPassword() {
        return user.getPassword();
    }

    public String getUsername() {
        return user.getName();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return user.isEnabled();
    }

    public void setUser(QaUser user) {
        this.user = user;
    }

    public QaUser getUser() {
        return user;
    }

    public String getRealname() {
        return user.getRealname();
    }

    public String getEmail() {
        return user.getEmail();
    }

    public Long getId() {
        return user.getId();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QaUserDetails that = (QaUserDetails) o;

        if (!user.equals(that.user)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return null == user ? 0 : user.hashCode();
    }
}
