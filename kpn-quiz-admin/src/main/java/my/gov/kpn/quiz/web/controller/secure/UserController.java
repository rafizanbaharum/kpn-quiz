package my.gov.kpn.quiz.web.controller.secure;

import my.gov.kpn.quiz.biz.manager.CompetitionManager;
import my.gov.kpn.quiz.biz.manager.InstructorManager;
import my.gov.kpn.quiz.core.model.QaActor;
import my.gov.kpn.quiz.core.model.QaInstructor;
import my.gov.kpn.quiz.core.model.QaUser;
import my.gov.kpn.quiz.web.controller.AbstractController;
import my.gov.kpn.quiz.web.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("SecureUserController")
@RequestMapping("/secure/user")
public class UserController extends AbstractController {

    @Autowired
    private InstructorManager instructorManager;

    @Autowired
    private CompetitionManager competitionManager;

    @RequestMapping(value = "/profile", method = {RequestMethod.GET})
    public String profile(@ModelAttribute("userModel") UserModel userModel, ModelMap model) {
        QaUser user = getCurrentUser();
        QaActor actor = user.getActor();
        model.put("userModel", transformer.transform(user));
        model.put("actorModel", transformer.transform(actor));

        if (actor instanceof QaInstructor)
            return "secure/user/instructor_profile";
        else
            return "secure/user/admin_profile";

    }
}
