package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.QaActorType;
import my.gov.kpn.quiz.core.model.QaInstitution;
import my.gov.kpn.quiz.core.model.QaInstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "QA_INTR")
@Entity(name = "QaInstructor")
public class QaInstructorImpl extends QaActorImpl implements QaInstructor {

    @OneToOne(targetEntity = QaInstitutionImpl.class)
    @JoinColumn(name = "INSTITUTION_ID")
    private QaInstitution institution;

    public QaInstructorImpl() {
        setActorType(QaActorType.INSTRUCTOR);
    }

    public QaInstitution getInstitution() {
        return institution;
    }

    public void setInstitution(QaInstitution institution) {
        this.institution = institution;
    }
}
