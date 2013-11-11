package my.gov.kpn.quiz.biz.manager;

import my.gov.kpn.quiz.biz.util.Utils;
import my.gov.kpn.quiz.core.dao.QaGradebookDao;
import my.gov.kpn.quiz.core.dao.QaRoundDao;
import my.gov.kpn.quiz.core.dao.QaUserDao;
import my.gov.kpn.quiz.core.model.*;
import my.gov.kpn.quiz.core.model.impl.QaGradebookImpl;
import my.gov.kpn.quiz.core.model.impl.QaGradebookItemImpl;
import my.gov.kpn.quiz.core.model.impl.QaParticipantImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public class RoundManagerImpl implements RoundManager {

    @Autowired
    private QaRoundDao roundDao;

    @Autowired
    private QaGradebookDao gradebookDao;

    @Autowired
    private QaUserDao userDao;


    @Autowired
    private SessionFactory sessionFactory;

    public void processFirstRound(QaRound round) {
        // pick all as participant of first round
        List<QaUser> users = userDao.findAll();
        for (QaUser user : users) {
            QaParticipant participant = new QaParticipantImpl();
            participant.setRound(round);
            participant.setUser(user);
            sessionFactory.getCurrentSession().flush();
        }
    }

    public void processRound(QaRound round) {
        List<QaQuiz> quizzes = round.getQuizzes();
        for (QaQuiz quiz : quizzes) {

            // for every participant
            // create a gradebook
            List<QaParticipant> participants = round.getParticipants();
            for (QaParticipant participant : participants) {
                QaGradebook gradebook = new QaGradebookImpl();
                gradebook.setQuiz(quiz);
                gradebook.setParticipant(participant);
                gradebookDao.save(gradebook, Utils.getCurrentUser());
                sessionFactory.getCurrentSession().flush();
                sessionFactory.getCurrentSession().refresh(gradebook);

                List<QaQuestion> questions = quiz.getQuestions();
                for (QaQuestion question : questions) {
                    // create item for every question
                    QaGradebookItem item = new QaGradebookItemImpl();
                    item.setQuestion(question);
                    gradebookDao.addItem(gradebook, item, Utils.getCurrentUser());
                }
                sessionFactory.getCurrentSession().flush();
            }
        }
    }

    @Override
    public QaRound findRoundById(Long id) {
        return roundDao.findById(id);
    }
}
