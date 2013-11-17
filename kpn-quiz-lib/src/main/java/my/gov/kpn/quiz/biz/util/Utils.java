package my.gov.kpn.quiz.biz.util;

import my.gov.kpn.quiz.biz.integration.springsecurity.QaUserDetails;
import my.gov.kpn.quiz.core.model.QaUser;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public class Utils {

    private static final Logger log = Logger.getLogger(Utils.class);

    /**
     * get logged in user
     *
     * @return current user
     */
    public static QaUser getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof UserDetails) {
            return ((QaUserDetails) auth.getPrincipal()).getUser();
        } else {
            return null;
        }
    }

}
