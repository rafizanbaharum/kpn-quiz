package my.gov.kpn.quiz.biz.manager;

import my.gov.kpn.quiz.core.dao.QaQuizDao;
import my.gov.kpn.quiz.core.model.QaRound;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author rafizan.baharum
 * @since 11/10/13
 */
public class QuizManagerImpl implements QuizManager {

    @Autowired
    private QaQuizDao quizDao;

    @Override
    public void processRound(QaRound round) {
        // TODO:

    }
}
