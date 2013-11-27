package my.gov.kpn.quiz.web.controller;

import my.gov.kpn.quiz.biz.manager.CompetitionHelper;
import my.gov.kpn.quiz.biz.manager.RegistrationManager;
import my.gov.kpn.quiz.core.model.QaState;
import my.gov.kpn.quiz.web.common.Transformer;
import my.gov.kpn.quiz.web.model.RegistrationModel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedHashMap;
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

    private enum SchoolType {

        SMK,
        PRIVATEW,
        SBP,
        SMK_TEKNIK,
        SMKJ_C,
        SMKJ_T,
        SMA,
        MRSM;
    }

    @RequestMapping(method = {RequestMethod.GET})
    public String go(@ModelAttribute("registration") RegistrationModel registrationModel, ModelMap model, HttpServletRequest request) {
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
                registrationModel.getStateId(), registrationModel.getSchoolName(), Integer.parseInt(registrationModel.getSchoolType()));
        return "registered";
    }


    @ModelAttribute("schoolTypeMap")
    public Map<String, String> schoolTypeMap() {
        Map<String, String> map = new HashMap<String, String>();
        for (SchoolType type : SchoolType.values()) {
            map.put(String.valueOf(type.ordinal()), type.name());
        }
        return map;
    }

    @ModelAttribute("states")
    public Map<String, String> states() {
        Map<String, String> maps = new LinkedHashMap<String, String>();
        for (QaState state : competitionHelper.getStateList()) {
            maps.put(state.getId().toString(), state.getName());
        }
        return maps;
    }
}