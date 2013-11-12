package my.gov.kpn.quiz.web.controller.secure;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/secure/instructor")
public class InstructorController {

    @RequestMapping(method = {RequestMethod.GET})
    public String go(ModelMap model) {
        return "index";
    }
}
