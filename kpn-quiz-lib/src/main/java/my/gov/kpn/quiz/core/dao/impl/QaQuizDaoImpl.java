package my.gov.kpn.quiz.core.dao.impl;

import my.gov.kpn.quiz.core.dao.QaQuizDao;
import my.gov.kpn.quiz.core.model.*;
import my.gov.kpn.quiz.core.model.impl.QaQuizImpl;
import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
@Repository("quizDao")
public class QaQuizDaoImpl extends DaoSupport<Long, QaQuiz, QaQuizImpl> implements QaQuizDao {

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public QaQuiz findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (QaQuiz) session.get(QaQuizImpl.class, id);
    }

    @Override
    public QaQuiz findByRound(Integer round) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaQuiz a where " +
                "a.round = :round " +
                "and a.metadata.state = :state");
        query.setInteger("round", round);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return (QaQuiz) query.uniqueResult();
    }

    @Override
    public QaQuiz findCurrent() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaQuiz a where " +
                "a.current = :current " +
                "and a.metadata.state = :state");
        query.setBoolean("current", true);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return (QaQuiz) query.uniqueResult();
    }

    @Override
    public List<QaQuiz> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaQuiz a where " +
                "a.metadata.state = :state " +
                "order by a.round asc");
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return query.list();
    }

    @Override
    public List<QaQuiz> find(QaCompetition competition) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaQuiz a where " +
                "a.competition = :competition " +
                "and a.metadata.state = :state " +
                "order by a.round asc");
        query.setEntity("competition", competition);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return query.list();
    }

    @Override
    public List<QaQuiz> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaQuiz a where " +
                "a.metadata.state = :state " +
                "order by a.round asc");
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }


    @Override
    @Cacheable(value = "questionRegion")
    public List<QaQuestion> findQuestions(QaQuiz quiz) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaQuestion a where " +
                "a.quiz = :quiz " +
                "and a.metadata.state = :state " +
                "order by a.id");
        query.setEntity("quiz", quiz);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return query.list();
    }

    @Override
    public List<QaParticipant> findParticipants(QaQuiz quiz) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaParticipant a where " +
                "a.quiz = :quiz " +
                "and a.metadata.state = :state " +
                "order by a.result desc");
        query.setEntity("quiz", quiz);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return query.list();
    }

    @Override
    public List<QaParticipant> findParticipants(QaQuiz quiz, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaParticipant a where " +
                "a.quiz = :quiz " +
                "and a.metadata.state = :state " +
                "order by a.result desc");
        query.setEntity("quiz", quiz);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<QaParticipant> findParticipants(QaQuiz quiz, QaParticipantSortType sortType, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = null;

        switch (sortType) {
            case SCHOOL:
                query = session.createQuery("select a from QaParticipant a, QaStudent s " +
                        "where " +
                        "a.quiz = :quiz " +
                        "and a.user.actor.id = s.id " +
                        "and a.metadata.state = :state " +
                        "order by s.schoolName asc, a.result desc");
                query.setEntity("quiz", quiz);
                query.setInteger("state", QaMetaState.ACTIVE.ordinal());
                break;
            case DISTRICT:
                query = session.createQuery("select a from QaParticipant a, QaStudent s " +
                        "where " +
                        "a.quiz = :quiz " +
                        "and a.user.actor.id = s.id " +
                        "and a.metadata.state = :state " +
                        "order by s.districtName asc, a.result desc");
                query.setEntity("quiz", quiz);
                query.setInteger("state", QaMetaState.ACTIVE.ordinal());
                break;
            case STATE:
                query = session.createQuery("select a from QaParticipant a, QaStudent s " +
                        "where " +
                        "a.quiz = :quiz " +
                        "and a.user.actor.id = s.id " +
                        "and a.metadata.state = :state " +
                        "order by s.state.name asc, a.result desc");
                query.setEntity("quiz", quiz);
                query.setInteger("state", QaMetaState.ACTIVE.ordinal());
                break;
            default:
                query = session.createQuery("select a from QaParticipant a where " +
                        "a.quiz = :quiz " +
                        "and a.metadata.state = :state " +
                        "order by a.result desc");
                query.setEntity("quiz", quiz);
                query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        }
        return query.list();
    }

    @Override
    public Integer count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from QaQuiz a where " +
                "a.metadata.state = :state");
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countParticipant(QaQuiz quiz) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from QaParticipant a where " +
                "a.quiz = :quiz " +
                "and a.metadata.state = :state");
        query.setEntity("quiz", quiz);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }


    @Override
    public Integer countQuestion(QaQuiz quiz) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from QaQuestion a where " +
                "a.quiz = :quiz " +
                "and a.metadata.state = :state");
        query.setEntity("quiz", quiz);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countAnsweredQuestion(QaQuiz quiz, QaParticipant participant) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(gi) from QaGradebookItem gi where " +
                "gi.gradebook.quiz = :quiz " +
                "and gi.gradebook.participant = :participant " +
                "and (gi.answerIndex is not null or gi.answerResponse is not null)");
        query.setEntity("quiz", quiz);
        query.setEntity("participant", participant);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countUnansweredQuestion(QaQuiz quiz, QaParticipant participant) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(gi) from QaGradebookItem gi where " +
                "gi.gradebook.quiz = :quiz " +
                "and gi.gradebook.participant = :participant " +
                "and (gi.answerIndex is null or gi.answerResponse is null)");
        query.setEntity("quiz", quiz);
        query.setEntity("participant", participant);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean hasQuestion(QaQuiz quiz) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from QaQuestion u where " +
                "u.quiz = :quiz");
        query.setEntity("quiz", quiz);
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean hasAnswer(QaQuestion question, QaParticipant participant) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(gi) from QaGradebookItem gi where " +
                "gi.gradebook.participant = :participant " +
                "and gi.question = :question " +
                "and (gi.answerIndex is not null or gi.answerResponse is not null)");
        query.setEntity("participant", participant);
        query.setEntity("question", question);
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean hasParticipant(QaQuiz quiz) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from QaParticipant u where " +
                "u.quiz = :quiz");
        query.setEntity("quiz", quiz);
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isParticipant(QaQuiz quiz, QaUser user) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from QaParticipant u where " +
                "u.quiz = :quiz " +
                "and u.user = :user");
        query.setEntity("quiz", quiz);
        query.setEntity("user", user);
        return 0 < ((Long) query.uniqueResult()).intValue();
    }
    // =============================================================================
    // CRUD METHODS
    // =============================================================================


    @Override
    public void addQuestion(QaQuiz quiz, QaQuestion question, QaUser user) {
        Validate.notNull(quiz, "Quiz should not be null");
        Validate.notNull(question, "Question should not be null");

        Session session = sessionFactory.getCurrentSession();
        question.setQuiz(quiz);

        // prepare metadata
        QaMetadata metadata = new QaMetadata();
        metadata.setState(QaMetaState.ACTIVE);
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreator(user.getId());
        question.setMetadata(metadata);
        session.save(question);
    }

    @Override
    public void removeQuestion(QaQuiz quiz, QaQuestion question, QaUser user) {
        Validate.notNull(quiz, "Quiz should not be null");
        Validate.notNull(question, "Question should not be null");

        Session session = sessionFactory.getCurrentSession();
        question.setQuiz(quiz);

        // prepare metadata
        QaMetadata metadata = quiz.getMetadata();
        metadata.setState(QaMetaState.INACTIVE);
        metadata.setDeletedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setDeleter(user.getId());
        question.setMetadata(metadata);
        session.update(question);
    }

    @Override
    public void addParticipant(QaQuiz quiz, QaParticipant participant, QaUser user) {
        Validate.notNull(quiz, "Quiz should not be null");
        Validate.notNull(participant, "Participant should not be null");

        Session session = sessionFactory.getCurrentSession();
        participant.setQuiz(quiz);

//        prepare metadata
        QaMetadata metadata = new QaMetadata();
        metadata.setState(QaMetaState.ACTIVE);
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreator(user.getId());
        participant.setMetadata(metadata);
        session.save(participant);
    }

    @Override
    public void removeParticipant(QaQuiz quiz, QaParticipant participant, QaUser user) {
        Validate.notNull(quiz, "Quiz should not be null");
        Validate.notNull(participant, "Participant should not be null");

        Session session = sessionFactory.getCurrentSession();
        participant.setQuiz(quiz);

//        prepare metadata
        QaMetadata metadata = quiz.getMetadata();
        metadata.setState(QaMetaState.INACTIVE);
        metadata.setDeletedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setDeleter(user.getId());
        participant.setMetadata(metadata);
        session.update(participant);
    }

    @Override
    public void resetParticipants(QaQuiz quiz, QaUser currentUser) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("DELETE FROM QA_PRCT WHERE QUIZ_ID = " + quiz.getId());
        query.executeUpdate();
    }

    /**
     * https://hibernate.atlassian.net/browse/HHH-7314
     *
     * @param quiz
     * @param currentUser
     */
    @Override
    public void resetGradebooks(QaQuiz quiz, QaUser currentUser) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("DELETE FROM QA_GRBI WHERE GRADEBOOK_ID IN (SELECT ID FROM QA_GRBK WHERE QUIZ_ID = " + quiz.getId() + ")");
        query.executeUpdate();

        Query query2 = session.createSQLQuery("DELETE FROM QA_GRBK WHERE QUIZ_ID = " + quiz.getId());
        query2.executeUpdate();
    }
}

