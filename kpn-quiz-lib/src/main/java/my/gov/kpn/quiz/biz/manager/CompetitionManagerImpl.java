package my.gov.kpn.quiz.biz.manager;

import my.gov.kpn.quiz.biz.util.Utils;
import my.gov.kpn.quiz.core.dao.*;
import my.gov.kpn.quiz.core.model.*;
import my.gov.kpn.quiz.core.model.impl.QaGradebookImpl;
import my.gov.kpn.quiz.core.model.impl.QaGradebookItemImpl;
import my.gov.kpn.quiz.core.model.impl.QaParticipantImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/10/13
 */
@Component("competitionManager")
@Transactional
public class CompetitionManagerImpl implements CompetitionManager {

    @Autowired
    private QaCompetitionDao competitionDao;

    @Autowired
    private QaUserDao userDao;

    @Autowired
    private QaQuizDao quizDao;

    @Autowired
    private QaRoundDao roundDao;

    @Autowired
    private QaQuestionDao questionDao;

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
    public QaQuiz findQuizById(Long id) {
        return quizDao.findById(id);
    }

    @Override
    public QaCompetition findCompetitionById(Long id) {
        return competitionDao.findById(id);
    }

    @Override
    public QaCompetition findCompetitionByYear(int year) {
        return competitionDao.findByYear(year);
    }

    @Override
    public QaRound findRoundById(Long id) {
        return roundDao.findById(id);
    }

    @Override
    public QaQuestion findQuestionById(Long id) {
        return questionDao.findById(id);
    }

    @Override
    public QaGradebook findGradebook(QaParticipant participant, QaQuiz quiz) {
        return gradebookDao.find(participant, quiz);
    }

    @Override
    public QaGradebookItem findGradebookItem(QaParticipant participant, QaQuiz quiz, QaQuestion question) {
        return gradebookDao.findItem(participant, quiz, question);
    }

    @Override
    public List<QaQuiz> findQuizzes(QaRound round) {
        return quizDao.find(round);
    }

    @Override
    public List<QaRound> findRounds() {
        return roundDao.findAll();
    }

    @Override
    public List<QaQuestion> findQuestions(QaQuiz quiz) {
        return quizDao.findQuestions(quiz);
    }

    @Override
    public void updateAnswer(QaParticipant participant, QaQuestion question) {
    }

    @Override
    public Integer countParticipant(QaRound round) {
        return roundDao.countParticipant(round);
    }

    @Override
    public void updateRound(QaRound round) {
        roundDao.update(round, Utils.getCurrentUser());
    }

    @Override
    public void processGradebook(QaRound round) {
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

        // update round
        round.setProcessed(true);
        roundDao.update(round, Utils.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void processParticipant(QaRound round) {

        // TODO: not scalable
        // TODO: use chunk? or spring batch?
        List<QaUser> all = userDao.findAll();
        for (QaUser user : all) {
            QaActor actor = user.getActor();
            if (null != actor && actor.getActorType().equals(QaActorType.STUDENT)) {
                QaParticipant participant = new QaParticipantImpl();
                participant.setRound(round);
                participant.setUser(user);
                participantDao.save(participant, Utils.getCurrentUser());
            }
        }
    }

    @Override
    public void saveRound(QaRound round) {
        roundDao.save(round, Utils.getCurrentUser());
    }

    @Override
    public void saveQuiz(QaQuiz quiz) {
        quizDao.save(quiz, Utils.getCurrentUser());
    }

    @Override
    public void updateQuiz(QaQuiz quiz) {
        quizDao.update(quiz, Utils.getCurrentUser());
    }

    @Override
    public void saveQuestion(QaQuestion question) {
        questionDao.save(question, Utils.getCurrentUser());
    }

    @Override
    public void updateQuestion(QaQuestion question) {
        questionDao.update(question, Utils.getCurrentUser());
    }
}
