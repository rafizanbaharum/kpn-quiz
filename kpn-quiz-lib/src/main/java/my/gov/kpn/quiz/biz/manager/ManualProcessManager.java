package my.gov.kpn.quiz.biz.manager;

public interface ManualProcessManager {

    void writeSuccessFileReadLog(String filename);
    void writeErrorFileReadLog(String filename,String error);
}
