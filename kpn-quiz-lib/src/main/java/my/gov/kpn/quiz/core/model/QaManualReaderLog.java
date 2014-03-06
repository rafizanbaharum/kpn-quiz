package my.gov.kpn.quiz.core.model;

public interface QaManualReaderLog {

    Long getId();

    String getFilename();

    void setFilename(String filename);

    Boolean getStatus();

    void setStatus(Boolean status);

    String getError();

    void setError(String error);
}
