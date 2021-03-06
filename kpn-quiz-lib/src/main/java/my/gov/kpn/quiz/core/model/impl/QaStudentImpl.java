package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.*;

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

    @Column(name = "SCHOOL_NAME")
    private String schoolName;

    @Column(name = "SCHOOL_TYPE")
    private QaSchoolType schoolType;

    @Column(name = "GENDER_TYPE")
    private QaGenderType genderType;

    @Column(name = "RACE_TYPE")
    private QaRaceType raceType;

    @OneToOne(targetEntity = QaStateImpl.class)
    @JoinColumn(name = "STATE_ID")
    private QaState state;

    @Column(name = "DISTRICT_NAME")
    private String districtName;

    public QaStudentImpl() {
        setActorType(QaActorType.STUDENT);
    }


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

    public QaGenderType getGenderType() {
        return genderType;
    }

    public void setGenderType(QaGenderType genderType) {
        this.genderType = genderType;
    }

    public QaRaceType getRaceType() {
        return raceType;
    }

    public void setRaceType(QaRaceType raceType) {
        this.raceType = raceType;
    }

    public QaSchoolType getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(QaSchoolType schoolType) {
        this.schoolType = schoolType;
    }

    public QaState getState() {
        return state;
    }

    public void setState(QaState state) {
        this.state = state;
    }
}
