package my.gov.kpn.quiz.biz.manager;


import my.gov.kpn.quiz.core.model.QaInstructor;
import my.gov.kpn.quiz.core.model.QaStudent;

import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public interface RegistrationManager {

    void registerInstructor(InstructorInfo instructorInfo);

    void registerStudent(String username, String password, String name, String nricNo,
                         Date dob,
                         Integer genderType,
                         Integer raceType,
                         QaInstructor instructor);

    void updateStudent(QaStudent student,
                       String name, Date dob,
                       Integer genderType,
                       Integer raceType
    );

    void removeStudent(QaStudent student);

    boolean isExists(String username);
}
