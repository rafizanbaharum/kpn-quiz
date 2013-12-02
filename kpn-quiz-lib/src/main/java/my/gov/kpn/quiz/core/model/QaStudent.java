package my.gov.kpn.quiz.core.model;

import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface QaStudent extends QaActor {

    /**
     * @return
     */
//    QaInstitution getInstitution();

//    void setInstitution(QaInstitution institution);


    void setInstructor(QaInstructor instructor);

    QaInstructor getInstructor();

    Date getDob();

    void setDob(Date dob);

    void setSchoolName(String schoolName);

    String getSchoolName();

    /**
     * @param schoolType
     */
    void setSchoolType(QaSchoolType schoolType);

    QaSchoolType getSchoolType();


    /**
     *
     * @param state
     */
    void setState(QaState state);

    QaState getState();

    /**
     * @param districtName
     */
    void setDistrictName(String districtName);

    String getDistrictName();

}
