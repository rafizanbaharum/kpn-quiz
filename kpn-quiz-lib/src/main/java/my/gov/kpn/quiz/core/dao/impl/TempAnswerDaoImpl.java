package my.gov.kpn.quiz.core.dao.impl;

import my.gov.kpn.quiz.core.dao.ManualReaderDao;
import my.gov.kpn.quiz.core.dao.TempAnswerDao;
import my.gov.kpn.quiz.core.model.QaManualReaderLog;
import my.gov.kpn.quiz.core.model.QaTempAnswer;
import my.gov.kpn.quiz.core.model.impl.QaManualReaderLogImpl;
import my.gov.kpn.quiz.core.model.impl.QaTempAnswerImpl;
import org.springframework.stereotype.Repository;

@Repository("tempAnswerDao")
public class TempAnswerDaoImpl extends DaoSupport<Long, QaTempAnswer, QaTempAnswerImpl> implements TempAnswerDao {
}
