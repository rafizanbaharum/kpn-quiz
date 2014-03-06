package my.gov.kpn.quiz.core.dao.impl;

import my.gov.kpn.quiz.core.dao.ManualReaderDao;
import my.gov.kpn.quiz.core.model.QaManualReaderLog;
import my.gov.kpn.quiz.core.model.impl.QaManualReaderLogImpl;
import org.springframework.stereotype.Repository;

@Repository("manualReaderDao")
public class ManualReaderDaoImpl extends DaoSupport<Long, QaManualReaderLog, QaManualReaderLogImpl> implements ManualReaderDao {
}
