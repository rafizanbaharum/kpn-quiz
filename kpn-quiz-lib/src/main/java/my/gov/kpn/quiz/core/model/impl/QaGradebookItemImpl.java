package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 11/8/13
 */
@Table(name = "QA_GRBI")
@Entity(name = "QaGradebookItem")
public class QaGradebookItemImpl implements QaGradebookItem, Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_QA_GRBI")
    @SequenceGenerator(name = "SEQ_QA_GRBI", sequenceName = "SEQ_QA_GRBI", allocationSize = 1)
    private Long id;

    @OneToOne(targetEntity = QaQuestionImpl.class)
    @JoinColumn(name = "QUESTION_ID")
    private QaQuestion question;

    @OneToOne(targetEntity = QaAnswerImpl.class)
    @JoinColumn(name = "ANSWER_ID")
    private QaAnswer answer;

    @OneToOne(targetEntity = QaGradebookImpl.class)
    @JoinColumn(name = "GRADEBOOK_ID")
    private QaGradebook gradebook;

    @Embedded
    private QaMetadata metadata = new QaMetadata();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QaQuestion getQuestion() {
        return question;
    }

    public void setQuestion(QaQuestion question) {
        this.question = question;
    }

    public QaAnswer getAnswer() {
        return answer;
    }

    public void setAnswer(QaAnswer answer) {
        this.answer = answer;
    }

    public QaGradebook getGradebook() {
        return gradebook;
    }

    public void setGradebook(QaGradebook gradebook) {
        this.gradebook = gradebook;
    }


    public QaMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(QaMetadata metadata) {
        this.metadata = metadata;
    }
}
