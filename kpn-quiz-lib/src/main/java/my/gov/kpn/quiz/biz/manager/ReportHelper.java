package my.gov.kpn.quiz.biz.manager;

import my.gov.kpn.quiz.core.model.QaSchoolType;

import java.util.List;
import java.util.Set;

public interface ReportHelper {

    public String findStateNameById(String stateId);

    public List<QaSchoolType> findSchoolTypeByState(String stateId);

    public List<String> findSchoolNameByStateAndType(String stateId, QaSchoolType type);
}
