package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.*;

import javax.persistence.*;
import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "QA_TEAM")
@Entity(name = "QaTeam")
public class QaTeamImpl implements QaTeam {

    @OneToOne(targetEntity = QaActorImpl.class)
    @JoinColumn(name = "LEADER_ID")
    private QaUser leader;

    @OneToMany(targetEntity = QaTeamMemberImpl.class, mappedBy = "team")
    Set<QaTeamMember> members;

    public QaUser getLeader() {
        return leader;
    }

    public void setLeader(QaUser leader) {
        this.leader = leader;
    }

    public Set<QaTeamMember> getMembers() {
        return members;
    }

    public void setMembers(Set<QaTeamMember> members) {
        this.members = members;
    }
}
