package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.QaCompetition;
import my.gov.kpn.quiz.core.model.QaMetadata;
import my.gov.kpn.quiz.core.model.QaParticipant;
import my.gov.kpn.quiz.core.model.QaRound;

import javax.persistence.*;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "QA_ROND")
@Entity(name = "QaRound")
public class QaCompetitionImpl implements QaRound {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_QA_ROND")
    @SequenceGenerator(name = "SEQ_QA_ROND", sequenceName = "SEQ_QA_ROND", allocationSize = 1)
    private Long id;

    @Column(name = "PROCESSED")
    private boolean processed;

    @Column(name = "LOCKED")
    private boolean locked;

    @OneToOne(targetEntity = QaCompetitionImpl.class)
    @JoinColumn(name = "COMPETITION_ID")
    private QaCompetition competition;

    @OneToMany(targetEntity = QaParticipantImpl.class, mappedBy = "round")
    private List<QaParticipant> participants;

    @Embedded
    private QaMetadata metadata = new QaMetadata();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public QaCompetition getCompetition() {
        return competition;
    }

    public void setCompetition(QaCompetition competition) {
        this.competition = competition;
    }

    public QaMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(QaMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "CmPrincipalImpl{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", locked=" + locked +
                '}';
    }
}
