package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.QaGradebook;
import my.gov.kpn.quiz.core.model.QaMetadata;
import my.gov.kpn.quiz.core.model.QaParticipant;
import my.gov.kpn.quiz.core.model.QaQuiz;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 11/8/13
 */
@Table(name = "QA_GRBK")
@Entity(name = "QaGradebook")
public class QaGradebookImpl implements QaGradebook {

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

    public QaMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(QaMetadata metadata) {
        this.metadata = metadata;
    }
}
