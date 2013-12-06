package my.gov.kpn.quiz.web.controller.secure;

import my.gov.kpn.quiz.biz.manager.CompetitionManager;
import my.gov.kpn.quiz.biz.manager.InstructorManager;
import my.gov.kpn.quiz.core.model.*;
import my.gov.kpn.quiz.core.model.impl.QaBooleanQuestionImpl;
import my.gov.kpn.quiz.core.model.impl.QaMultipleChoiceQuestionImpl;
import my.gov.kpn.quiz.core.model.impl.QaSubjectiveQuestionImpl;
import my.gov.kpn.quiz.web.controller.AbstractController;
import my.gov.kpn.quiz.web.model.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller("SecureQuestionController")
@RequestMapping("/secure/question")
public class QuestionController extends AbstractController {

    private static final Logger log = Logger.getLogger(QuestionController.class);

    @Autowired
    private InstructorManager instructorManager;

    @Autowired
    private CompetitionManager competitionManager;

    public enum MultipleChoiceAnswerType {
        D,
        C,
        B,
        A
    }

    public enum BooleanChoiceAnswerType {
        FALSE,
        TRUE,
    }

    public enum DifficultiesType {
        Difficult,
        Intermediate,
        Easy
    }

    @RequestMapping(value = "/edit/{id}", method = {RequestMethod.GET})
    public String questionEdit(@PathVariable Long id, ModelMap model) {
        QaQuestion question = competitionManager.findQuestionById(id);
        QuestionModel questionModel = transformer.transform(question);
        QuizModel quizModel = transformer.transform(question.getQuiz());
        questionModel.setQuiz(quizModel);
        model.addAttribute("questionModel", questionModel);
        model.addAttribute("quizModel", quizModel);

        String action = null;
        switch (question.getQuestionType()) {
            case MULTIPLE_CHOICE:
                action = "secure/question/multiplechoice_question_edit";
                break;
            case BOOLEAN:
                action = "secure/question/boolean_question_edit";
                break;
            case SUBJECTIVE:
                action = "secure/question/subjective_question_edit";
                break;
        }
        return action;
    }

    @RequestMapping(value = "/view/{id}", method = {RequestMethod.GET})
    public String questionView(@PathVariable Long id, ModelMap model) {
        QaQuestion question = competitionManager.findQuestionById(id);
        QuestionModel questionModel = transformer.transform(question);
        QuizModel quizModel = transformer.transform(question.getQuiz());
        questionModel.setQuiz(quizModel);

        model.addAttribute("questionModel", questionModel);
        model.addAttribute("quizModel", quizModel);

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

        log.debug("savemultiplechoice");
        QaMultipleChoiceQuestion question = new QaMultipleChoiceQuestionImpl();
        question.setStatement(questionModel.getStatement());
        question.setDifficulty(QaDifficulty.get(questionModel.getDifficulty()));
        question.setQuiz(competitionManager.findQuizById(questionModel.getQuiz().getId()));
        question.setChoice1(questionModel.getChoice1());
        question.setChoice2(questionModel.getChoice2());
        question.setChoice3(questionModel.getChoice3());
        question.setChoice4(questionModel.getChoice4());
        question.setAnswerIndex(questionModel.getAnswerIndex());
        QaQuestion savedQuestion = competitionManager.saveQuestion(question);

        model.addAttribute(MSG_SUCCESS, "Question successfully added");
        return "redirect:/secure/question/view/" + savedQuestion.getId();
    }


    @RequestMapping(value = "/saveboolean", method = {RequestMethod.POST})
    public String questionSaveBoolean(@ModelAttribute("questionModel") BooleanQuestionModel questionModel,
                                      ModelMap model) {
        QaBooleanQuestion question = new QaBooleanQuestionImpl();
        question.setStatement(questionModel.getStatement());
        question.setDifficulty(QaDifficulty.EASY);
        question.setQuiz(competitionManager.findQuizById(questionModel.getQuiz().getId()));
        question.setAnswerIndex(questionModel.getAnswerIndex());
        QaQuestion savedQuestion = competitionManager.saveQuestion(question);

        model.addAttribute(MSG_SUCCESS, "Question successfully added");
        return "redirect:/secure/question/view/" + savedQuestion.getId();
    }

    @RequestMapping(value = "/savesubjective", method = {RequestMethod.POST})
    public String questionSaveSubjective(@ModelAttribute("questionModel") SubjectiveQuestionModel questionModel,
                                         ModelMap model) {
        QaSubjectiveQuestion question = new QaSubjectiveQuestionImpl();
        question.setStatement(questionModel.getStatement());
        question.setDifficulty(QaDifficulty.get(questionModel.getDifficulty()));
        question.setQuiz(competitionManager.findQuizById(questionModel.getQuiz().getId()));
        question.setWordLimit(questionModel.getWordLimit());
        question.setAnswerIndex(0);
        question.setAnswerGuide(questionModel.getAnswerGuide());
        QaQuestion savedQuestion = competitionManager.saveQuestion(question);

        model.addAttribute(MSG_SUCCESS, "Question successfully added");
        return "redirect:/secure/question/view/" + savedQuestion.getId();
    }


    @RequestMapping(value = "/updatemultiplechoice", method = {RequestMethod.POST})
    public String questionUpdateMultipleChoice(@ModelAttribute("questionModel") MultipleChoiceQuestionModel questionModel,
                                               ModelMap model) {

        QaMultipleChoiceQuestion question = (QaMultipleChoiceQuestion) competitionManager.findQuestionById(questionModel.getId());
        question.setStatement(questionModel.getStatement());
        question.setDifficulty(QaDifficulty.get(questionModel.getDifficulty()));
        question.setQuiz(competitionManager.findQuizById(questionModel.getQuiz().getId()));
        question.setChoice1(questionModel.getChoice1());
        question.setChoice2(questionModel.getChoice2());
        question.setChoice3(questionModel.getChoice3());
        question.setChoice4(questionModel.getChoice4());
        question.setAnswerIndex(questionModel.getAnswerIndex());
        competitionManager.updateQuestion(question);

        model.addAttribute(MSG_SUCCESS, "Question successfully updated");
        return "redirect:/secure/question/view/" + question.getId();
    }


    @RequestMapping(value = "/updateboolean", method = {RequestMethod.POST})
    public String questionUpdateBoolean(@ModelAttribute("questionModel") BooleanQuestionModel questionModel,
                                        ModelMap model) {
        QaBooleanQuestion question = (QaBooleanQuestion) competitionManager.findQuestionById(questionModel.getId());
        question.setStatement(questionModel.getStatement());
        question.setDifficulty(QaDifficulty.get(questionModel.getDifficulty()));
        question.setQuiz(competitionManager.findQuizById(questionModel.getQuiz().getId()));
        question.setAnswerIndex(questionModel.getAnswerIndex());
        competitionManager.updateQuestion(question);

        model.addAttribute(MSG_SUCCESS, "Question successfully updated");
        return "redirect:/secure/question/view/" + question.getId();
    }


    @RequestMapping(value = "/updatesubjective", method = {RequestMethod.POST})
    public String questionUpdateSubjective(@ModelAttribute("questionModel") SubjectiveQuestionModel questionModel,
                                           ModelMap model) {
        QaSubjectiveQuestion question = (QaSubjectiveQuestion) competitionManager.findQuestionById(questionModel.getId());
        question.setStatement(questionModel.getStatement());
        question.setDifficulty(QaDifficulty.get(questionModel.getDifficulty()));
        question.setQuiz(competitionManager.findQuizById(questionModel.getQuiz().getId()));
        question.setWordLimit(questionModel.getWordLimit());
        question.setAnswerIndex(0);
        question.setAnswerGuide(questionModel.getAnswerGuide());
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

    public String addQuestion(String type, ModelMap model) {
        if (type.equals("multiplechoice")) {
            return "secure/question/multiplechoice_question_add";
        } else if (type.equals("boolean")) {
            return "secure/question/boolean_question_add";
        } else if (type.equals("subjective")) {
            return "secure/question/subjective_question_add";
        } else {
            return "secure/question/multiplechoice_question_add";
        }
    }

    @ModelAttribute("multipleAnswerMap")
    public Map<String, String> multipleAnswerMap() {
        Map<String, String> map = new HashMap<String, String>();
        for (MultipleChoiceAnswerType type : MultipleChoiceAnswerType.values()) {
            map.put(String.valueOf(type.ordinal()), type.name());
        }
        return map;
    }

    @ModelAttribute("booleanAnswerMap")
    public Map<String, String> booleanAnswerMap() {
        Map<String, String> map = new HashMap<String, String>();
        for (BooleanChoiceAnswerType type : BooleanChoiceAnswerType.values()) {
            map.put(String.valueOf(type.ordinal()), type.name());
        }
        return map;
    }

    @ModelAttribute("difficultiesMap")
    public Map<String, String> difficultiesMap() {
        Map<String, String> map = new HashMap<String, String>();
        for (DifficultiesType type : DifficultiesType.values()) {
            map.put(String.valueOf(type.ordinal()), type.name());
        }
        return map;
    }
}
