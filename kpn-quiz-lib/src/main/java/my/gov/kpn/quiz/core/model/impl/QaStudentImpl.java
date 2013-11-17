package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.QaActorType;
import my.gov.kpn.quiz.core.model.QaInstructor;
import my.gov.kpn.quiz.core.model.QaStudent;

import javax.persistence.*;
import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "QA_STDN")
@Entity(name = "QaStudent")
public class QaStudentImpl extends QaActorImpl implements QaStudent {


    @ManyToOne(targetEntity = QaInstructorImpl.class)
    @JoinColumn(name = "INSTRUCTOR_ID")
    private QaInstructor instructor;

    @Column(name = "DOB")
    private Date dob;

    public QaStudentImpl() {
        setActorType(QaActorType.STUDENT);
    }

//    public QaInstitution getInstitution() {
//        return institution;
//    }

//    public void setInstitution(QaInstitution institution) {
//        this.institution = institution;
//    }


    public QaInstructor getInstructor() {
        return instructor;
    }

    public void setInstructor(QaInstructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public Date getDob() {
        return dob;
    }

    @Override
    public void setDob(Date dob) {
        this.dob = dob;
    }
}
