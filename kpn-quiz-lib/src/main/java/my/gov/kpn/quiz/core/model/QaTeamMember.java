package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 11/7/13
 */
public interface QaTeamMember extends QaMetaObject{

    /**
     *
     * @return
     */
    QaTeam getTeam();

    void setTeam(QaTeam team);

    /**
     *
     * @return
     */
    QaUser getMember();

    void setMember(QaUser member);
}
