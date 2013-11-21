package my.gov.kpn.quiz.web.controller.secure;

import my.gov.kpn.quiz.biz.manager.CompetitionManager;
import my.gov.kpn.quiz.biz.manager.InstructorManager;
import my.gov.kpn.quiz.core.model.*;
import my.gov.kpn.quiz.core.model.impl.QaBooleanQuestionImpl;
import my.gov.kpn.quiz.core.model.impl.QaMultipleChoiceQuestionImpl;
import my.gov.kpn.quiz.core.model.impl.QaSubjectiveQuestionImpl;
import my.gov.kpn.quiz.web.controller.AbstractController;
import my.gov.kpn.quiz.web.model.BooleanQuestionModel;
import my.gov.kpn.quiz.web.model.MultipleChoiceQuestionModel;
import my.gov.kpn.quiz.web.model.QuestionModel;
import my.gov.kpn.quiz.web.model.SubjectiveQuestionModel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller("SecureQuestionController")
@RequestMapping("/secure/question")
public class QuestionController extends AbstractController {

    private static final Logger log = Logger.getLogger(QuestionController.class);

    @Autowired
    private InstructorManager instructorManager;

    @Autowired
    private CompetitionManager competitionManager;

    @InitBinder
    public void initBinder(WebDataBinder binder, HttpServletRequest request) {
        if (request.getParameter("questionType").equals("multiplechoice")) {
            log.debug("found a multiple choice");
            request.setAttribute("questionModel", new MultipleChoiceQuestionModel());
        }
    }

    @RequestMapping(value = "/test", method = {RequestMethod.POST})
    public String questionTest(@ModelAttribute("questionModel") QuestionModel questionModel,
                               ModelMap model) {

        log.debug("question: " + questionModel);
        return "";
    }

    @RequestMapping(value = "/edit/{id}", method = {RequestMethod.GET})
    public String questionEdit(@PathVariable Long id, ModelMap model) {
        QaQuestion question = competitionManager.findQuestionById(id);
        model.addAttribute("questionModel", transformer.transform(question));
        return "secure/question/question_edit";
    }

    @RequestMapping(value = "/view/{id}", method = {RequestMethod.GET})
    public String questionView(@PathVariable Long id, ModelMap model) {
        QaQuestion question = competitionManager.findQuestionById(id);
        model.addAttribute("questionModel", transformer.transform(question));
        model.addAttribute("quizModel", transformer.transform(question.getQuiz()));

        String action = null;
        switch (question.getQuestionType()) {
            case MULTIPLE_CHOICE:
                action = "secure/question/multiplechoice_question_view";
                break;
            case BOOLEAN:
                action = "secure/question/boolean_question_view";
                break;
            case SUBJECTIVE:
                action = "secure/question/subjective_question_view";
                break;
        }
        return action;
    }

    @RequestMapping(value = "/savemultiplechoice", method = {RequestMethod.POST})
    public String questionSaveMultipleChoice(@ModelAttribute("questionModel") MultipleChoiceQuestionModel questionModel,
                                             ModelMap model) {
        model.addAttribute(MSG_SUCCESS, "Question successfully added");
        QaMultipleChoiceQuestion question = new QaMultipleChoiceQuestionImpl();
        question.setStatement(questionModel.getStatement());
        question.setDifficulty(QaDifficulty.EASY);
        question.setQuiz(competitionManager.findQuizById(questionModel.getQuiz().getId()));
        question.setWeight(1D);
        question.setChoice1(questionModel.getChoice1());
        question.setChoice2(questionModel.getChoice2());
        question.setChoice3(questionModel.getChoice3());
        question.setChoice4(questionModel.getChoice4());
        question.setAnswerIndex(questionModel.getAnswerIndex());
        question.setAnswerIndex(1);
        QaQuestion savedQuestion = competitionManager.saveQuestion(question);
        return "redirect:/secure/question/view/" + savedQuestion.getId();
    }


    @RequestMapping(value = "/saveboolean", method = {RequestMethod.POST})
    public String questionSaveBoolean(@ModelAttribute("questionModel") BooleanQuestionModel questionModel,
                                      ModelMap model) {
        model.addAttribute(MSG_SUCCESS, "Question successfully added");
        QaBooleanQuestion question = new QaBooleanQuestionImpl();
        question.setStatement(questionModel.getStatement());
        question.setDifficulty(QaDifficulty.EASY);
        question.setQuiz(competitionManager.findQuizById(questionModel.getQuiz().getId()));
        question.setWeight(1D);
        question.setAnswerIndex(questionModel.getAnswerIndex());
        QaQuestion savedQuestion = competitionManager.saveQuestion(question);
        return "redirect:/secure/question/view/" + savedQuestion.getId();
    }

    @RequestMapping(value = "/savesubjective", method = {RequestMethod.POST})
    public String questionSaveSubjective(@ModelAttribute("questionModel") SubjectiveQuestionModel questionModel,
                                         ModelMap model) {
        model.addAttribute(MSG_SUCCESS, "Question successfully added");
        QaSubjectiveQuestion question = new QaSubjectiveQuestionImpl();
        question.setStatement(questionModel.getStatement());
        question.setDifficulty(QaDifficulty.EASY);
        question.setQuiz(competitionManager.findQuizById(questionModel.getQuiz().getId()));
        question.setWeight(1D);
        question.setAnswerIndex(questionModel.getAnswerIndex());
        question.setAnswerGuide(questionModel.getAnswerGuide());
        QaQuestion savedQuestion = competitionManager.saveQuestion(question);
        return "redirect:/secure/question/view/" + savedQuestion.getId();
    }

    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public String questionUpdate(@ModelAttribute("questionModel") QuestionModel questionModel,
                                 ModelMap model) {
        QaQuestion question = competitionManager.findQuestionById(questionModel.getId());
        question.setStatement(questionModel.getStatement());
        competitionManager.updateQuestion(question);

        model.addAttribute(MSG_SUCCESS, "Question successfully updated");
        return "redirect:/secure/question/view/" + question.getId();
    }


    @RequestMapping(value = "/remove/{id}", method = {RequestMethod.GET})
    public String questionRemove(@PathVariable Long id, ModelMap model) {
        QaQuestion question = competitionManager.findQuestionById(id);
        QaQuiz quiz = question.getQuiz();

        // check
        if (competitionManager.hasGradebookItem(question)) {
            model.addAttribute(MSG_ERROR, "Question cannot be removed");
            return "redirect:/secure/question/view/" + question.getId();
        } else {
            competitionManager.removeQuestion(question);
            model.addAttribute(MSG_SUCCESS, "Question successfully removed");
            return "redirect:/secure/quiz/view/" + quiz.getId();
        }
    }
}
