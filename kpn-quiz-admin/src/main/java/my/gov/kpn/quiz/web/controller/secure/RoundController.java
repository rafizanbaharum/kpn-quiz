package my.gov.kpn.quiz.web.controller.secure;

import my.gov.kpn.quiz.biz.manager.CompetitionManager;
import my.gov.kpn.quiz.biz.manager.InstructorManager;
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
    private CompetitionManager competitionManager;

    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public String roundList(ModelMap model) {
        model.addAttribute("roundModels", transformer.transformRounds(competitionManager.findRounds()));
        return "secure/round/round_list";
    }

    @RequestMapping(value = "/view/{id}", method = {RequestMethod.GET})
    public String roundView(@PathVariable Long id, ModelMap model) {
        QaRound round = competitionManager.findRoundById(id);
        model.addAttribute("roundModel", transformer.transform(round));
        model.addAttribute("quizModels", transformer.transformQuizzes(competitionManager.findQuizzes(round)));
        model.addAttribute("participantCount", competitionManager.countParticipant(round));
        return "secure/round/round_view";
    }

    @RequestMapping(value = "/edit/{id}", method = {RequestMethod.GET})
    public String roundEdit(@PathVariable Long id, ModelMap model) {
        model.addAttribute("roundModel", transformer.transform(competitionManager.findRoundById(id)));
        return "secure/round/round_edit";
    }

    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public String roundUpdate(@ModelAttribute("roundModel") RoundModel roundModel,
                              ModelMap model) {
        QaRound round = competitionManager.findRoundById(roundModel.getId());
        round.setName(roundModel.getName());
        round.setProcessed(false);
        round.setLocked(false);

        model.addAttribute(MSG_SUCCESS, "Round successfully updated");
        return "redirect:/secure/round/view/" + round.getId();
    }

    @RequestMapping(value = "/process/{id}", method = {RequestMethod.GET})
    public String roundProcess(@ModelAttribute("roundModel") RoundModel roundModel,
                               ModelMap model) {
        QaRound round = competitionManager.findRoundById(roundModel.getId());
        competitionManager.processGradebook(round);

        model.addAttribute(MSG_SUCCESS, "Round successfully updated");
        return "redirect:/secure/round/view/" + round.getId();
    }

    @RequestMapping(value = "/init/{id}", method = {RequestMethod.GET})
    public String roundInit(@ModelAttribute("roundModel") RoundModel roundModel,
                            ModelMap model) {
        QaRound round = competitionManager.findRoundById(roundModel.getId());
        competitionManager.processParticipant(round);

        model.addAttribute(MSG_SUCCESS, "Round successfully inited");
        return "redirect:/secure/round/view/" + round.getId();
    }


    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public String roundAdd(@ModelAttribute("roundModel") RoundModel roundModel,
                           ModelMap model) {
        QaRound round = new QaRoundImpl();
        round.setCompetition(competitionManager.findCompetitionByYear(2013));
        round.setName(roundModel.getName());
        round.setProcessed(false);
        round.setLocked(false);

        model.addAttribute(MSG_SUCCESS, "Round successfully added");
        return "secure/round/round_view";
    }
}
