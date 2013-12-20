package my.gov.kpn.quiz.web.controller.secure;

import my.gov.kpn.quiz.biz.manager.InstructorManager;
import my.gov.kpn.quiz.core.model.QaParticipant;
import my.gov.kpn.quiz.core.model.QaParticipantSortType;
import my.gov.kpn.quiz.core.model.QaQuiz;
import my.gov.kpn.quiz.web.controller.AbstractController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author rafizan.baharum
 * @since 12/1/13
 */
@Controller("SecureParticipantController")
@RequestMapping("/secure/participant")
public class ParticipantController extends AbstractController {

    private static final Logger log = Logger.getLogger(QuizController.class);
    private static final int LIMIT = 50;

    @Autowired
    private InstructorManager instructorManager;

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public String list(@RequestParam Long quizId, ModelMap model) {
        QaQuiz quiz = competitionManager.findQuizById(quizId);
        model.addAttribute("quizModel", transformer.transform(quiz));
        model.addAttribute("participantModels", transformer.transformParticipants(competitionManager.findParticipants(quiz)));
        return "secure/participant/participant_list";
    }

    @RequestMapping(value = "/view/{id}", method = {RequestMethod.GET})
    public String view(@PathVariable Long id, ModelMap model) {
        QaParticipant participant = competitionManager.findParticipantById(id);
        QaQuiz quiz = participant.getQuiz();
        model.addAttribute("quizModel", transformer.transform(quiz));
        model.addAttribute("participantModel", transformer.transform(participant));
        return "secure/participant/participant_view";
    }

    @RequestMapping(value = "/select/{id}", method = {RequestMethod.GET})
    public String select(@PathVariable Long id, ModelMap model) {
        QaParticipant participant = competitionManager.findParticipantById(id);
        QaQuiz quiz = participant.getQuiz();
        competitionManager.selectParticipantForNextRound(quiz, participant);
        log.debug("selecting: " + participant.getUser().getName() + " for next round");

        model.addAttribute("quizModel", transformer.transform(quiz));
        model.addAttribute("participantModel", transformer.transform(participant));

        return "redirect:/secure/participant/view/" + participant.getId();
    }

    // page is one-based

    /**
     * ?page=x&quizId=y
     */
    @RequestMapping(value = "/browse", method = {RequestMethod.GET})
    public String browse(@RequestParam Integer page, @RequestParam Long quizId, ModelMap model) {
        QaQuiz quiz = competitionManager.findQuizById(quizId);
        Integer count = competitionManager.countParticipant(quiz) / 50;
        Integer offset = (page - 1) * LIMIT;
        model.addAttribute("count", count);
        model.addAttribute("page", page);
        model.addAttribute("next", page + 1);
        model.addAttribute("previous", page - 1);
        model.addAttribute("hasNext", page < count ? true : false);
        model.addAttribute("hasPrevious", page > 1 ? true : false);
        model.addAttribute("quizModel", transformer.transform(quiz));
        model.addAttribute("participantModels", transformer.transformParticipants(competitionManager.findParticipants(quiz, offset, LIMIT)));
        printDebug();

        return "secure/participant/participant_browse";
    }

    @RequestMapping(value = "/browse/sort", method = {RequestMethod.GET})
    public String sort(@RequestParam Integer page, @RequestParam Long quizId,
                       @RequestParam(value = "sortOption", required = false, defaultValue = "99") Integer sortOption, ModelMap model) {
        // TODO Handle "Please Select"?
        if (sortOption == 99) return browse(page, quizId, model);

        QaParticipantSortType sortType = QaParticipantSortType.get(sortOption);
        QaQuiz quiz = competitionManager.findQuizById(quizId);
        Integer count = competitionManager.countParticipant(quiz) / 50;
        Integer offset = (page - 1) * LIMIT;
        model.addAttribute("count", count);
        model.addAttribute("page", page);
        model.addAttribute("next", page + 1);
        model.addAttribute("previous", page - 1);
        model.addAttribute("hasNext", page < count ? true : false);
        model.addAttribute("hasPrevious", page > 1 ? true : false);
        model.addAttribute("quizModel", transformer.transform(quiz));
        model.addAttribute("participantModels", transformer.transformParticipants(competitionManager.findParticipants(quiz, sortType, offset, LIMIT)));
        printDebug();

        return "secure/participant/participant_browse";
    }

    private void printDebug() {
        //        log.debug("count: " + count);
//        log.debug("offset: " + offset);
//        log.debug("limit: " + LIMIT);
//        log.debug("page: " + page);
//        log.debug("previous: " + (page - 1));
//        log.debug("next: " + (page + 1));
//        log.debug("hasPrev: " + (page > 1 ? true : false));
//        log.debug("hasNext: " + (page < count ? true : false));
    }
}
