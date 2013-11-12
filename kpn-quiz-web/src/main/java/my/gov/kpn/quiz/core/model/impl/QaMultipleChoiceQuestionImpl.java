package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.QaMultipleChoiceQuestion;
import my.gov.kpn.quiz.core.model.QaQuestionType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 11/7/13
 */
@Table(name = "QA_MCQN")
@Entity(name = "QaMultipleChoiceQuestion")
public class QaMultipleChoiceQuestionImpl extends QaQuestionImpl implements QaMultipleChoiceQuestion {

    @Column(name = "CHOICE_1")
    private String choice1;

    @Column(name = "CHOICE_2")
    private String choice2;

    @Column(name = "CHOICE_3")
    private String choice3;

    @Column(name = "CHOICE_4")
    private String choice4;

    public QaMultipleChoiceQuestionImpl() {
        setQuestionType(QaQuestionType.MULTIPLE_CHOICE);
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public String getChoice4() {
        return choice4;
    }

    public void setChoice4(String choice4) {
        this.choice4 = choice4;
    }
}
