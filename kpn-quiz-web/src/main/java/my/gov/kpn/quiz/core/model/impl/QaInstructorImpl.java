package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.QaActorType;
import my.gov.kpn.quiz.core.model.QaInstitution;
import my.gov.kpn.quiz.core.model.QaInstructor;
import my.gov.kpn.quiz.core.model.QaStudent;

import javax.persistence.*;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "QA_INTR")
@Entity(name = "QaInstructor")
public class QaInstructorImpl extends QaActorImpl implements QaInstructor {

//    @OneToOne(targetEntity = QaInstitutionImpl.class)
//    @JoinColumn(name = "INSTITUTION_ID")
//    private QaInstitution institution;

    @Column(name = "SCHOOL_NAME")
    private String schoolName;

    @Column(name = "STATE_NAME")
    private String stateName;

    @Column(name = "DISTRICT_NAME")
    private String districtName;

    @OneToMany
    private List<QaStudent> students;

    public QaInstructorImpl() {
        setActorType(QaActorType.INSTRUCTOR);
    }

//    public QaInstitution getInstitution() {
//        return institution;
//    }
//
//    public void setInstitution(QaInstitution institution) {
//        this.institution = institution;
//    }


    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public List<QaStudent> getStudents() {
        return students;
    }

    public void setStudents(List<QaStudent> students) {
        this.students = students;
    }
}
