package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "QA_QSTN")
@Entity(name = "QaQuestion")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class QaQuestionImpl implements QaQuestion, Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_QA_QSTN")
    @SequenceGenerator(name = "SEQ_QA_QSTN", sequenceName = "SEQ_QA_QSTN", allocationSize = 1)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "WEIGHT")
    private Double weight;

    @Column(name = "ANSWER_INDEX")
    private Integer answerIndex;

    @Column(name = "ANSWER_KEY")
    private String answerKey;

    @Column(name = "DIFFICULTY")
    private QaDifficulty difficulty;

    @Column(name = "QUESTION_TYPE")
    private QaQuestionType questionType;

    @OneToOne(targetEntity = QaQuizImpl.class)
    @JoinColumn(name = "QUIZ_ID")
    private QaQuiz quiz;

    @Embedded
    private QaMetadata metadata = new QaMetadata();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatement() {
        return title;
    }

    public void setStatement(String title) {
        this.title = title;
    }

    public QaDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(QaDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getAnswerIndex() {
        return answerIndex;
    }

    public void setAnswerIndex(Integer answerIndex) {
        this.answerIndex = answerIndex;
    }

    public String getAnswerKey() {
        return answerKey;
    }

    public void setAnswerKey(String answerKey) {
        this.answerKey = answerKey;
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
}

