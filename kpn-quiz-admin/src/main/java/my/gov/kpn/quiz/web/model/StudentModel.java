package my.gov.kpn.quiz.web.model;

public class StudentModel extends MetaModel {

    private String name;
    private String username;
    private String password;
    private String passwordAgain;
    private String dob_dd;
    private String dob_mm;
    private String dob_yyyy;
    private String nric;
    private Long instructorId;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
