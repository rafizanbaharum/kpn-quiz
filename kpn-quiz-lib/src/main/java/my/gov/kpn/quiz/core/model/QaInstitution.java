package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 11/7/13
 */
@Deprecated
public interface QaInstitution extends QaMetaObject {

    /**
     * @return
     */
    String getCode();

    void setCode(String code);

    /**
     * @return
     */
    String getName();

    void setName(String name);


}
