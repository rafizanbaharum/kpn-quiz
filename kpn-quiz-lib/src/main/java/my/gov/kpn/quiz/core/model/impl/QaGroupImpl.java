package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.QaGroup;
import my.gov.kpn.quiz.core.model.QaGroupMember;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "QA_GROP")
@Entity(name = "QaGroup")
public class QaGroupImpl extends QaPrincipalImpl implements QaGroup {

    @OneToMany(targetEntity = QaGroupMemberImpl.class, mappedBy = "group")
    Set<QaGroupMember> members;

    public Set<QaGroupMember> getMembers() {
        return members;
    }

    public void setMembers(Set<QaGroupMember> members) {
        this.members = members;
    }
}
