package my.gov.kpn.quiz.web.controller.secure;

import my.gov.kpn.quiz.biz.manager.InstructorManager;
import my.gov.kpn.quiz.biz.manager.RegistrationManager;
import my.gov.kpn.quiz.core.model.QaInstructor;
import my.gov.kpn.quiz.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("SecureInstructorController")
@RequestMapping("/secure/instructor")
public class InstructorController extends AbstractController {

    private static final int LIMIT = 50;

    @Autowired
    private RegistrationManager registrationManager;

    @Autowired
    private InstructorManager instructorManager;

    @RequestMapping(value = "/view/{id}", method = {RequestMethod.GET})
    public String view(@PathVariable Long id, ModelMap model) {
        QaInstructor instructor = instructorManager.findInstructorById(id);
        model.addAttribute("instructorModel", transformer.transform(instructor));
        model.addAttribute("studentModels", transformer.transformStudents(instructorManager.findStudents(instructor)));
        return "secure/instructor/instructor_view";
    }


    /**
     * ?page=x&quizId=y
     */
    @RequestMapping(value = "/browse", method = {RequestMethod.GET})
    public String browse(@RequestParam Integer page, ModelMap model) {
        Integer count = instructorManager.countInstructor() / 50;
        Integer offset = (page - 1) * LIMIT;
        model.addAttribute("count", count);
        model.addAttribute("page", page);
        model.addAttribute("next", page + 1);
        model.addAttribute("previous", page - 1);
        model.addAttribute("hasNext", page < count ? true : false);
        model.addAttribute("hasPrevious", page > 1 ? true : false);
        model.addAttribute("instructorModels", transformer.transformInstructors(instructorManager.findInstructors(offset, LIMIT)));
        return "secure/instructor/instructor_browse";
    }


}
