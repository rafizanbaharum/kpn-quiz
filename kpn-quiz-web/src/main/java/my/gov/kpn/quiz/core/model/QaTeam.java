package my.gov.kpn.quiz.core.model;

import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 11/7/13
 */
public interface QaTeam {

    /**
     * @return
     */
    QaUser getLeader();

    void setLeader(QaUser leader);

    /**
     * @return
     */
    Set<QaTeamMember> getMembers();

    void setMembers(Set<QaTeamMember> members);

}
