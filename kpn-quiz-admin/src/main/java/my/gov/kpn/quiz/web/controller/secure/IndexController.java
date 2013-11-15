package my.gov.kpn.quiz.web.controller.secure;

import my.gov.kpn.quiz.core.model.QaActor;
import my.gov.kpn.quiz.core.model.QaInstructor;
import my.gov.kpn.quiz.core.model.QaUser;
import my.gov.kpn.quiz.web.controller.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("SecureIndexController")
@RequestMapping("/secure/index")
public class IndexController extends AbstractController{

    @RequestMapping(method = {RequestMethod.GET})
    public String redirect(ModelMap model){

        QaUser user = getCurrentUser();
        QaActor actor = user.getActor();

        if (actor instanceof QaInstructor)
            return "secure/instructor/index";
        else
            return "secure/admin/index";
    }
}
