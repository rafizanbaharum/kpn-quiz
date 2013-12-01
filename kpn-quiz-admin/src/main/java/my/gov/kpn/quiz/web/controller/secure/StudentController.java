package my.gov.kpn.quiz.web.controller.secure;

import my.gov.kpn.quiz.biz.manager.CompetitionManager;
import my.gov.kpn.quiz.biz.manager.InstructorManager;
import my.gov.kpn.quiz.biz.manager.RegistrationManager;
import my.gov.kpn.quiz.core.model.QaStudent;
import my.gov.kpn.quiz.web.controller.AbstractController;
import my.gov.kpn.quiz.web.model.StudentModel;
import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller("SecureStudentController")
@RequestMapping("/secure/student")
public class StudentController extends AbstractController {

    private static final Logger log = Logger.getLogger(StudentController.class);

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

        // TODO : Any other implementation? Apply to all method later
        Boolean isCustodian = instructorManager.isCustodian(getCurrentInstructor(), student);
        if (!isCustodian) {
            model.addAttribute(MSG_ERROR, "Invalid  student!");
            return "redirect:/secure/student/list";
        }

        StudentModel transform = transformer.transform(student);

        model.addAttribute("studentModel", transform);
        model.put(BREADCRUMB, "Update Student Details");
        model.put(TITLE, "Update Student Details");
        return "secure/student/student_edit";
    }

    @RequestMapping(value = "/view/{id}", method = {RequestMethod.GET})
    public String studentView(@PathVariable Long id, ModelMap model) {
        QaStudent student = instructorManager.findStudentById(id);

        model.addAttribute("studentModel", transformer.transform(student));
        model.put(BREADCRUMB, "View Student Details");
        model.put(TITLE, "View Student Details");
        return "secure/student/student_view";
    }

    @RequestMapping(value = "/remove/{id}", method = {RequestMethod.GET})
    public String studentRemove(@PathVariable Long id, ModelMap model) {
        QaStudent student = instructorManager.findStudentById(id);

        model.addAttribute("studentModel", transformer.transform(student));
        model.put(BREADCRUMB, "Confirm Remove Student");
        model.put(TITLE, "Confirm Remove Student");
        return "secure/student/student_remove";
    }

    @RequestMapping(value = "/remove/confirm/{id}", method = {RequestMethod.POST})
    public String studentConfirmRemove(@PathVariable Long id, ModelMap model) {
        QaStudent student = instructorManager.findStudentById(id);

        model.addAttribute("studentModel", transformer.transform(student));
        model.put(BREADCRUMB, "View Student Details");
        model.put(TITLE, "View Student Details");
        model.put(MSG_SUCCESS, "Student Removed");
        return studentList(new StudentModel(), model);
    }

    @RequestMapping(value = "/register", method = {RequestMethod.GET})
    public String studentRegister(@ModelAttribute("studentModel") StudentModel studentModel, ModelMap model) {
        model.put(BREADCRUMB, "Register Student");
        model.put(TITLE, "Student Registration");
        return "secure/student/student_register";
    }

    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public String studentAdd(@ModelAttribute("studentModel") StudentModel studentModel, ModelMap model) {
        // TODO: check if username exist

        // check if password does not match
        if (!studentModel.getPassword().equals(studentModel.getPasswordAgain())) {
            model.addAttribute(MSG_ERROR, "Password does not match");
            return "secure/student/student_register";
        }

        Integer year = Integer.valueOf(studentModel.getDob_yyyy());
        Integer currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int diff = currentYear - year;
        if (diff > 16 || diff < 15) {
            model.addAttribute(MSG_ERROR, "Not allowed to register because of age restriction!");
            return "secure/student/student_register";
        }

        registrationManager.registerStudent(studentModel.getUsername(), studentModel.getPassword(),
                studentModel.getName(), studentModel.getNric(), extractDob(studentModel), getCurrentInstructor());
        model.addAttribute(MSG_SUCCESS, "Student registered");

//        return "redirect:/secure/student/list"; //redirect cause msg box not appear
        return studentList(new StudentModel(), model);
    }

    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public String studentList(@ModelAttribute("studentModel") StudentModel studentModel, ModelMap model) {
        List<QaStudent> students = instructorManager.getStudents(getCurrentInstructor());
        model.addAttribute("studentModels", transformer.transformStudents(students));
        model.put(BREADCRUMB, "Student List");
        model.put(TITLE, "Student List");
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
        Date dob = extractDob(studentModel);

        registrationManager.updateStudent(student, studentModel.getUsername(), studentModel.getPassword(),
                studentModel.getName(), studentModel.getNric(), dob);

        // check if password does not match
        if (!studentModel.getPassword().equals(studentModel.getPasswordAgain())) {
            model.addAttribute(MSG_ERROR, "Password does not match");
            return "secure/student/student_register";
        }

        model.addAttribute(MSG_SUCCESS, "Student successfully updated");
        return "redirect:/secure/student/view/" + student.getId();
    }

    /**
     * Split DOB into year, month and day
     *
     * @param studentModel
     * @return
     */
    private static Date extractDob(StudentModel studentModel) {
        return new LocalDate(Integer.parseInt(studentModel.getDob_yyyy()),
                Integer.parseInt(studentModel.getDob_mm()),
                Integer.parseInt(studentModel.getDob_dd())).toDate();
    }
}
