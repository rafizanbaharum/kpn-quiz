package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "QA_QSTN")
@Entity(name = "QaQuestion")
@Inheritance(strategy = InheritanceType.JOINED)
@org.hibernate.annotations.Cache(region = "QaQuestion", usage = CacheConcurrencyStrategy.READ_WRITE)
public abstract class QaQuestionImpl implements QaQuestion, Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_QA_QSTN")
    @SequenceGenerator(name = "SEQ_QA_QSTN", sequenceName = "SEQ_QA_QSTN", allocationSize = 1)
    private Long id;

    @Column(name = "STATEMENT")
    private String statement;

    @Column(name = "ANSWER_INDEX")
    private Integer answerIndex;

    @Column(name = "DIFFICULTY")
    private QaDifficulty difficulty;

    @Column(name = "QUESTION_TYPE")
    private QaQuestionType questionType;

    @OneToOne(targetEntity = QaQuizImpl.class)
    @JoinColumn(name = "QUIZ_ID")
    private QaQuiz quiz;

    @Embedded
    private QaMetadata metadata = new QaMetadata();

    private Boolean answered;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public QaDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(QaDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getAnswerIndex() {
        return answerIndex;
    }

    public void setAnswerIndex(Integer answerIndex) {
        this.answerIndex = answerIndex;
    }

    public QaQuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QaQuestionType questionType) {
        this.questionType = questionType;
    }

    public QaQuiz getQuiz() {
        return quiz;
    }

    public void setQuiz(QaQuiz quiz) {
        this.quiz = quiz;
    }

    public QaMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(QaMetadata metadata) {
        this.metadata = metadata;
    }

    public Boolean isAnswered() {
        return answered;
    }

    public void setAnswered(Boolean answered) {
        this.answered = answered;
    }
}

