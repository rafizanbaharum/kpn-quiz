package my.gov.kpn.quiz.web.controller.secure;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/secure")
public class InstructorController {

    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public String index(ModelMap model) {
        return "secure/index";
    }

    @RequestMapping(value = "/instructor", method = {RequestMethod.GET})
    public String go(ModelMap model) {
        return "secure/instructor";
    }
}
