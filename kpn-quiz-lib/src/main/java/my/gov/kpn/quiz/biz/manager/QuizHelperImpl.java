package my.gov.kpn.quiz.biz.manager;

import my.gov.kpn.quiz.core.dao.QaStateDao;
import my.gov.kpn.quiz.core.model.QaState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("quizHelper")
@Transactional
public class QuizHelperImpl implements QuizHelper {

    @Autowired
    private QaStateDao stateDao;

    @Override
    public List<QaState> getStateList() {
        return stateDao.find();
    }
}
