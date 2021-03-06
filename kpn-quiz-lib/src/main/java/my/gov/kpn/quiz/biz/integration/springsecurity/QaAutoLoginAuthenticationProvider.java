package my.gov.kpn.quiz.biz.integration.springsecurity;

import my.gov.kpn.quiz.core.dao.QaPrincipalDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * @author rafizan.baharum
 * @since 10/4/13
 */
@Service("autoLoginAuthenticationProvider")
public class QaAutoLoginAuthenticationProvider implements AuthenticationProvider {

    private static final Logger log = Logger.getLogger(QaAutoLoginAuthenticationProvider.class);

    @Autowired
    private QaPrincipalDao principalDao;

    @Autowired
    @Qualifier("userDetailService")
    private UserDetailsService userDetailService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = String.valueOf(authentication.getPrincipal());
        UserDetails userDetail = userDetailService.loadUserByUsername(username);
        if (null == userDetail)
            throw new BadCredentialsException("Bad credentials");
        return new QaAutoLoginToken(principalDao.findByName(username));
    }

    @Override
    public boolean supports(Class<? extends Object> authentication) {
        return (QaAutoLoginToken.class.isAssignableFrom(authentication));
    }
}
