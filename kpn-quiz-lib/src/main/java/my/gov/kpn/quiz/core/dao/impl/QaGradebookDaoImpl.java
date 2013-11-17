package my.gov.kpn.quiz.core.dao.impl;

import my.gov.kpn.quiz.core.dao.QaGradebookDao;
import my.gov.kpn.quiz.core.model.*;
import my.gov.kpn.quiz.core.model.impl.QaGradebookImpl;
import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/11/13
 */
@Repository("gradebookDao")
public class QaGradebookDaoImpl extends DaoSupport<Long, QaGradebook, QaGradebookImpl> implements QaGradebookDao {

    @Override
    public QaGradebook findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (QaGradebook) session.get(QaGradebookImpl.class, id);
    }


    @Override
    public QaGradebookItem findItem(QaParticipant participant, QaQuiz quiz, QaQuestion question) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaGradebookItem a where " +
                "a.gradebook.quiz = :quiz " +
                "and a.gradebook.participant = :participant " +
                "and a.question = :question " +
                "and a.metadata.state = :state ");
        query.setEntity("participant", participant);
        query.setEntity("quiz", quiz);
        query.setEntity("question", question);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return (QaGradebookItem) query.uniqueResult();
    }

    @Override
    @Cacheable(value = "gradebookRegion")
    public QaGradebook find(QaParticipant participant, QaQuiz quiz) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaGradebook a where " +
                "a.quiz = :quiz " +
                "and a.participant = :participant " +
                "and a.metadata.state = :state ");
        query.setEntity("quiz", quiz);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return (QaGradebook) query.uniqueResult();
    }

    @Override
    public List<QaGradebookItem> find(QaGradebook gradebook) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaGradebookItem a where " +
                "a.gradebook = :gradebook " +
                "and a.metadata.state = :state ");
        query.setEntity("gradebook", gradebook);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return query.list();
    }

    @Override
    public List<QaGradebookItem> find(QaGradebook participant, QaQuiz quiz) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaGradebookItem a where " +
                "a.gradebook.participant = :participant " +
                "and a.gradebook.participant = :participant " +
                "and a.gradebook.quiz = :quiz " +
                "and a.metadata.state = :state ");
        query.setEntity("participant", participant);
        query.setEntity("quiz", quiz);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return query.list();
    }

    @Override
    public List<QaGradebook> find(QaParticipant participant, QaQuiz quiz, QaQuestion question) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaGradebook a where " +
                "a.quiz = :quiz " +
                "and a.participant = :participant " +
                "and a.metadata.state = :state ");
        query.setEntity("quiz", quiz);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return query.list();
    }

    @Override
    public List<QaGradebook> find(QaQuiz quiz) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaGradebook a where " +
                "a.quiz = :quiz" +
                "and a.metadata.state = :state ");
        query.setEntity("quiz", quiz);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return query.list();
    }

    @Override
    public Integer count(QaQuiz quiz) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from QaGradebook a where " +
                "a.metadata.state = :state");
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public void addItem(QaGradebook gradebook, QaGradebookItem item, QaUser user) {
        Validate.notNull(gradebook, "Gradebook should not be null");
        Validate.notNull(item, "Item should not be null");

        Session session = sessionFactory.getCurrentSession();
        item.setGradebook(gradebook);

        // prepare metadata
        QaMetadata metadata = new QaMetadata();
        metadata.setState(QaMetaState.ACTIVE);
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreator(user.getId());
        item.setMetadata(metadata);
        session.save(item);
    }

    @Override
    public void updateItem(QaGradebook gradebook, QaGradebookItem item, QaUser user) {
        Validate.notNull(gradebook, "Gradebook should not be null");
        Validate.notNull(item, "Item should not be null");

        Session session = sessionFactory.getCurrentSession();
        item.setGradebook(gradebook);

        // prepare metadata
        QaMetadata metadata = item.getMetadata();
        metadata.setState(QaMetaState.ACTIVE);
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifier(user.getId());
        item.setMetadata(metadata);
        session.update(item);
    }

    @Override
    public void removeItem(QaGradebook gradebook, QaGradebookItem item, QaUser user) {
        throw new UnsupportedOperationException(); // TODO
    }

    @Override
    public void deleteItem(QaGradebook Gradebook, QaGradebookItem item, QaUser user) {
        throw new UnsupportedOperationException(); // TODO
    }
}
