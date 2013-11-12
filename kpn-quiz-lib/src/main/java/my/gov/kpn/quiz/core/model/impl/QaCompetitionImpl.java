package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.QaCompetition;
import my.gov.kpn.quiz.core.model.QaMetadata;
import my.gov.kpn.quiz.core.model.QaRound;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "QA_CMPN")
@Entity(name = "QaCompetition")
public class QaCompetitionImpl implements QaCompetition, Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_QA_CMPN")
    @SequenceGenerator(name = "SEQ_QA_CMPN", sequenceName = "SEQ_QA_CMPN", allocationSize = 1)
    private Long id;

    @Column(name = "YEAR")
    private Integer year;

    @Column(name = "LOCKED")
    private boolean locked;

    @OneToMany(targetEntity = QaRoundImpl.class, mappedBy = "competition")
    private List<QaRound> rounds;

    @Embedded
    private QaMetadata metadata = new QaMetadata();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public List<QaRound> getRounds() {
        return rounds;
    }

    public void setRounds(List<QaRound> rounds) {
        this.rounds = rounds;
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
                ", locked=" + locked +
                '}';
    }
}
