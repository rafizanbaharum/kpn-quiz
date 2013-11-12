package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "QA_QUIZ")
@Entity(name = "QaQuiz")
public class QaQuizImpl implements QaQuiz, Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_QA_QUIZ")
    @SequenceGenerator(name = "SEQ_QA_QUIZ", sequenceName = "SEQ_QA_QUIZ", allocationSize = 1)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "LOCKED")
    private boolean locked;

    @Column(name = "CURRENT")
    private boolean current;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @OneToOne(targetEntity = QaRoundImpl.class)
    @JoinColumn(name = "ROUND_ID")
    private QaRound round;

    @OneToMany(targetEntity = QaQuestionImpl.class, mappedBy = "quiz")
    private List<QaQuestion> questions;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public QaRound getRound() {
        return round;
    }

    public void setRound(QaRound round) {
        this.round = round;
    }

    public List<QaQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QaQuestion> questions) {
        this.questions = questions;
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
