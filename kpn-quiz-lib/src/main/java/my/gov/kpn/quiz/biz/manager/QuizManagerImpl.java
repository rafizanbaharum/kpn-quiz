package my.gov.kpn.quiz.biz.manager;

import my.gov.kpn.quiz.core.dao.QaGradebookDao;
import my.gov.kpn.quiz.core.dao.QaParticipantDao;
import my.gov.kpn.quiz.core.dao.QaQuizDao;
import my.gov.kpn.quiz.core.model.*;
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
    private QaParticipantDao participantDao;

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
    public QaParticipant findParticipant(QaQuiz quiz, QaUser user) {
        return participantDao.find(quiz.getRound(), user);
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
