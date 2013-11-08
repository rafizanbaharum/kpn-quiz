package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.QaActorType;
import my.gov.kpn.quiz.core.model.QaInstitution;
import my.gov.kpn.quiz.core.model.QaStudent;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "QA_STDN")
@Entity(name = "QaStudent")
public class QaStudentImpl extends QaActorImpl implements QaStudent {

    @OneToOne(targetEntity = QaInstitutionImpl.class)
    @JoinColumn(name = "INSTITUTION_ID")
    private QaInstitution institution;

    public QaStudentImpl() {
        setActorType(QaActorType.STUDENT);
    }

    public QaInstitution getInstitution() {
        return institution;
    }

    public void setInstitution(QaInstitution institution) {
        this.institution = institution;
    }
}
