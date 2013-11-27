package my.gov.kpn.quiz.core.model;

import java.math.BigDecimal;

/**
 * @author rafizan.baharum
 * @since 11/27/13
 */
public interface QaConfiguration extends QaMetaObject {

    String getKey();

    void setKey(String value);

    String getValue();

    void setValue(String value);

    String getDescription();

    void setDescription(String description);

    Integer getValueAsInteger();

    Double getValueAsDouble();

    Long getValueAsLong();

    BigDecimal getValueAsBigDecimal();

}
