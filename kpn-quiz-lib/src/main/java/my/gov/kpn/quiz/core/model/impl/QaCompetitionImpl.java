package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.QaCompetition;
import my.gov.kpn.quiz.core.model.QaMetadata;
import my.gov.kpn.quiz.core.model.QaQuiz;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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

    @Column(name = "YEAR", unique = true)
    private Integer year;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "START_CONSTRAINT")
    private Integer startConstraint;

    @Column(name = "END_CONSTRAINT")
    private Integer endConstraint;

    @Column(name = "LOCKED")
    private boolean locked;

    @OneToMany(targetEntity = QaQuizImpl.class, mappedBy = "competition")
    private List<QaQuiz> quizzes;

    @Embedded
    private QaMetadata metadata = new QaMetadata();

    public QaCompetitionImpl() {
        locked = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getStartConstraint() {
        return startConstraint;
    }

    public void setStartConstraint(Integer startConstraint) {
        this.startConstraint = startConstraint;
    }

    public Integer getEndConstraint() {
        return endConstraint;
    }

    public void setEndConstraint(Integer endConstraint) {
        this.endConstraint = endConstraint;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public List<QaQuiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<QaQuiz> quizzes) {
        this.quizzes = quizzes;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QaCompetitionImpl that = (QaCompetitionImpl) o;

        if (!id.equals(that.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
