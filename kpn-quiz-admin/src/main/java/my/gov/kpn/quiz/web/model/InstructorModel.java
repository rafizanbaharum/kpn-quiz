package my.gov.kpn.quiz.web.model;

public class InstructorModel extends ActorModel {

    private String schoolName;
    private String stateName;

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
}
