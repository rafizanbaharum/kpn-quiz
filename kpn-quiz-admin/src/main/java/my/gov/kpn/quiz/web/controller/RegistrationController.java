package my.gov.kpn.quiz.web.controller;

import my.gov.kpn.quiz.biz.manager.CompetitionHelper;
import my.gov.kpn.quiz.biz.manager.RegistrationManager;
import my.gov.kpn.quiz.web.common.Transformer;
import my.gov.kpn.quiz.web.model.RegistrationModel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
@Controller
@RequestMapping("/register")
public class RegistrationController extends AbstractController {

    private static final Logger log = Logger.getLogger(RegistrationController.class);

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private RegistrationManager registrationManager;

    @Autowired
    private Transformer transformer;

    @Autowired
    private CompetitionHelper competitionHelper;

    @RequestMapping(method = {RequestMethod.GET})
    public String go(@ModelAttribute("registration") RegistrationModel registrationModel, ModelMap model, HttpServletRequest request) {
        Map<String, String> value = transformer.transformStatesToDropDown(competitionHelper.getStateList());
        model.put("states", value);
        return "register";
    }

    @RequestMapping(value = "/validate/{username}", method = RequestMethod.GET)
    public String validateUsername(@PathVariable String username, ModelMap model) {
        boolean exists = registrationManager.isExists(username);
        model.put("status", exists);
        return "newUsernameStatus";
    }

    @RequestMapping(method = {RequestMethod.POST})
    public String register(@ModelAttribute("registration") RegistrationModel registrationModel,
                           ModelMap model) {

        if (!registrationModel.getPassword().equals(registrationModel.getPasswordAgain())) {
            return "register";
        }

        registrationManager.registerInstructor(registrationModel.getUsername(), registrationModel.getPassword(),
                registrationModel.getFullName(), registrationModel.getNricNo(), registrationModel.getEmail(), registrationModel.getPhone(), registrationModel.getFax(),
                registrationModel.getStateId(), registrationModel.getSchoolName());
        return "registered";
    }

}
