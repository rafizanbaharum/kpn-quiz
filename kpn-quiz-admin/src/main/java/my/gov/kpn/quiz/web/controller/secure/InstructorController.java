package my.gov.kpn.quiz.web.controller.secure;

import my.gov.kpn.quiz.biz.manager.InstructorManager;
import my.gov.kpn.quiz.biz.manager.RegistrationManager;
import my.gov.kpn.quiz.core.model.QaStudent;
import my.gov.kpn.quiz.web.common.Transformer;
import my.gov.kpn.quiz.web.controller.AbstractController;
import my.gov.kpn.quiz.web.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/secure")
public class InstructorController extends AbstractController {

    @Autowired
    private InstructorManager instructorManager;

    @Autowired
    private Transformer transformer;

    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public String index(@ModelAttribute("studentModel") StudentModel studentModel, ModelMap model) {
        return "secure/index";
    }

    @RequestMapping(value = "/register", method = {RequestMethod.GET})
    public String registerStudent(@ModelAttribute("studentModel") StudentModel studentModel, ModelMap model) {
        studentModel.setInstructorId(getCurrentInstructorId());
        return "secure/studentRegister";
    }

    @RequestMapping(value = "/instructor", method = {RequestMethod.GET})
    public String go(ModelMap model) {
        return "secure/instructor";
    }

    @RequestMapping(value = "/studentList", method = {RequestMethod.GET})
    public String studentList(@ModelAttribute("studentModel") StudentModel studentModel, ModelMap model) {

        List<QaStudent> students = instructorManager.getStudents(getCurrentInstructor());
        List<StudentModel> studentModels = transformer.transform(students);
        model.addAttribute("studentModels", studentModels);

        return "secure/studentList";
    }
}
