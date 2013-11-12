package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface QaGroupMember extends QaMetaObject {

    QaGroup getGroup();

    void setGroup(QaGroup group);

    QaPrincipal getMember();

    void setMember(QaPrincipal member);
}
