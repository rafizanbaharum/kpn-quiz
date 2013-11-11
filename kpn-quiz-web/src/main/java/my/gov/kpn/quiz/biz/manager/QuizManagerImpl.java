package my.gov.kpn.quiz.biz.manager;

import my.gov.kpn.quiz.core.dao.QaQuizDao;
import my.gov.kpn.quiz.core.model.QaQuiz;
import my.gov.kpn.quiz.core.model.QaRound;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/10/13
 */
public class QuizManagerImpl implements QuizManager {

    @Autowired
    private QaQuizDao quizDao;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void setCurrentQuiz(QaQuiz quiz) {
        // reset all others
        List<QaQuiz> all = quizDao.findAll();
        for (QaQuiz q : all) {
            q.setCurrent(false);
        }
        sessionFactory.getCurrentSession().flush();

        // reset the one we want
        quiz.setCurrent(true);
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public QaQuiz getCurrentQuiz() {
        return quizDao.findCurrent();
    }

    @Override
    public void processRound(QaRound round) {
        // TODO:
    }
}
