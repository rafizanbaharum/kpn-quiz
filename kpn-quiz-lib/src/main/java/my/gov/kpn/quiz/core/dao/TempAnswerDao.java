package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.model.QaManualReaderLog;
import my.gov.kpn.quiz.core.model.QaTempAnswer;
import my.gov.kpn.quiz.core.model.impl.QaManualReaderLogImpl;
import my.gov.kpn.quiz.core.model.impl.QaTempAnswerImpl;

public interface TempAnswerDao extends DaoSupport<Long, QaTempAnswer, QaTempAnswerImpl> {
}
