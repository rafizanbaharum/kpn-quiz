package my.gov.kpn.quiz.web.controller.secure;

import my.gov.kpn.quiz.core.model.QaParticipant;
import my.gov.kpn.quiz.core.model.QaQuiz;
import my.gov.kpn.quiz.core.model.impl.QaQuizImpl;
import my.gov.kpn.quiz.web.controller.AbstractController;
import my.gov.kpn.quiz.web.model.*;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
    private QuestionController questionController;

    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public String quizList(@ModelAttribute("quizModel") QuizModel quizModel, ModelMap model) {
        model.addAttribute("competitionModel", transformer.transform(competitionManager.findCompetitionByYear(2013)));
        model.addAttribute("quizModels", transformer.transformQuizzes(competitionManager.findQuizzes()));
        return "secure/quiz/quiz_list";
    }

    @RequestMapping(value = "/view/{id}", method = {RequestMethod.GET})
    public String quizView(@PathVariable Long id, ModelMap model) {
        QaQuiz quiz = competitionManager.findQuizById(id);
        QaParticipant participant = competitionManager.findCurrentParticipant(quiz);
        model.addAttribute("quizModel", transformer.transform(quiz));
        model.addAttribute("questionModels", transformer.transformQuestions(competitionManager.findQuestions(quiz, participant)));
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
    public String quizSave(@ModelAttribute("quizModel") QuizModel quizModel, BindingResult bindingResult,
                           ModelMap model) {


        if (!NumberUtils.isNumber(quizModel.getRound())) {
            FieldError fieldError = new FieldError("quizModel", "round", messageSource.getMessage("Integer.quizModel.round", null, null));
            bindingResult.addError(fieldError);
        }

        if (bindingResult.hasErrors()) {
            model.put(MSG_ERROR, "Error! Please check your data.");
            return quizAdd(quizModel, model);
        }

        QaQuiz quiz = new QaQuizImpl();
        quiz.setCompetition(competitionManager.findCompetitionByYear(2013));
        quiz.setTitle(quizModel.getTitle());
        quiz.setProcessed(false);
        quiz.setLocked(false);
        quiz.setRound(Integer.valueOf(quizModel.getRound()));
        quiz.setStartDate(extractStartDate(quizModel));
        quiz.setEndDate(extractEndDate(quizModel));
        QaQuiz savedQuiz = competitionManager.saveQuiz(quiz);

        model.addAttribute(MSG_SUCCESS, "Quiz successfully saved");
        return "redirect:/secure/quiz/view/" + savedQuiz.getId();
    }


    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public String quizUpdate(@ModelAttribute("quizModel") QuizModel quizModel,
                             ModelMap model) {
        QaQuiz quiz = competitionManager.findQuizById(quizModel.getId());
        quiz.setTitle(quizModel.getTitle());
        quiz.setRound(Integer.valueOf(quizModel.getRound()));
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

    @RequestMapping(value = "/view/{id}/question/add/{type}", method = {RequestMethod.GET})
    public String quizViewQuestionAdd(@PathVariable Long id,
                                      @PathVariable String type, ModelMap model) {
        QaQuiz quiz = competitionManager.findQuizById(id);
        QuizModel quizModel = transformer.transform(quiz);
        model.addAttribute("quizModel", quizModel);

        QuestionModel questionModel;
        if (type.equals("multiplechoice")) {
            questionModel = new MultipleChoiceQuestionModel();
        } else if (type.equals("boolean")) {
            questionModel = new BooleanQuestionModel();
        } else if (type.equals("subjective")) {
            questionModel = new SubjectiveQuestionModel();
        } else {
            questionModel = new MultipleChoiceQuestionModel();
        }

        questionModel.setQuiz(quizModel);
        model.addAttribute("questionModel", questionModel);
        return questionController.addQuestion(type, model);

    }


    @RequestMapping(value = "/process/{id}", method = {RequestMethod.GET})
    public String quizProcess(@ModelAttribute("quizModel") QuizModel quizModel,
                              ModelMap model) {
        QaQuiz quiz = competitionManager.findQuizById(quizModel.getId());
        competitionManager.processGradebook(quiz);

        model.addAttribute(MSG_SUCCESS, "Quiz successfully processed");
        return "redirect:/secure/quiz/view/" + quiz.getId();
    }


    @RequestMapping(value = "/current/{id}", method = {RequestMethod.GET})
    public String quizCurrent(@ModelAttribute("quizModel") QuizModel quizModel,
                              ModelMap model) {
        QaQuiz quiz = competitionManager.findQuizById(quizModel.getId());
        competitionManager.setCurrentQuiz(quiz);

        model.addAttribute(MSG_SUCCESS, "Quiz successfully set to current");
        return "redirect:/secure/quiz/view/" + quiz.getId();
    }

    @RequestMapping(value = "/init/{id}", method = {RequestMethod.GET})
    public String quizInit(@ModelAttribute("quizModel") QuizModel quizModel,
                           ModelMap model) {
        QaQuiz quiz = competitionManager.findQuizById(quizModel.getId());
        competitionManager.processParticipant(quiz);

        model.addAttribute(MSG_SUCCESS, "Quiz successfully inited");
        return "redirect:/secure/quiz/view/" + quiz.getId();
    }


    private Date extractStartDate(QuizModel quizModel) {
        return new LocalDateTime(
                Integer.parseInt(quizModel.getStartDate_yyyy()),
                Integer.parseInt(quizModel.getStartDate_MM()),
                Integer.parseInt(quizModel.getStartDate_dd()),
                Integer.parseInt(quizModel.getStartDate_hh()),
                Integer.parseInt(quizModel.getStartDate_mm()))
                .toDate();
    }

    private Date extractEndDate(QuizModel quizModel) {
        return new LocalDateTime(
                Integer.parseInt(quizModel.getEndDate_yyyy()),
                Integer.parseInt(quizModel.getEndDate_MM()),
                Integer.parseInt(quizModel.getEndDate_dd()),
                Integer.parseInt(quizModel.getEndDate_hh()),
                Integer.parseInt(quizModel.getEndDate_mm()))
                .toDate();
    }
}
