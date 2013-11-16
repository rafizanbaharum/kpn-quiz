package my.gov.kpn.quiz.web.controller.secure;

import my.gov.kpn.quiz.biz.manager.InstructorManager;
import my.gov.kpn.quiz.biz.manager.QuizManager;
import my.gov.kpn.quiz.core.model.QaQuiz;
import my.gov.kpn.quiz.core.model.impl.QaQuizImpl;
import my.gov.kpn.quiz.web.controller.AbstractController;
import my.gov.kpn.quiz.web.model.QuizModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("SecureQuizController")
@RequestMapping("/secure/quiz")
public class QuizController extends AbstractController {

    @Autowired
    private InstructorManager instructorManager;

    @Autowired
    private QuizManager quizManager;

    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public String quizList(@ModelAttribute("quizModel") QuizModel quizModel, ModelMap model) {
        QaQuiz quiz = quizManager.findQuizById(quizModel.getId());
        model.addAttribute("quizModels", transformer.transformQuestions(quizManager.findQuestions(quiz)));
        return "secure/quiz/quiz_list";
    }

    @RequestMapping(value = "/view/{id}", method = {RequestMethod.GET})
    public String quizView(@PathVariable Long id, ModelMap model) {
        QaQuiz quiz = quizManager.findQuizById(id);
        model.addAttribute("quizModel", transformer.transform(quiz));
        model.addAttribute("questionModels", transformer.transformQuestions(quizManager.findQuestions(quiz)));
        return "secure/quiz/quiz_view";
    }

    @RequestMapping(value = "/edit/{id}", method = {RequestMethod.GET})
    public String quizEdit(@PathVariable Long id, ModelMap model) {
        QaQuiz quiz = quizManager.findQuizById(id);
        model.addAttribute("quizModel", transformer.transform(quiz));
        return "secure/quiz/quiz_edit";
    }

    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public String quizAdd(@ModelAttribute("quizModel") QuizModel quizModel,
                          ModelMap model) {
        QaQuiz quiz = new QaQuizImpl();
        quiz.setTitle(quizModel.getTitle());
//        quiz.setStartDate();
//        quiz.setEndDate();
        quizManager.saveQuiz(quiz);

        model.addAttribute(MSG_SUCCESS, "Quiz successfully added");
        return "redirect:secure/quiz/view/" + quiz.getId();
    }


    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public String quizUpdate(@ModelAttribute("quizModel") QuizModel quizModel,
                             ModelMap model) {
        QaQuiz quiz = quizManager.findQuizById(quizModel.getId());
        quiz.setTitle(quizModel.getTitle());
//        quiz.setStartDate();
//        quiz.setEndDate();
        quizManager.updateQuiz(quiz);

        model.addAttribute(MSG_SUCCESS, "Quiz successfully updated");
        return "redirect:secure/quiz/view/" + quiz.getId();
    }

}
