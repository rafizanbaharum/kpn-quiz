package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.QaQuestionType;
import my.gov.kpn.quiz.core.model.QaSubjectiveQuestion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 11/7/13
 */
@Table(name = "QA_SVQN")
@Entity(name = "QaSubjectiveQuestion")
public class QaSubjectiveQuestionImpl extends QaQuestionImpl implements QaSubjectiveQuestion {

    @Column(name = "WORD_LIMIT")
    private Integer wordLimit;

    @Lob
    @Column(name = "ANSWER_GUIDE")
    private String answerGuide;

    public QaSubjectiveQuestionImpl() {
        setQuestionType(QaQuestionType.SUBJECTIVE);
    }

    public Integer getWordLimit() {
        return wordLimit;
    }

    public void setWordLimit(Integer wordLimit) {
        this.wordLimit = wordLimit;
    }

    public String getAnswerGuide() {
        return answerGuide;
    }

    public void setAnswerGuide(String answerGuide) {
        this.answerGuide = answerGuide;
    }
}
