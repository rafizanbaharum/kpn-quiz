package my.gov.kpn.quiz.biz.manager;

import my.gov.kpn.quiz.core.dao.ManualReaderDao;
import my.gov.kpn.quiz.core.dao.TempAnswerDao;
import my.gov.kpn.quiz.core.model.QaTempAnswer;
import my.gov.kpn.quiz.core.model.impl.QaManualReaderLogImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Component("manualProcessManager")
@Transactional
public class ManualProcessManagerImpl implements ManualProcessManager {

    @Autowired
    private ManualReaderDao manualReaderDao;

    @Autowired
    private TempAnswerDao tempAnswerDao;

    @Override
    public void writeErrorFileReadLog(String filename, String error) {

        QaManualReaderLogImpl manualReaderLog = new QaManualReaderLogImpl();
        manualReaderLog.setFilename(filename);
        manualReaderLog.setError(error);
        manualReaderLog.setStatus(Boolean.FALSE);
        manualReaderLog.setTimestamp(new Date());
        manualReaderDao.save(manualReaderLog);

    }

    @Override
    public void writeSuccessFileReadLog(String filename) {
        QaManualReaderLogImpl manualReaderLog = new QaManualReaderLogImpl();
        manualReaderLog.setFilename(filename);
        manualReaderLog.setTimestamp(new Date());
        manualReaderLog.setStatus(Boolean.TRUE);
        manualReaderDao.save(manualReaderLog);
    }

    @Override
    public void writeStudentAnswer(QaTempAnswer tempAnswer) {
        tempAnswerDao.save(tempAnswer);
    }
}
