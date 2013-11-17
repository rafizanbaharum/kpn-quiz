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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("SecureStudentController")
@RequestMapping("/secure/student")
public class StudentController extends AbstractController {

    private final String BREADCRUMB = "STUDENT_BREADCRUMB";
    private final String TITLE = "STUDENT_TITLE";

    @Autowired
    private InstructorManager instructorManager;

    @Autowired
    private CompetitionManager competitionManager;

    @Autowired
    private RegistrationManager registrationManager;

    @RequestMapping(value = "/edit/{id}", method = {RequestMethod.GET})
    public String studentEdit(@PathVariable Long id, ModelMap model) {
        QaStudent student = instructorManager.findStudentById(id);
        model.addAttribute("studentModel", transformer.transform(student));
        model.put(BREADCRUMB,"Update Student Details");
        model.put(TITLE,"Update Student Details");
        return "secure/student/student_edit";
    }

    @RequestMapping(value = "/view/{id}", method = {RequestMethod.GET})
    public String studentView(@PathVariable Long id, ModelMap model) {
        QaStudent student = instructorManager.findStudentById(id);
        model.addAttribute("studentModel", transformer.transform(student));
        return "secure/student/student_view";
    }

    @RequestMapping(value = "/register", method = {RequestMethod.GET})
    public String studentRegister(@ModelAttribute("studentModel") StudentModel studentModel, ModelMap model) {
        model.put(BREADCRUMB,"Register Student");
        model.put(TITLE,"Student Registration");
        return "secure/student/student_register";
    }

    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public String studentAdd(@ModelAttribute("studentModel") StudentModel studentModel, ModelMap model) {
        // TODO: check if username exist

        // check if password does not match
        if (!studentModel.getPassword().equals(studentModel.getPasswordAgain())) {
            model.addAttribute(MSG_SUCCESS, "Password does not match");
            return "secure/student/student_register";
        }

        registrationManager.registerStudent(studentModel.getUsername(), studentModel.getPassword(),
                studentModel.getName(), studentModel.getNric(), getCurrentInstructor());
        return "redirect:/secure/student/list";
    }

    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public String studentList(@ModelAttribute("studentModel") StudentModel studentModel, ModelMap model) {
        List<QaStudent> students = instructorManager.getStudents(getCurrentInstructor());
        model.addAttribute("studentModels", transformer.transformStudents(students));
        model.put(BREADCRUMB,"Student List");
        model.put(TITLE,"Student List");
        return "secure/student/student_list";
    }

    @RequestMapping(value = "/reset/{id}", method = {RequestMethod.GET})
    public String studentReset(@PathVariable Long id, ModelMap model) {
        QaStudent student = instructorManager.findStudentById(id);
        model.addAttribute("studentModel", transformer.transform(student));
        return "secure/student/student_reset";
    }

    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public String studentUpdate(@ModelAttribute("studentModel") StudentModel studentModel,
                                ModelMap model) {
        QaStudent student = instructorManager.findStudentById(studentModel.getId());
        student.setName(studentModel.getName());
        student.setNricNo(studentModel.getNric());

        // check if password does not match
        if (!studentModel.getPassword().equals(studentModel.getPasswordAgain())) {
            model.addAttribute(MSG_SUCCESS, "Password does not match");
            return "secure/student/student_register";
        }

        model.addAttribute(MSG_SUCCESS, "Student successfully updated");
        return "redirect:/secure/student/view/" + student.getId();
    }
}
