package my.gov.kpn.quiz.biz.manager;

import my.gov.kpn.quiz.core.model.QaInstitution;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public interface RegistrationManager {

    void registerInstructor(String username, String password, String name, String nricNo,
                            String email, String fax, String phone,
                            String address1, String address2, String address3,
                            QaInstitution institution);

    void registerStudent(String username, String password, String name, String nricNo,
                         String email, String fax, String phone,
                         String address1, String address2, String address3,
                         QaInstitution institution);

    boolean isExists(String username);

}
