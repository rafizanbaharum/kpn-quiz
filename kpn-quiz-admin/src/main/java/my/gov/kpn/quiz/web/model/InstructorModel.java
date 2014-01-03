package my.gov.kpn.quiz.web.model;

public class InstructorModel extends ActorModel {

    private String schoolType;
    private String schoolName;
    private String schoolPhone;
    private String schoolFax;
    private String stateName;


    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolPhone() {
        return schoolPhone;
    }

    public void setSchoolPhone(String schoolPhone) {
        this.schoolPhone = schoolPhone;
    }

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getSchoolFax() {
        return schoolFax;
    }

    public void setSchoolFax(String schoolFax) {
        this.schoolFax = schoolFax;
    }
}
