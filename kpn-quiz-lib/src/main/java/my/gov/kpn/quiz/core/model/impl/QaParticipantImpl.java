package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.QaMetadata;
import my.gov.kpn.quiz.core.model.QaParticipant;
import my.gov.kpn.quiz.core.model.QaRound;
import my.gov.kpn.quiz.core.model.QaUser;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "QA_PRCT")
@Entity(name = "QaParticipant")
public class QaParticipantImpl implements QaParticipant, Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_QA_PRCT")
    @SequenceGenerator(name = "SEQ_QA_PRCT", sequenceName = "SEQ_QA_PRCT", allocationSize = 1)
    private Long id;

    @Column(name = "RESULT")
    private Integer result = 0;

    @OneToOne(targetEntity = QaRoundImpl.class)
    @JoinColumn(name = "ROUND_ID")
    private QaRound round;

    @OneToOne(targetEntity = QaUserImpl.class)
    @JoinColumn(name = "USER_ID")
    private QaUser user;

    @Embedded
    private QaMetadata metadata = new QaMetadata();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public QaRound getRound() {
        return round;
    }

    public void setRound(QaRound round) {
        this.round = round;
    }

    public QaUser getUser() {
        return user;
    }

    public void setUser(QaUser user) {
        this.user = user;
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
                '}';
    }
}
