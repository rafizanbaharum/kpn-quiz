package my.gov.kpn.quiz.biz.manager;

import my.gov.kpn.quiz.biz.util.Utils;
import my.gov.kpn.quiz.core.dao.*;
import my.gov.kpn.quiz.core.model.*;
import my.gov.kpn.quiz.core.model.impl.QaGradebookImpl;
import my.gov.kpn.quiz.core.model.impl.QaGradebookItemImpl;
import my.gov.kpn.quiz.core.model.impl.QaParticipantImpl;
import org.apache.commons.lang.Validate;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.rmi.CORBA.Util;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/10/13
 */
@Component("competitionManager")
@Transactional
public class CompetitionManagerImpl implements CompetitionManager {

    private static final Logger log = Logger.getLogger(CompetitionManagerImpl.class);

    @Autowired
    private QaCompetitionDao competitionDao;

    @Autowired
    private QaUserDao userDao;

    @Autowired
    private QaQuizDao quizDao;

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
    public QaParticipant findCurrentParticipant(QaQuiz quiz) {
        return participantDao.find(quiz, Utils.getCurrentUser());
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
    public List<QaQuiz> findQuizzes() {
        return quizDao.find(competitionDao.findByYear(2013));
    }

    @Override
    public List<QaQuestion> findQuestions(QaQuiz quiz) {
        return quizDao.findQuestions(quiz);
    }

    @Override
    public void updateAnswer(QaParticipant participant, QaQuestion question, Integer answerIndex) {
        QaQuiz currentQuiz = getCurrentQuiz();
        QaGradebook gradebook = gradebookDao.find(participant, currentQuiz);
        QaGradebookItem item = gradebookDao.findItem(participant, currentQuiz, question);

        Validate.notNull(item, "Item should not be null");
        item.setAnswerIndex(answerIndex);
        gradebookDao.updateItem(gradebook, item, Utils.getCurrentUser());
    }

    @Override
    public void updateAnswer(QaParticipant participant, QaQuestion question, String answerResponse) {
        QaQuiz currentQuiz = getCurrentQuiz();
        QaGradebook gradebook = gradebookDao.find(participant, currentQuiz);
        QaGradebookItem item = gradebookDao.findItem(participant, currentQuiz, question);

        Validate.notNull(item, "Item should not be null");
        item.setAnswerResponse(answerResponse);
        gradebookDao.updateItem(gradebook, item, Utils.getCurrentUser());
    }

    @Override
    public Integer countParticipant(QaQuiz quiz) {
        return quizDao.countParticipant(quiz);
    }

    @Override
    public void calculateResult(QaQuiz quiz) {
        // TODO: not scalable
        // TODO: use chunk? or spring batch?
        List<QaGradebook> gradebooks = gradebookDao.find(quiz);
        for (QaGradebook gradebook : gradebooks) {
            Integer result = 0;
            List<QaGradebookItem> items = gradebook.getItems();
            for (QaGradebookItem item : items) {
                QaQuestion question = item.getQuestion();
                switch (question.getQuestionType()) {
                    case MULTIPLE_CHOICE:
                        if (item.getAnswerIndex().equals(question.getAnswerIndex())) {
                            result += 1;
                        }
                        break;
                    case BOOLEAN:
                        if (item.getAnswerIndex().equals(question.getAnswerIndex())) {
                            result += 1;
                        }
                        break;
                    case SUBJECTIVE:
                        // do nothing
                        break;
                }
            }
            QaParticipant participant = gradebook.getParticipant();
            participant.setResult(result);
            participantDao.update(participant, Utils.getCurrentUser());
            sessionFactory.getCurrentSession().flush();
        }
    }


    @Override
    public void processGradebook(QaQuiz quiz) {
        log.debug("process gradebook");
        // for every participant
        // create a gradebook
        List<QaParticipant> participants = quiz.getParticipants();
        log.debug("participant: " + participants.size());
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

        quiz.setProcessed(true);
        quizDao.update(quiz, Utils.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void processParticipant(QaQuiz quiz) {
        // TODO: not scalable
        // TODO: use chunk? or spring batch?
        // TODO: filter out non-student??
        List<QaUser> all = userDao.findAll();
        log.debug("participant: " + all.size());
        for (QaUser user : all) {
            QaActor actor = user.getActor();
            if (null != actor && actor.getActorType().equals(QaActorType.STUDENT)) {
                QaParticipant participant = new QaParticipantImpl();
                participant.setQuiz(quiz);
                participant.setUser(user);
                participantDao.save(participant, Utils.getCurrentUser());
            }
        }

//        quiz.setProcessed(true);
        quizDao.update(quiz, Utils.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
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
