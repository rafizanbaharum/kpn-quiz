package my.gov.kpn.quiz.web.controller.secure;

import my.gov.kpn.quiz.biz.manager.InstructorManager;
import my.gov.kpn.quiz.biz.manager.QuizManager;
import my.gov.kpn.quiz.core.model.QaQuiz;
import my.gov.kpn.quiz.web.controller.AbstractController;
import my.gov.kpn.quiz.web.model.QuizModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String roundList(@ModelAttribute("quizModel") QuizModel quizModel, ModelMap model) {
        QaQuiz quiz = quizManager.findQuizById(quizModel.getId());
        model.addAttribute("quizModels", transformer.transformQuestions(quizManager.findQuestions(quiz)));
        return "secure/quiz/quiz_list";
    }
}
