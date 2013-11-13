package my.gov.kpn.quiz.biz.manager;


/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public interface RegistrationManager {

    void registerInstructor(String username, String password, String name, String nricNo,
                            String email, String fax, String phone,
                            Long stateId, String schoolName);

    /**
     *
     * @param username
     * @param password
     * @param name
     * @param nricNo
     * @param instructorId
     */
    void registerStudent(String username, String password, String name, String nricNo,
                         Long instructorId);

    boolean isExists(String username);

}
