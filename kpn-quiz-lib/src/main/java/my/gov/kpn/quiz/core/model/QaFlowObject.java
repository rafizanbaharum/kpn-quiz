package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface QaFlowObject extends QaMetaObject {

    QaFlowdata getFlowdata();

    void setFlowdata(QaFlowdata flowdata);
}
