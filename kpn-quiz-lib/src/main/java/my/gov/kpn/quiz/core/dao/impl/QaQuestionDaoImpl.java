package my.gov.kpn.quiz.core.dao.impl;

import my.gov.kpn.quiz.core.dao.QaQuestionDao;
import my.gov.kpn.quiz.core.model.*;
import my.gov.kpn.quiz.core.model.impl.QaQuestionImpl;
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
@Repository("questionDao")
public class QaQuestionDaoImpl extends DaoSupport<Long, QaQuestion, QaQuestionImpl> implements QaQuestionDao {

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public QaQuestion findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (QaQuestion) session.get(QaQuestionImpl.class, id);
    }

    @Override
    public List<QaQuestion> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaQuestion a where " +
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
        Query query = session.createQuery("select count(a) from QaQuestion a where " +
                "a.metadata.state = :state");
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    // =============================================================================
    // CRUD METHODS
    // =============================================================================
}

