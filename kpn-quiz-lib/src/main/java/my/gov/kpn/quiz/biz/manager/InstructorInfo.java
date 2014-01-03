package my.gov.kpn.quiz.biz.manager;

public class InstructorInfo {
    private final String username;
    private final String password;
    private final String name;
    private final String nricNo;
    private final String email;
    private final String fax;
    private final String phone;
    private final Long stateId;
    private final String schoolName;
    private final String schoolPhone;
    private final String schoolFax;
    private final Integer schoolType;

    public InstructorInfo(String username, String password, String name, String nricNo, String email, String phone, String fax, Long stateId, String schoolName, String schoolPhone, String schoolFax, Integer schoolType) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.nricNo = nricNo;
        this.email = email;
        this.fax = fax;
        this.phone = phone;
        this.stateId = stateId;
        this.schoolName = schoolName;
        this.schoolPhone = schoolPhone;
        this.schoolFax = schoolFax;
        this.schoolType = schoolType;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getNricNo() {
        return nricNo;
    }

    public String getEmail() {
        return email;
    }

    public String getFax() {
        return fax;
    }

    public String getPhone() {
        return phone;
    }

    public Long getStateId() {
        return stateId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getSchoolPhone() {
        return schoolPhone;
    }

    public String getSchoolFax() {
        return schoolFax;
    }

    public Integer getSchoolType() {
        return schoolType;
    }
}
