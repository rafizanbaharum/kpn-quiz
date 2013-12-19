package my.gov.kpn.quiz.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface QaInstructor extends QaActor {

    /**
     * @param schoolName
     */
    void setSchoolName(String schoolName);

    String getSchoolName();

    /**
     * @param schoolPhone
     */
    void setSchoolPhone(String schoolPhone);

    String getSchoolPhone();

    /**
     * @param schoolType
     */
    void setSchoolType(QaSchoolType schoolType);

    QaSchoolType getSchoolType();


    /**
     * @param stateName
     */
    void setState(QaState stateName);

    QaState getState();

    /**
     * @param districtName
     */
    void setDistrictName(String districtName);

    String getDistrictName();

    /**
     * @return
     */
    List<QaStudent> getStudents();

    void setStudents(List<QaStudent> students);
}
