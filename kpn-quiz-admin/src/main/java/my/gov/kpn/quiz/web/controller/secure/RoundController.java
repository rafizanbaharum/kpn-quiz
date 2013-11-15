package my.gov.kpn.quiz.web.controller.secure;

import my.gov.kpn.quiz.biz.manager.InstructorManager;
import my.gov.kpn.quiz.biz.manager.QuizManager;
import my.gov.kpn.quiz.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("SecureRoundController")
@RequestMapping("/secure/round")
public class RoundController extends AbstractController {

    @Autowired
    private InstructorManager instructorManager;

    @Autowired
    private QuizManager quizManager;

    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public String roundList(ModelMap model) {
        model.addAttribute("roundModels", transformer.transformRounds(quizManager.findRounds()));
        return "secure/round/round_list";
    }

    @RequestMapping(value = "/view/{id}", method = {RequestMethod.GET})
    public String roundView(@PathVariable Long id, ModelMap model) {
        model.addAttribute("roundModel", transformer.transform(quizManager.findRoundById(id)));
        return "secure/round/round_view";
    }
}
