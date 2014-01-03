package my.gov.kpn.quiz.web.model;

/**
 * @author rafizan.baharum
 * @since 11/15/13
 */
public class ParticipantModel extends MetaModel {

    private String name;
    private String nricNo;
    private Integer result;
    private String school;
    private String district;
    private String state;
    private String address1;
    private String address2;
    private String address3;
    private String answerResponse;
    private boolean selected;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNricNo() {
        return nricNo;
    }

    public void setNricNo(String nricNo) {
        this.nricNo = nricNo;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAnswerResponse() {
        return answerResponse;
    }

    public void setAnswerResponse(String answerResponse) {
        this.answerResponse = answerResponse;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
