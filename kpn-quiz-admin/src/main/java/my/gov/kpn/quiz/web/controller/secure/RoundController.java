package my.gov.kpn.quiz.web.controller.secure;

import my.gov.kpn.quiz.biz.manager.InstructorManager;
import my.gov.kpn.quiz.biz.manager.QuizManager;
import my.gov.kpn.quiz.core.model.QaRound;
import my.gov.kpn.quiz.core.model.impl.QaRoundImpl;
import my.gov.kpn.quiz.web.controller.AbstractController;
import my.gov.kpn.quiz.web.model.RoundModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public String updateRound(@ModelAttribute("roundModel") RoundModel roundModel,
                              ModelMap model) {
        QaRound round = quizManager.findRoundById(roundModel.getId());
        round.setName(roundModel.getName());
        round.setProcessed(false);
        round.setLocked(false);

        model.addAttribute(MSG_SUCCESS, "Round successfully updated");
        return "redirect:secure/round/view/" + round.getId();
    }

    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public String addRound(@ModelAttribute("roundModel") RoundModel roundModel,
                           ModelMap model) {
        QaRound round = new QaRoundImpl();
        round.setCompetition(quizManager.findCompetitionByYear(2013));
        round.setName(roundModel.getName());
        round.setProcessed(false);
        round.setLocked(false);

        model.addAttribute(MSG_SUCCESS, "Round successfully added");
        return "secure/round/round_view";
    }
}
