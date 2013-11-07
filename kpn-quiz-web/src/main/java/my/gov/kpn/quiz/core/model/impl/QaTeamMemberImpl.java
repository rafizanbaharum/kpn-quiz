package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.*;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/12/13
 */
@Table(name = "QA_TEAM_MMBR")
@Entity(name = "QaTeamMember")
public class QaTeamMemberImpl implements QaTeamMember {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_QA_TEAM_MMBR")
    @SequenceGenerator(name = "SEQ_QA_TEAM_MMBR", sequenceName = "SEQ_QA_TEAM_MMBR", allocationSize = 1)
    private Long id;

    @OneToOne(targetEntity = QaTeamImpl.class)
    @JoinColumn(name = "TEAM_ID")
    private QaTeam team;

    @OneToOne(targetEntity = QaUserImpl.class)
    @JoinColumn(name = "MEMBER_ID")
    private QaUser member;

    @Embedded
    private QaMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QaTeam getTeam() {
        return team;
    }

    public void setTeam(QaTeam group) {
        this.team = group;
    }

    public QaUser getMember() {
        return member;
    }

    public void setMember(QaUser member) {
        this.member = member;
    }

    public QaMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(QaMetadata metadata) {
        this.metadata = metadata;
    }
}
