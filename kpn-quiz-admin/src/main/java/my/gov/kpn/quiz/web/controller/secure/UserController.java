package my.gov.kpn.quiz.web.controller.secure;

import my.gov.kpn.quiz.biz.manager.InstructorManager;
import my.gov.kpn.quiz.biz.manager.QuizManager;
import my.gov.kpn.quiz.web.controller.AbstractController;
import my.gov.kpn.quiz.web.model.StudentModel;
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
    private QuizManager quizManager;

    @RequestMapping(value = "/profile", method = {RequestMethod.GET})
    public String registerStudent(@ModelAttribute("studentModel") StudentModel studentModel, ModelMap model) {
        studentModel.setInstructorId(getCurrentInstructorId());
        return "secure/user/user_profile";
    }
}
