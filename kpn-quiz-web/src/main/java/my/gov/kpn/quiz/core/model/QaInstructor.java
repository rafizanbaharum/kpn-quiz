package my.gov.kpn.quiz.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface QaInstructor extends QaActor {

    /**
     * @return
     */
//    QaInstitution getInstitution();
//
//    void setInstitution(QaInstitution institution);

    void setSchoolName(String schoolName);

    String getSchoolName();

    void setStateName(String stateName);
    String getStateName();

    void setDistrictName(String districtName);
    String getDistrictName();


    List<QaStudent> getStudents();
    void setStudents(List<QaStudent> students);
}
