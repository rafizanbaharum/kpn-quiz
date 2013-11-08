package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.QaSubjectiveQuestion;

import javax.persistence.Column;
import javax.persistence.Lob;
import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 11/7/13
 */
public class QaSubjectiveQuestionImpl extends QaQuestionImpl implements QaSubjectiveQuestion, Serializable {


    @Lob
    @Column(name = "ANSWER_GUIDE")
    private String answerGuide;

    public String getAnswerGuide() {
        return answerGuide;
    }

    public void setAnswerGuide(String answerGuide) {
        this.answerGuide = answerGuide;
    }
}
