package my.gov.kpn.quiz.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface QaUser extends QaPrincipal {

    String getUsername();

    void setUsername(String username);

    String getRealname();

    void setRealname(String realname);

    String getPassword();

    void setPassword(String password);

    String getEmail();

    void setEmail(String email);

    QaActor getActor();

    void setActor(QaActor actor);

    List<QaParticipant> getParticipants();

    void setParticipants(List<QaParticipant> participants);

}
