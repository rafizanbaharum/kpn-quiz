package my.gov.kpn.quiz;

import java.util.HashMap;
import java.util.Map;

public class StudentAnswer {

    private String name;
    private String nric;
    private String school;
    private String state;
    private Map<Integer,String> answers;
    private int currentIndex;

    public StudentAnswer() {
        answers = new HashMap<Integer, String>();
        currentIndex = 0;
    }

    public void setNextAnswer(String answer){
        currentIndex++;
        answers.put(currentIndex,answer);
    }

    public Map<Integer, String> getAnswers() {
        return answers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNric() {
        return nric;
    }

    public void setNric(String nric) {
        this.nric = nric;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "StudentAnswer{" +
                "answers=" + answers +
                ", name='" + name + '\'' +
                ", nric='" + nric + '\'' +
                ", school='" + school + '\'' +
                ", phone='" + state + '\'' +
                ", currentIndex=" + currentIndex +
                '}';
    }
}
