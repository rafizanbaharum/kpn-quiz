package my.gov.kpn.quiz.web.controller;

import my.gov.kpn.quiz.biz.manager.RegistrationManager;
import my.gov.kpn.quiz.core.dao.QaInstitutionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private RegistrationManager registrationManager;

    @Autowired
    private QaInstitutionDao institutionDao;

    @RequestMapping(method = {RequestMethod.GET})
    public String go(ModelMap model) {
        model.put("name", "xxx");
        return "register";
    }

    @RequestMapping(value = "/validate/{username}", method = RequestMethod.GET)
    public String validateUsername(@PathVariable String username, ModelMap model) {
        boolean exists = registrationManager.isExists(username);
        model.put("status", exists);
        return "newUsernameStatus";
    }

    @RequestMapping(method = {RequestMethod.POST})
    public String register(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("passwordAgain") String passwordAgain,
            @RequestParam("fullName") String name,
            @RequestParam("nricNo") String nricNo,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("fax") String fax,
            @RequestParam("stateId") String stateId,
            @RequestParam("districtId") String districtId,
            @RequestParam("schoolName") String schoolName,
            ModelMap model) {
        if (!passwordAgain.equals(password)) {
            return "register";
        }

        registrationManager.registerInstructor(username, password,
                name, nricNo, email, phone, fax,
                stateId, districtId, schoolName);
        return "registered";
    }

    @RequestMapping(value = "/addStudent", method = {RequestMethod.POST})
    public String addStudent(
            @RequestParam("studentUsername") String studentUsername,
            @RequestParam("studentNric") String studentNric,
            @RequestParam("studentName") String studentName,
            @RequestParam("instructorId") Long instructorId,
            ModelMap model) {

        registrationManager.registerStudent(studentUsername, "abc123",
                studentName, studentNric, instructorId);
        return "registered";
    }

    @RequestMapping(value = "/resetStudentPassword", method = {RequestMethod.POST})
    public String addStudent(
            @RequestParam("password") String password,
            @RequestParam("passwordAgain") String passwordAgaian,
            @RequestParam("instructorId") String instructorId,
            ModelMap model) {

//        registrationManager.register(username, password,
//                name, nricNo, email, phone, fax,
//                stateId, districtId, institutionId);
        return "registered";
    }
}
