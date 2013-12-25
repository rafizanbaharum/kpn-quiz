package my.gov.kpn.quiz.core.report;

public class InstructorModel {

    private String name;
    private String phone;
    private String school_name;
    private String school_type;
    private String school_phone;
    private String email;
    private Long student_count;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getSchool_phone() {
        return school_phone;
    }

    public void setSchool_phone(String school_phone) {
        this.school_phone = school_phone;
    }

    public String getSchool_type() {
        return school_type;
    }

    public void setSchool_type(String school_type) {
        this.school_type = school_type;
    }

    public Long getStudent_count() {
        return student_count;
    }

    public void setStudent_count(Long student_count) {
        this.student_count = student_count;
    }
}
