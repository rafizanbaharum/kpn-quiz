package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.QaActor;
import my.gov.kpn.quiz.core.model.QaParticipant;
import my.gov.kpn.quiz.core.model.QaUser;

import javax.persistence.*;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "QA_USER")
@Entity(name = "QaUser")
public class QaUserImpl extends QaPrincipalImpl implements QaUser {

    @Column(name = "REALNAME")
    private String realname;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @OneToOne(targetEntity = QaActorImpl.class)
    @JoinColumn(name = "ACTOR_ID")
    private QaActor actor;

    @OneToMany(targetEntity = QaParticipantImpl.class, mappedBy = "user")
    private List<QaParticipant> participants;

    public String getUsername() {
        return getName();
    }

    public void setUsername(String username) {
        setName(username);
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public QaActor getActor() {
        return actor;
    }

    public void setActor(QaActor actor) {
        this.actor = actor;
    }

    public List<QaParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<QaParticipant> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "CmUserImpl{" +
                "name='" + getName() + '\'' +
                "realname='" + realname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
