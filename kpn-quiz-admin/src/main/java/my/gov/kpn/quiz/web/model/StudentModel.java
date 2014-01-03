package my.gov.kpn.quiz.web.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentModel extends ActorModel {

    private String password;
    private String passwordAgain;
    private Date dob;
    private String dobFormatted;
    private String dob_dd;
    private String dob_mm;
    private String dob_yyyy;
    private String nricNo;
    private String confirmNricNo;
    private String schoolName;
    private String stateName;
    private String raceType;
    private String raceTypeName;
    private String genderType;
    private String genderTypeName;
    private Long instructorId;

    private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public String getDob_dd() {
        return dob_dd;
    }

    public void setDob_dd(String dob_dd) {
        this.dob_dd = dob_dd;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }

    public String getNricNo() {
        return nricNo;
    }

    public void setNricNo(String nricNo) {
        this.nricNo = nricNo;
    }

    public String getConfirmNricNo() {
        return confirmNricNo;
    }

    public void setConfirmNricNo(String confirmNricNo) {
        this.confirmNricNo = confirmNricNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordAgain() {
        return passwordAgain;
    }

    public void setPasswordAgain(String passwordAgain) {
        this.passwordAgain = passwordAgain;
    }

    public String getGenderType() {
        return genderType;
    }

    public void setGenderType(String genderType) {
        this.genderType = genderType;
    }

    public String getRaceType() {
        return raceType;
    }

    public void setRaceType(String raceType) {
        this.raceType = raceType;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
        if (null != dob) dobFormatted = format.format(dob);
    }

    public String getDob_mm() {
        return dob_mm;
    }

    public void setDob_mm(String dob_mm) {
        this.dob_mm = dob_mm;
    }

    public String getDob_yyyy() {
        return dob_yyyy;
    }

    public void setDob_yyyy(String dob_yyyy) {
        this.dob_yyyy = dob_yyyy;
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

    public String getDobFormatted() {
        return dobFormatted;
    }

    public void setDobFormatted(String dobFormatted) {
        this.dobFormatted = dobFormatted;
    }

    public String getGenderTypeName() {
        return genderTypeName;
    }

    public void setGenderTypeName(String genderTypeName) {
        this.genderTypeName = genderTypeName;
    }

    public String getRaceTypeName() {
        return raceTypeName;
    }

    public void setRaceTypeName(String raceTypeName) {
        this.raceTypeName = raceTypeName;
    }
}
