package my.gov.kpn.quiz.core.dao.impl;

import my.gov.kpn.quiz.core.model.*;
import my.gov.kpn.quiz.core.model.impl.QaRoundImpl;
import my.gov.kpn.quiz.core.dao.QaRoundDao;
import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
@Repository("roundDao")
public class QaRoundDaoImpl extends DaoSupport<Long, QaRound, QaRoundImpl> implements QaRoundDao {

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public QaRound findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (QaRound) session.get(QaRoundImpl.class, id);
    }

    @Override
    public List<QaRound> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaRound a where " +
                "a.metadata.state = :state " +
                "order by a.id");
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return query.list();
    }

    @Override
    public List<QaRound> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaRound a where " +
                "a.metadata.state = :state " +
                "order by a.id");
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public Integer count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from QaRound a where " +
                "a.metadata.state = :state");
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countParticipant(QaRound round) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from QaParticipant a where " +
                "a.round = :round " +
                "and a.metadata.state = :state");
        query.setEntity("round", round);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    // =============================================================================
    // CRUD METHODS
    // =============================================================================


    @Override
    public void addQuiz(QaRound round, QaQuiz quiz, QaUser user) {
        Validate.notNull(round, "Round should not be null");
        Validate.notNull(round, "Round should not be null");

        Session session = sessionFactory.getCurrentSession();
        quiz.setRound(round);

        // prepare metadata
        QaMetadata metadata = new QaMetadata();
        metadata.setState(QaMetaState.ACTIVE);
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreator(user.getId());
        quiz.setMetadata(metadata);
        session.save(quiz);
    }

    @Override
    public void removeQuiz(QaRound round, QaQuiz quiz, QaUser user) {
        Validate.notNull(round, "Round should not be null");
        Validate.notNull(quiz, "Quiz should not be null");

        Session session = sessionFactory.getCurrentSession();
        quiz.setRound(round);

        // prepare metadata
        QaMetadata metadata = round.getMetadata();
        metadata.setState(QaMetaState.INACTIVE);
        metadata.setDeletedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setDeleter(user.getId());
        quiz.setMetadata(metadata);
        session.update(quiz);
    }


    @Override
    public void addParticipant(QaRound round, QaParticipant participant, QaUser user) {
        Validate.notNull(round, "Round should not be null");
        Validate.notNull(round, "Round should not be null");

        Session session = sessionFactory.getCurrentSession();
        participant.setRound(round);

        // prepare metadata
        QaMetadata metadata = new QaMetadata();
        metadata.setState(QaMetaState.ACTIVE);
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreator(user.getId());
        participant.setMetadata(metadata);
        session.save(participant);
    }

    @Override
    public void removeParticipant(QaRound round, QaParticipant participant, QaUser user) {
        Validate.notNull(round, "Round should not be null");
        Validate.notNull(participant, "Participant should not be null");

        Session session = sessionFactory.getCurrentSession();
        participant.setRound(round);

        // prepare metadata
        QaMetadata metadata = round.getMetadata();
        metadata.setState(QaMetaState.INACTIVE);
        metadata.setDeletedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setDeleter(user.getId());
        participant.setMetadata(metadata);
        session.update(participant);
    }
}

