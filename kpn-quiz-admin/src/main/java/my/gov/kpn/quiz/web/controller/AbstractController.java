package my.gov.kpn.quiz.web.controller;

import my.gov.kpn.quiz.biz.integration.springsecurity.QaUserDetails;
import my.gov.kpn.quiz.core.model.QaActor;
import my.gov.kpn.quiz.core.model.QaInstructor;
import my.gov.kpn.quiz.core.model.QaUser;
import my.gov.kpn.quiz.web.common.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class AbstractController {

    protected final String MSG_SUCCESS = "msgSuccess";
    protected final String MSG_ERROR = "msgSuccess";

    @Autowired
    protected Transformer transformer;

    protected QaUser getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof UserDetails) {
            return ((QaUserDetails) auth.getPrincipal()).getUser();
        } else {
            return null;
        }
    }

    protected QaInstructor getCurrentInstructor() {
        QaUser user = getCurrentUser();
        if (null != user) {
            QaActor actor = user.getActor();
            if (null != actor && actor instanceof QaInstructor)
                return (QaInstructor) actor;
        }
        return null;
    }
}
