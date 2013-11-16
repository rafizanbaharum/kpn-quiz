package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "QA_TEAM")
@Entity(name = "QaTeam")
@Deprecated
public class QaTeamImpl implements QaTeam, Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_QA_TEAM")
    @SequenceGenerator(name = "SEQ_QA_TEAM", sequenceName = "SEQ_QA_TEAM", allocationSize = 1)
    private Long id;


    @OneToOne(targetEntity = QaActorImpl.class)
    @JoinColumn(name = "LEADER_ID")
    private QaUser leader;

    @OneToMany(targetEntity = QaTeamMemberImpl.class, mappedBy = "team")
    Set<QaTeamMember> members;

    @Embedded
    private QaMetadata metadata = new QaMetadata();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public QaMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(QaMetadata metadata) {
        this.metadata = metadata;
    }
}
