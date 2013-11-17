package my.gov.kpn.quiz.web.server;

import my.gov.kpn.quiz.biz.manager.CompetitionManager;
import my.gov.kpn.quiz.core.model.QaMultipleChoiceQuestion;
import my.gov.kpn.quiz.core.model.QaQuestion;
import my.gov.kpn.quiz.web.client.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author rafizan.baharum
 * @since 11/12/13
 */
@Component("quizConverter")
public class QuizConverter {

    @Autowired
    private CompetitionManager competitionManager;

    public QuestionModel convert(QaQuestion question) {
        QuestionModel model = newInstance(question);
        model.setId(question.getId());
        model.setStatement(question.getStatement());
        model.setQuestionType(QuestionType.get(question.getQuestionType().ordinal()));
        return model;
    }

    private QuestionModel newInstance(QaQuestion question) {
        QuestionModel model = null;
        switch (question.getQuestionType()) {
            case MULTIPLE_CHOICE:
                model = new MultipleChoiceQuestionModel();
                ((MultipleChoiceQuestionModel) model).setChoice1(((QaMultipleChoiceQuestion) question).getChoice1());
                ((MultipleChoiceQuestionModel) model).setChoice2(((QaMultipleChoiceQuestion) question).getChoice2());
                ((MultipleChoiceQuestionModel) model).setChoice3(((QaMultipleChoiceQuestion) question).getChoice3());
                ((MultipleChoiceQuestionModel) model).setChoice4(((QaMultipleChoiceQuestion) question).getChoice4());
                break;
            case BOOLEAN:
                model = new BooleanQuestionModel();
                break;
            case SUBJECTIVE:
                model = new SubjectiveQuestionModel();
                break;
        }
        return model;
    }

}
