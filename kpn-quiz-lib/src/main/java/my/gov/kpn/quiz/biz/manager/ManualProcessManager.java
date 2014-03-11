package my.gov.kpn.quiz.biz.manager;

import my.gov.kpn.quiz.core.model.QaTempAnswer;

public interface ManualProcessManager {

    void writeSuccessFileReadLog(String filename);
    void writeErrorFileReadLog(String filename,String error);

    void writeStudentAnswer(QaTempAnswer tempAnswer);
}
