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
import org.joda.time.LocalDate;
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
    public QaParticipant findParticipantById(Long id) {
        QaParticipant participant = participantDao.findById(id);
        QaQuiz quiz = participant.getQuiz();
        return decorate(quiz, participant);
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
    public QaQuiz finQuizByRound(Integer round) {
        return quizDao.findByRound(round);
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
    public QaCompetition getCurrentYearCompetition() {
        return competitionDao.findByYear(LocalDate.now().getYear());
    }

    @Override
    public List<QaCompetition> findAll() {
        return competitionDao.find(0, 9999);
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
    public List<QaParticipant> findParticipants(QaQuiz quiz) {
        return decorate(quiz, quizDao.findParticipants(quiz));
    }

    private List<QaParticipant> decorate(QaQuiz quiz, List<QaParticipant> participants) {

        // decorate with next quiz selection
        // check if we have next quiz
        for (QaParticipant participant : participants) {
            QaQuiz nextRound = quizDao.findByRound(quiz.getRound() + 1);
            if (null != nextRound && null != participant.getUser()) {
                participant.setSelected(quizDao.isParticipant(nextRound, participant.getUser()));
            }
        }
        return participants;
    }


    private QaParticipant decorate(QaQuiz quiz, QaParticipant participant) {
        QaQuiz nextRound = quizDao.findByRound(quiz.getRound() + 1);
        if (null != nextRound && null != participant.getUser()) {
            participant.setSelected(quizDao.isParticipant(nextRound, participant.getUser()));
        }
        return participant;
    }

    @Override
    public List<QaParticipant> findParticipants(QaQuiz quiz, Integer offset, Integer limit) {
        return decorate(quiz, quizDao.findParticipants(quiz, offset, limit));
    }

    @Override
    public List<QaParticipant> findParticipants(QaQuiz quiz, QaParticipantSortType sortType, Integer offset, Integer limit) {
        return decorate(quiz, quizDao.findParticipants(quiz, sortType, offset, limit));
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

    public boolean hasQuestion(QaQuiz quiz) {
        return quizDao.hasQuestion(quiz);
    }

    public boolean hasParticipant(QaQuiz quiz) {
        return quizDao.hasParticipant(quiz);
    }

    @Override
    public boolean hasGradebookItem(QaQuestion question) {
        return questionDao.hasGradebookItem(question);
    }

    @Override
    public void tabulateResult(QaQuiz quiz) {
        // TODO: not scalable
        // TODO: use chunk? or spring batch?
        List<QaGradebook> gradebooks = gradebookDao.find(quiz); // todo chunking
        for (QaGradebook gradebook : gradebooks) {
            Integer result = 0;
            QaParticipant participant = gradebook.getParticipant();
            List<QaGradebookItem> items = gradebook.getItems();
            for (QaGradebookItem item : items) {
                QaQuestion question = item.getQuestion();
                switch (question.getQuestionType()) {
                    case MULTIPLE_CHOICE:
                        log.debug("answer:" + question.getAnswerIndex());
                        log.debug("response:" + item.getAnswerIndex());

                        if (null != item.getAnswerIndex() &&
                                null != question.getAnswerIndex() && // just in case
                                item.getAnswerIndex().equals(question.getAnswerIndex())) {
                            result += 1;
                        }
                        break;
                    case BOOLEAN:
                        if (null != item.getAnswerIndex() &&
                                null != question.getAnswerIndex() && // just in case
                                item.getAnswerIndex().equals(question.getAnswerIndex())) {
                            result += 1;
                        }
                        break;
                    case SUBJECTIVE:
                        participant.setAnswerResponse(item.getAnswerResponse());
                        break;
                }
            }
            log.debug("result: " + result);
            participant.setResult(result);
            participantDao.update(participant, Utils.getCurrentUser());
            sessionFactory.getCurrentSession().flush();
        }
    }

    @Override
    public void selectParticipantForNextRound(QaQuiz quiz, QaParticipant participant) {
        QaQuiz nextRound = quizDao.findByRound(quiz.getRound() + 1);
        QaParticipant newParticipant = new QaParticipantImpl();
        newParticipant.setQuiz(nextRound);
        newParticipant.setUser(participant.getUser());
        participantDao.save(newParticipant, Utils.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }


    @Override
    public void processGradebook(QaQuiz quiz) {
        log.debug("process gradebook");

        quizDao.resetGradebooks(quiz, Utils.getCurrentUser());
        sessionFactory.getCurrentSession().flush();

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

    /**
     * TODO: not scalable
     * TODO: use chunk? or spring batch?
     *
     * @param quiz
     */
    @Override
    public void processParticipant(QaQuiz quiz) {
        quizDao.resetGradebooks(quiz, Utils.getCurrentUser());
        sessionFactory.getCurrentSession().flush();

        quizDao.resetParticipants(quiz, Utils.getCurrentUser());
        sessionFactory.getCurrentSession().flush();

        int count = 0;
        List<QaUser> all = userDao.findAll();
        for (QaUser user : all) {
            QaActor actor = user.getActor();
            if (null != actor && actor.getActorType().equals(QaActorType.STUDENT)) {
                QaParticipant participant = new QaParticipantImpl();
                participant.setQuiz(quiz);
                participant.setUser(user);
                participantDao.save(participant, Utils.getCurrentUser());
                count++;
            }
        }
        log.debug("all participant: " + count);
        quizDao.update(quiz, Utils.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void resetParticipants(QaQuiz quiz) {
        quizDao.resetParticipants(quiz, Utils.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void resetGradebooks(QaQuiz quiz) {
        quizDao.resetGradebooks(quiz, Utils.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public QaCompetition saveCompetition(QaCompetition competition) {
        competitionDao.save(competition, Utils.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(competition);
        return competition;
    }

    @Override
    public void updateCompetition(QaCompetition competition) {
        competitionDao.update(competition, Utils.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeCompetition(QaCompetition competition) {
        competitionDao.deactivate(competition, Utils.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public QaQuiz saveQuiz(QaQuiz quiz) {
        quizDao.save(quiz, Utils.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(quiz);
        return quiz;
    }

    @Override
    public void updateQuiz(QaQuiz quiz) {
        quizDao.update(quiz, Utils.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeQuiz(QaQuiz quiz) {
        quizDao.deactivate(quiz, Utils.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public QaQuestion saveQuestion(QaQuestion question) {
        questionDao.save(question, Utils.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(question);
        return question;

    }

    @Override
    public void updateQuestion(QaQuestion question) {
        questionDao.update(question, Utils.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeQuestion(QaQuestion question) {
        questionDao.deactivate(question, Utils.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }
}
