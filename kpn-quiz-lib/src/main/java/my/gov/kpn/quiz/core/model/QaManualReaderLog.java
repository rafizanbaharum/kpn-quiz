package my.gov.kpn.quiz.core.model;

import javax.persistence.Column;
import java.util.Date;

public interface QaManualReaderLog {

    Long getId();

    String getFilename();

    void setFilename(String filename);

    Boolean getStatus();

    void setStatus(Boolean status);

    String getError();

    void setError(String error);

    Date getTimestamp();
    void setTimestamp(Date timestamp);

}
