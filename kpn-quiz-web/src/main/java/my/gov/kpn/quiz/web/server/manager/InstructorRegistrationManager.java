package my.gov.kpn.quiz.web.server.manager;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public interface InstructorRegistrationManager {

    void register(String username, String password, String name, String nricNo,
                  String email, String fax, String phone,
                  String address1, String address2, String address3,
                  Long institutionId);

    boolean isExists(String username);

}
