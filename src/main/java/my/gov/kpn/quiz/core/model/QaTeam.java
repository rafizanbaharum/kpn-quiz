package my.gov.kpn.quiz.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/7/13
 */
public interface QaTeam {

    QaUser getLeader();

    List<CmTeamMember> getMembers();

}
