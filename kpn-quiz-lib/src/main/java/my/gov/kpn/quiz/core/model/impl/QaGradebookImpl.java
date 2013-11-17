package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/8/13
 */
@Table(name = "QA_GRBK")
@Entity(name = "QaGradebook")
public class QaGradebookImpl implements QaGradebook, Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_QA_GRBK")
    @SequenceGenerator(name = "SEQ_QA_GRBK", sequenceName = "SEQ_QA_GRBK", allocationSize = 1)
    private Long id;

    @OneToOne(targetEntity = QaQuizImpl.class)
    @JoinColumn(name = "QUIZ_ID")
    private QaQuiz quiz;

    @OneToOne(targetEntity = QaParticipantImpl.class)
    @JoinColumn(name = "PARTICIPANT_ID")
    private QaParticipant participant;

    @OneToMany(targetEntity = QaGradebookItemImpl.class, mappedBy = "gradebook")
    private List<QaGradebookItem> items;

    @Embedded
    private QaMetadata metadata = new QaMetadata();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QaQuiz getQuiz() {
        return quiz;
    }

    public void setQuiz(QaQuiz quiz) {
        this.quiz = quiz;
    }

    public QaParticipant getParticipant() {
        return participant;
    }

    public void setParticipant(QaParticipant participant) {
        this.participant = participant;
    }

    public List<QaGradebookItem> getItems() {
        return items;
    }

    public void setItems(List<QaGradebookItem> items) {
        this.items = items;
    }

    public QaMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(QaMetadata metadata) {
        this.metadata = metadata;
    }
}
