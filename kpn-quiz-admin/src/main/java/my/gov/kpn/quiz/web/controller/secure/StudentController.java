package my.gov.kpn.quiz.web.controller.secure;

import my.gov.kpn.quiz.biz.manager.CompetitionManager;
import my.gov.kpn.quiz.core.dao.QaCompetitionDao;
import my.gov.kpn.quiz.core.model.QaCompetition;
import my.gov.kpn.quiz.core.model.QaStudent;
import my.gov.kpn.quiz.web.controller.AbstractController;
import my.gov.kpn.quiz.web.model.StudentModel;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

@Controller("SecureStudentController")
@RequestMapping("/secure/student")
public class StudentController extends AbstractController {

    private static final Logger log = Logger.getLogger(StudentController.class);

    private final String BREADCRUMB = "STUDENT_BREADCRUMB";
    private final String TITLE = "STUDENT_TITLE";

    @Autowired
    private CompetitionManager competitionManager;

    @Autowired
    private QaCompetitionDao competitionDao;

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

        // NRIC as username. Just copy it.
        studentModel.setUsername(studentModel.getNricNo());

        if (registrationManager.isExists(studentModel.getUsername())) {
            model.addAttribute(studentModel);
            model.addAttribute(MSG_ERROR, "User already exists");
            return "secure/student/student_register";
        }

        if (!studentModel.getNricNo().equals(studentModel.getConfirmNricNo())) {
            model.addAttribute(studentModel);
            model.addAttribute(MSG_ERROR, "NRIC No does not match. Please re-enter the same value");
            return "secure/student/student_register";
        }

        QaCompetition competition = competitionDao.findByYear(LocalDate.now().getYear());
        log.debug("Year of competition = " + competition);
        if (null == competition) {
            model.addAttribute(studentModel);
            model.addAttribute(MSG_ERROR, "An error occurred! Competition is not exist. Please contact system administrator.");
            return "secure/student/student_register";
        }

        Integer dobYear = Integer.valueOf(studentModel.getDob_yyyy());
        int diff = competition.getYear() - dobYear;
        log.debug("Diff DOB and competition year = " + diff);
        log.debug(MessageFormat.format("Start constraint = {0} / End Constraint = {1}",
                competition.getStartConstraint(), competition.getEndConstraint()));

        if (!((diff >= competition.getStartConstraint()) && diff <= competition.getEndConstraint())) {
            model.addAttribute(studentModel);
            model.addAttribute(MSG_ERROR, MessageFormat.format("Age must be between {0} and {1} on {2}",
                    competition.getStartConstraint(), competition.getEndConstraint(), String.valueOf(competition.getYear())));
            return "secure/student/student_register";
        }

        registrationManager.registerStudent(
                studentModel.getUsername(),
                generatePassword(studentModel.getNricNo()),
                studentModel.getName(),
                studentModel.getNricNo(),
                extractDob(studentModel),
                Integer.parseInt(studentModel.getGenderType()),
                Integer.parseInt(studentModel.getRaceType()),
                getCurrentInstructor());

        model.addAttribute(MSG_SUCCESS, "Student registered");
        return studentList(new StudentModel(), model);
    }

    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public String studentList(@ModelAttribute("studentModel") StudentModel studentModel, ModelMap model) {
        List<QaStudent> students = instructorManager.findStudents(getCurrentInstructor());
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

        // no need to validate nric because it's read only

        QaStudent student = instructorManager.findStudentById(studentModel.getId());
        registrationManager.updateStudent(
                student,
                studentModel.getName(),
                extractDob(studentModel),
                Integer.parseInt(studentModel.getGenderType()),
                Integer.parseInt(studentModel.getRaceType())
        );

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
        QaCompetition competition = competitionManager.findCompetitionByYear(competitionManager.getCurrentYearCompetition().getYear());
        DateTime endDate = new DateTime(competition.getEndDate());
        DateTime today = new DateTime(new Date());
        return (today.isAfter(endDate));
    }


    /**
     * Get the first 6 digit of nric no
     *
     * @param nricNo
     * @return
     */
    private static String generatePassword(String nricNo) {
        return StringUtils.substring(nricNo, 0, 6);
    }
}
