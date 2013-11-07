package my.gov.kpn.quiz.core.model;

import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface QaModule extends QaMetaObject {

    String getCode();

    void setCode(String code);

    String getAlias();

    void setAlias(String alias);

    String getDescription();

    void setDescription(String description);

    Integer getOrder();

    void setOrder(Integer order);

    Set<QaSubModule> getSubModules();

    void setSubModules(Set<QaSubModule> subModules);

}
