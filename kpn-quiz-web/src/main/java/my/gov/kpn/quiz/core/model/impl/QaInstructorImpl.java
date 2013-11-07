package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.QaActorType;
import my.gov.kpn.quiz.core.model.QaInstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "QA_INTR")
@Entity(name = "QaInstructor")
public class QaInstructorImpl extends QaActorImpl implements QaInstructor {

    public QaInstructorImpl() {
        setActorType(QaActorType.INSTRUCTOR);
    }

    public String getStaffNo() {
        return getNricNo();
    }

    public void setStaffNo(String staffNo) {
        setNricNo(staffNo);
    }

}
