package my.gov.kpn.quiz.web.controller.secure;

import my.gov.kpn.quiz.biz.manager.CompetitionManager;
import my.gov.kpn.quiz.biz.manager.InstructorManager;
import my.gov.kpn.quiz.core.model.QaQuestion;
import my.gov.kpn.quiz.core.model.QaQuiz;
import my.gov.kpn.quiz.web.controller.AbstractController;
import my.gov.kpn.quiz.web.model.QuestionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("SecureQuestionController")
@RequestMapping("/secure/question")
public class QuestionController extends AbstractController {

    @Autowired
    private InstructorManager instructorManager;

    @Autowired
    private CompetitionManager competitionManager;

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
        return "secure/question/question_view";
    }

    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public String questionAdd(@ModelAttribute("questionModel") QuestionModel questionModel,
                              ModelMap model) {
        model.addAttribute(MSG_SUCCESS, "Question successfully added");
        return "secure/question/question_TODO";
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
