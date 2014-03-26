package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.*;

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

    @Column(name = "ANSWER_RESPONSE")
    private String answerResponse;

    @OneToOne(targetEntity = QaQuizImpl.class)
    @JoinColumn(name = "QUIZ_ID")
    private QaQuiz quiz;

    @OneToOne(targetEntity = QaUserImpl.class)
    @JoinColumn(name = "USER_ID")
    private QaUser user;

    @Column(name = "STATUS")
    @Enumerated(value = EnumType.ORDINAL)
    private QaManualStatus status;

    @Transient
    private boolean selected;

    @Embedded
    private QaMetadata metadata = new QaMetadata();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QaManualStatus getStatus() {
        return status;
    }

    public void setStatus(QaManualStatus status) {
        this.status = status;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getAnswerResponse() {
        return answerResponse;
    }

    public void setAnswerResponse(String answerResponse) {
        this.answerResponse = answerResponse;
    }

    public QaQuiz getQuiz() {
        return quiz;
    }

    public void setQuiz(QaQuiz quiz) {
        this.quiz = quiz;
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

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "CmPrincipalImpl{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QaParticipantImpl that = (QaParticipantImpl) o;

        if (!id.equals(that.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
