package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.QaGroup;
import my.gov.kpn.quiz.core.model.QaGroupMember;
import my.gov.kpn.quiz.core.model.QaMetadata;
import my.gov.kpn.quiz.core.model.QaPrincipal;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/12/13
 */
@Table(name = "CM_GROP_MMBR")
@Entity(name = "CmGroupMember")
public class QaTeamMemberImpl implements QaGroupMember {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_QA_GROP_MMBR")
    @SequenceGenerator(name = "SEQ_QA_GROP_MMBR", sequenceName = "SEQ_QA_GROP_MMBR", allocationSize = 1)
    private Long id;

    @OneToOne(targetEntity = QaGroupImpl.class)
    @JoinColumn(name = "GROUP_ID")
    private QaGroup group;

    @OneToOne(targetEntity = QaPrincipalImpl.class)
    @JoinColumn(name = "MEMBER_ID")
    private QaPrincipal member;

    @Embedded
    private QaMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QaGroup getGroup() {
        return group;
    }

    public void setGroup(QaGroup group) {
        this.group = group;
    }

    public QaPrincipal getMember() {
        return member;
    }

    public void setMember(QaPrincipal member) {
        this.member = member;
    }

    public QaMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(QaMetadata metadata) {
        this.metadata = metadata;
    }
}
