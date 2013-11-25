package my.gov.kpn.quiz.biz.manager;


import my.gov.kpn.quiz.core.model.QaInstructor;
import my.gov.kpn.quiz.core.model.QaStudent;

import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public interface RegistrationManager {

    void registerInstructor(String username, String password, String name, String nricNo,
                            String email, String fax, String phone,
                            Long stateId, String schoolName);

    /**
     * @param username
     * @param password
     * @param name
     * @param nricNo
     * @param instructor
     */
    void registerStudent(String username, String password, String name, String nricNo,
                         Date dob, QaInstructor instructor);

    void updateStudent(QaStudent student, String username, String password, String name,
                       String nricNo, Date dob);

    void removeStudent(QaStudent student);

    boolean isExists(String username);
}
