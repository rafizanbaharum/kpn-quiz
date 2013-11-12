package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface QaMetaObject {

    Long getId();

    QaMetadata getMetadata();

    void setMetadata(QaMetadata metadata);
}
