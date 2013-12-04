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

    @Column(name = "PROCESSED")
    private boolean processed;

    @Column(name = "CURRENT")
    private boolean current;

    @Column(name = "ROUND", unique = true)
    private Integer round;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @OneToOne(targetEntity = QaCompetitionImpl.class)
    @JoinColumn(name = "COMPETITION_ID")
    private QaCompetition competition;

    @OneToMany(targetEntity = QaQuestionImpl.class, mappedBy = "quiz")
    private List<QaQuestion> questions;

    @OneToMany(targetEntity = QaParticipantImpl.class, mappedBy = "quiz")
    private List<QaParticipant> participants;

    @OneToMany(targetEntity = QaGradebookImpl.class, mappedBy = "quiz")
    private List<QaGradebook> gradebooks;

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

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
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


    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public List<QaQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QaQuestion> questions) {
        this.questions = questions;
    }


    public QaCompetition getCompetition() {
        return competition;
    }

    public void setCompetition(QaCompetition competition) {
        this.competition = competition;
    }

    public List<QaParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<QaParticipant> participants) {
        this.participants = participants;
    }

    public List<QaGradebook> getGradebooks() {
        return gradebooks;
    }

    public void setGradebooks(List<QaGradebook> gradebooks) {
        this.gradebooks = gradebooks;
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
