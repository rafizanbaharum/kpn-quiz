package my.gov.kpn.quiz.web.controller.secure;

import my.gov.kpn.quiz.biz.manager.CompetitionManager;
import my.gov.kpn.quiz.biz.manager.InstructorManager;
import my.gov.kpn.quiz.core.model.QaQuiz;
import my.gov.kpn.quiz.core.model.impl.QaQuizImpl;
import my.gov.kpn.quiz.web.controller.AbstractController;
import my.gov.kpn.quiz.web.model.QuizModel;
import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller("SecureQuizController")
@RequestMapping("/secure/quiz")
public class QuizController extends AbstractController {

    private static final Logger log = Logger.getLogger(QuizController.class);

    @Autowired
    private InstructorManager instructorManager;

    @Autowired
    private CompetitionManager competitionManager;

    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public String quizList(@ModelAttribute("quizModel") QuizModel quizModel, ModelMap model) {
        model.addAttribute("quizModels", transformer.transformQuizzes(competitionManager.findQuizzes()));
        return "secure/quiz/quiz_list";
    }

    @RequestMapping(value = "/view/{id}", method = {RequestMethod.GET})
    public String quizView(@PathVariable Long id, ModelMap model) {
        QaQuiz quiz = competitionManager.findQuizById(id);
        model.addAttribute("quizModel", transformer.transform(quiz));
        model.addAttribute("questionModels", transformer.transformQuestions(competitionManager.findQuestions(quiz)));
        return "secure/quiz/quiz_view";
    }

    @RequestMapping(value = "/remove/{id}", method = {RequestMethod.GET})
    public String quizRemove(@PathVariable Long id, ModelMap model) {
        QaQuiz quiz = competitionManager.findQuizById(id);

        // check
        if (competitionManager.hasQuestion(quiz) && competitionManager.hasParticipant(quiz)) {
            model.addAttribute(MSG_ERROR, "Quiz cannot be removed");
            return "redirect:/secure/quiz/view/" + quiz.getId();
        } else {
            competitionManager.removeQuiz(quiz);
            model.addAttribute(MSG_SUCCESS, "Quiz successfully removed");
            return "redirect:/secure/quiz/list";
        }
    }

    @RequestMapping(value = "/view/{id}/participant/list", method = {RequestMethod.GET})
    public String quizViewParticipantList(@PathVariable Long id, ModelMap model) {
        QaQuiz quiz = competitionManager.findQuizById(id);
        model.addAttribute("quizModel", transformer.transform(quiz));
        model.addAttribute("participantModels", transformer.transformParticipants(competitionManager.findParticipants(quiz)));
        return "secure/participant/participant_list";
    }

    // page is one-based
    @RequestMapping(value = "/view/{id}/participant/browse/{page}", method = {RequestMethod.GET})
    public String quizViewParticipantBrowse(@PathVariable Long id, @PathVariable Integer page, ModelMap model) {
        QaQuiz quiz = competitionManager.findQuizById(id);
        Integer count = competitionManager.countParticipant(quiz);
        model.addAttribute("quizModel", transformer.transform(quiz));
        model.addAttribute("count", count);
        model.addAttribute("page", page);
        model.addAttribute("next", page + 1);
        model.addAttribute("previous", page - 1);
        model.addAttribute("hasNext", page < count ? true : false);
        model.addAttribute("hasPrevious", page > 1 ? true : false);
        model.addAttribute("participantModel", transformer.transform(competitionManager.findParticipants(quiz, 1, page).get(0)));

        log.debug("count: " + count);
        log.debug("page: " + page);
        log.debug("previous: " + (page - 1));
        log.debug("next: " + (page + 1));
        log.debug("hasPrev: " + (page > 1 ? true : false));
        log.debug("hasNext: " + (page < count ? true : false));


        return "secure/participant/participant_browse";
    }

    @RequestMapping(value = "/view/{id}/participant/select/{selection}", method = {RequestMethod.GET})
    public String quizViewParticipantSelect(@PathVariable Long id, @PathVariable String selection, ModelMap model) {
        // select next round
        QaQuiz quiz = competitionManager.findQuizById(id);
        QaQuiz nextQuiz = competitionManager.finQuizByRound(quiz.getRound() + 1);

        if (selection.equals("random50")) {
            competitionManager.selectRandomParticipants(quiz, nextQuiz, 50);
            model.addAttribute(MSG_SUCCESS, "Participant successfully selected");
            return "redirect:/secure/quiz/view/" + nextQuiz.getId() + "/participant/list";
        } else if (selection.equals("top50")) {
            competitionManager.selectTopParticipants(quiz, nextQuiz, 50);
            model.addAttribute(MSG_SUCCESS, "Participant successfully selected");
            return "redirect:/secure/quiz/view/" + nextQuiz.getId() + "/participant/list";
        } else if (selection.equals("fairplay")) {
            competitionManager.selectFairPlayParticipants(quiz, nextQuiz, 50);
            model.addAttribute(MSG_SUCCESS, "Participant successfully selected");
            return "redirect:/secure/quiz/view/" + nextQuiz.getId() + "/participant/list";
        } else if (selection.equals("reset")) {
            competitionManager.resetParticipants(quiz);
            model.addAttribute(MSG_SUCCESS, "Participant successfully reset");
            return "redirect:/secure/quiz/view/" + quiz.getId() + "/participant/list";
        }
        return "redirect:/secure/quiz/view/" + quiz.getId();
    }


    @RequestMapping(value = "/edit/{id}", method = {RequestMethod.GET})
    public String quizEdit(@PathVariable Long id, ModelMap model) {
        QaQuiz quiz = competitionManager.findQuizById(id);
        model.addAttribute("quizModel", transformer.transform(quiz));
        return "secure/quiz/quiz_edit";
    }

    @RequestMapping(value = "/add", method = {RequestMethod.GET})
    public String quizAdd(@ModelAttribute("quizModel") QuizModel quizModel,
                          ModelMap model) {
        return "secure/quiz/quiz_add";
    }

    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public String quizSave(@ModelAttribute("quizModel") QuizModel quizModel,
                           ModelMap model) {
        QaQuiz quiz = new QaQuizImpl();
        quiz.setCompetition(competitionManager.findCompetitionByYear(2013));
        quiz.setTitle(quizModel.getTitle());
        quiz.setProcessed(false);
        quiz.setLocked(false);
        quiz.setRound(quizModel.getRound());
        quiz.setStartDate(extractStartDate(quizModel));
        quiz.setEndDate(extractEndDate(quizModel));
        competitionManager.saveQuiz(quiz);

        model.addAttribute(MSG_SUCCESS, "Quiz successfully saved");
        return "redirect:/secure/quiz/list";
    }

    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public String quizUpdate(@ModelAttribute("quizModel") QuizModel quizModel,
                             ModelMap model) {
        QaQuiz quiz = competitionManager.findQuizById(quizModel.getId());
        quiz.setTitle(quizModel.getTitle());
        quiz.setRound(quizModel.getRound());
        quiz.setStartDate(extractStartDate(quizModel));
        quiz.setEndDate(extractEndDate(quizModel));
        competitionManager.updateQuiz(quiz);

        model.addAttribute(MSG_SUCCESS, "Quiz successfully updated");
        return "redirect:/secure/quiz/view/" + quiz.getId();
    }

    @RequestMapping(value = "/tabulate/{id}", method = {RequestMethod.GET})
    public String quizTabulate(@ModelAttribute("quizModel") QuizModel quizModel,
                               ModelMap model) {
        QaQuiz quiz = competitionManager.findQuizById(quizModel.getId());
        competitionManager.tabulateResult(quiz);

        model.addAttribute(MSG_SUCCESS, "Quiz successfully tabulated");
        return "redirect:/secure/quiz/view/" + quiz.getId();
    }


    @RequestMapping(value = "/process/{id}", method = {RequestMethod.GET})
    public String quizProcess(@ModelAttribute("quizModel") QuizModel quizModel,
                              ModelMap model) {
        QaQuiz quiz = competitionManager.findQuizById(quizModel.getId());
        competitionManager.processGradebook(quiz);

        model.addAttribute(MSG_SUCCESS, "Quiz successfully processed");
        return "redirect:/secure/round/view/" + quiz.getId();
    }

    @RequestMapping(value = "/init/{id}", method = {RequestMethod.GET})
    public String quizInit(@ModelAttribute("quizModel") QuizModel quizModel,
                           ModelMap model) {
        QaQuiz quiz = competitionManager.findQuizById(quizModel.getId());
        competitionManager.processParticipant(quiz);

        model.addAttribute(MSG_SUCCESS, "Quiz successfully inited");
        return "redirect:/secure/quiz/view/" + quiz.getId();
    }


    private static Date extractStartDate(QuizModel quizModel) {
        return new LocalDate(Integer.parseInt(quizModel.getStartDate_yyyy()),
                Integer.parseInt(quizModel.getStartDate_mm()),
                Integer.parseInt(quizModel.getStartDate_dd())).toDate();
    }

    private static Date extractEndDate(QuizModel quizModel) {
        return new LocalDate(Integer.parseInt(quizModel.getEndDate_yyyy()),
                Integer.parseInt(quizModel.getEndDate_mm()),
                Integer.parseInt(quizModel.getEndDate_dd())).toDate();
    }
}
