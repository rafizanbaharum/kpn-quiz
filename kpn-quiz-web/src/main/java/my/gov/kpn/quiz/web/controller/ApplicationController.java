package my.gov.kpn.quiz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author rafizan.baharum
 * @since 9/14/13
 */
@Controller
@RequestMapping("/application")
public class ApplicationController {

    @RequestMapping(method = {RequestMethod.GET})
    public String go(ModelMap model) {
        return "application";
    }

}
