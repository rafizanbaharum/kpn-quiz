package my.gov.kpn.quiz.web.controller.secure;

import my.gov.kpn.quiz.biz.manager.CompetitionManager;
import my.gov.kpn.quiz.biz.manager.InstructorManager;
import my.gov.kpn.quiz.biz.manager.RegistrationManager;
import my.gov.kpn.quiz.core.model.QaStudent;
import my.gov.kpn.quiz.web.controller.AbstractController;
import my.gov.kpn.quiz.web.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller("SecureInstructorController")
@RequestMapping("/secure/instructor")
public class InstructorController extends AbstractController {

    @Autowired
    private RegistrationManager registrationManager;

    @Autowired
    private InstructorManager instructorManager;

    @Autowired
    private CompetitionManager competitionManager;

    @RequestMapping(value = "/register", method = {RequestMethod.GET})
    public String registerStudent(@ModelAttribute("studentModel") StudentModel studentModel, ModelMap model) {
        studentModel.setInstructorId(getCurrentInstructorId());
        return "secure/student/student_register";
    }

    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public String studentList(ModelMap model) {
        List<QaStudent> students = instructorManager.getStudents(getCurrentInstructor());
        List<StudentModel> studentModels = transformer.transformStudents(students);
        model.addAttribute("studentModels",studentModels);
        return "secure/student/student_list";
    }

    @RequestMapping(method = {RequestMethod.GET})
    public String go(ModelMap model) {
        return "secure/instructor/instructor_view";
    }

    @RequestMapping(value = "/addStudent", method = {RequestMethod.POST})
    public String addStudent(@ModelAttribute("studentModel") StudentModel studentModel,
                             ModelMap model) {

        if (!studentModel.getPassword().equals(studentModel.getPasswordAgain())) {
            model.addAttribute(MSG_SUCCESS,"Password not match");
            return "secure/studentRegister";
        }

        registrationManager.registerStudent(studentModel.getUsername(), studentModel.getPassword(),
                studentModel.getName(), studentModel.getNric(), studentModel.getInstructorId());
        return "secure/studentRegister";
    }

    @RequestMapping(value = "/resetStudentPassword", method = {RequestMethod.POST})
    public String resetStudentPassword(
            @RequestParam("password") String password,
            @RequestParam("passwordAgain") String passwordAgain,
            @RequestParam("instructorId") String instructorId,
            ModelMap model) {
        return "registered";
    }

}
