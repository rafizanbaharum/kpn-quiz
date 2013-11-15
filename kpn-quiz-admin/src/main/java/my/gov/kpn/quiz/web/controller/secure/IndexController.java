package my.gov.kpn.quiz.web.controller.secure;

import my.gov.kpn.quiz.web.controller.AbstractController;
import my.gov.kpn.quiz.web.model.StudentModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("SecureIndexController")
@RequestMapping("/secure/index")
public class IndexController extends AbstractController {

    @RequestMapping(method = {RequestMethod.GET})
    public String index(@ModelAttribute("studentModel") StudentModel studentModel, ModelMap model) {
        return "secure/index";
    }
}
