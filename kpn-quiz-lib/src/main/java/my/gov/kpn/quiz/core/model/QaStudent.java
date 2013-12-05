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
    Date getDob();

    void setDob(Date dob);

    /**
     * @param schoolName
     */
    void setSchoolName(String schoolName);

    String getSchoolName();

    /**
     * @param schoolType
     */
    void setSchoolType(QaSchoolType schoolType);

    QaSchoolType getSchoolType();


    /**
     * @param districtName
     */
    void setDistrictName(String districtName);

    String getDistrictName();

    /**
     * @param instructor
     */
    void setInstructor(QaInstructor instructor);

    QaInstructor getInstructor();

    /**
     * @param state
     */
    void setState(QaState state);

    QaState getState();

}
