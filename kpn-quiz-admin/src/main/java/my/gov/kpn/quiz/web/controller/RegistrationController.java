package my.gov.kpn.quiz.web.controller;

import my.gov.kpn.quiz.biz.manager.InstructorInfo;
import my.gov.kpn.quiz.core.dao.QaUserDao;
import my.gov.kpn.quiz.core.model.QaCompetition;
import my.gov.kpn.quiz.core.model.QaUser;
import my.gov.kpn.quiz.web.model.RegistrationModel;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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
    private QaUserDao userDao;

    @RequestMapping(method = {RequestMethod.GET})
    public String go(@ModelAttribute("registration") RegistrationModel registrationModel, ModelMap model, HttpServletRequest request) {
        return "register";
    }

    @RequestMapping(value = "/validate/", method = RequestMethod.GET)
    @ResponseBody
    public Boolean validateUsername(@RequestParam(value = "nricNo") String username, ModelMap model) {
        return registrationManager.isExists(username);
    }

    @RequestMapping(method = {RequestMethod.POST})
    public String register(@ModelAttribute("registration") RegistrationModel registrationModel,
                           ModelMap model) {
        // NRIC as username. Just copy it.
        registrationModel.setUsername(registrationModel.getNricNo());

        if (registrationManager.isExists(registrationModel.getUsername())) {
            model.addAttribute(registrationModel);
            model.addAttribute(MSG_ERROR, "User already exists");
            return "register";
        }

        if (!registrationModel.getPassword().equals(registrationModel.getPasswordAgain())) {
            model.addAttribute(registrationModel);
            model.addAttribute(MSG_ERROR, "Password does not match");
            return "register";
        }

        registrationManager.registerInstructor(
                new InstructorInfo(
                        registrationModel.getUsername(),
                        registrationModel.getPassword(),
                        registrationModel.getFullName(),
                        registrationModel.getNricNo(),
                        registrationModel.getEmail(),
                        registrationModel.getPhone(),
                        registrationModel.getFax(),
                        registrationModel.getStateId(),
                        registrationModel.getSchoolName(),
                        registrationModel.getSchoolPhone(),
                        registrationModel.getSchoolFax(),
                        Integer.parseInt(registrationModel.getSchoolType())));
        return "registered";
    }

    @RequestMapping(value = "/forgot_password", method = {RequestMethod.POST})
    public String forgotPassword(@RequestParam Map<String, String> map, ModelMap model) {
        String nricNo = map.get("nricNo");
        log.debug("entry = " + nricNo);
        QaUser user = userDao.findByUsername(nricNo);
        sysManager.recoverPassword(user);
        return "forgot_password";
    }

    @ModelAttribute("started")
    public boolean started() {
        QaCompetition competition =
                competitionManager.findCompetitionByYear(competitionManager.getCurrentYearCompetition().getYear());
        DateTime startDate = new DateTime(competition.getStartDate());
        DateTime today = new DateTime(new Date());
        return (today.isAfter(startDate));
    }

    @ModelAttribute("ended")
    public boolean ended() {
        QaCompetition competition =
                competitionManager.findCompetitionByYear(competitionManager.getCurrentYearCompetition().getYear());
        DateTime endDate = new DateTime(competition.getEndDate());
        DateTime today = new DateTime(new Date());
        return (today.isAfter(endDate));
    }

}