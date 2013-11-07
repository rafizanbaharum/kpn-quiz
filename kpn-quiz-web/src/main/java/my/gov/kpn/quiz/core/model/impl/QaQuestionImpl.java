package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.*;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "QA_QSTN")
@Entity(name = "QaQuestion")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class QaQuestionImpl implements QaQuestion {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_QA_ACTR")
    @SequenceGenerator(name = "SEQ_QA_ACTR", sequenceName = "SEQ_QA_ACTR", allocationSize = 1)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "WEIGHT")
    private Double weight;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
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

