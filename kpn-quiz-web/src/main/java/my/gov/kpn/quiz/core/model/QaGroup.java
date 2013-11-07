package my.gov.kpn.quiz.core.model;

import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface QaGroup extends QaPrincipal {

    Set<QaGroupMember> getMembers();

    void setMembers(Set<QaGroupMember> members);

}
