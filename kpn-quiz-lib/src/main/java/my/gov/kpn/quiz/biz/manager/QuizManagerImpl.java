package my.gov.kpn.quiz.biz.manager;

import my.gov.kpn.quiz.core.dao.QaGradebookDao;
import my.gov.kpn.quiz.core.dao.QaQuizDao;
import my.gov.kpn.quiz.core.model.QaParticipant;
import my.gov.kpn.quiz.core.model.QaQuestion;
import my.gov.kpn.quiz.core.model.QaQuiz;
import my.gov.kpn.quiz.core.model.QaRound;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/10/13
 */
@Component("quizManager")
@Transactional
public class QuizManagerImpl implements QuizManager {

    @Autowired
    private QaQuizDao quizDao;

    @Autowired
    private QaGradebookDao gradebookDao;

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

    @Override
    public QaQuiz findQuestionById(Long id) {
        return quizDao.findById(id);
    }

    @Override
    public List<QaQuestion> findQuestions(QaQuiz quiz) {
        return quizDao.findQuestions(quiz);
    }

    @Override
    public void updateAnswer(QaParticipant participant, QaQuestion question) {



    }
}
