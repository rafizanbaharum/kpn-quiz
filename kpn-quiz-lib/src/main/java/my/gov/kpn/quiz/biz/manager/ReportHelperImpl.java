package my.gov.kpn.quiz.biz.manager;

import my.gov.kpn.quiz.core.dao.QaStateDao;
import my.gov.kpn.quiz.core.model.QaState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("reportHelper")
@Transactional
public class ReportHelperImpl implements ReportHelper{

    @Autowired
    private QaStateDao stateDao;

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


}
