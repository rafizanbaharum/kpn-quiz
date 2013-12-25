package my.gov.kpn.quiz.biz.manager;

import my.gov.kpn.quiz.core.dao.QaInstructorDao;
import my.gov.kpn.quiz.core.dao.QaStateDao;
import my.gov.kpn.quiz.core.model.QaActorType;
import my.gov.kpn.quiz.core.model.QaSchoolType;
import my.gov.kpn.quiz.core.model.QaState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("reportHelper")
@Transactional
public class ReportHelperImpl implements ReportHelper{

    @Autowired
    private QaStateDao stateDao;

    @Autowired
    private QaInstructorDao instructorDao;

    @Override
    public String findStateNameById(String id) {
        try {
            QaState state = stateDao.findById(Long.valueOf(id));
            if (null != state) return state.getName();
            return "ALL";
        } catch (Exception e) {
            return "ALL";
        }
    }

    @Override
    public List<String> findSchoolNameByStateAndType(String stateId, QaSchoolType type) {
        return instructorDao.findSchoolRegisteredByStateAndType(stateDao.findById(Long.valueOf(stateId)), type);
    }

    @Override
    public List<QaSchoolType> findSchoolTypeByState(String stateId) {
        List<QaSchoolType> stringSet = new ArrayList<QaSchoolType>();

       QaState state;
        try {
            state = stateDao.findById(Long.valueOf(stateId));
        } catch (Exception e) {
            return stringSet;
        }

        List<QaSchoolType> schoolTypes = instructorDao.findRegisteredByState(state);
        if (null == schoolTypes) return stringSet;



        return stringSet;
    }
}
