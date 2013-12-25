package my.gov.kpn.quiz.core.dao.impl;

import my.gov.kpn.quiz.core.dao.QaInstructorDao;
import my.gov.kpn.quiz.core.model.QaInstructor;
import my.gov.kpn.quiz.core.model.QaMetaState;
import my.gov.kpn.quiz.core.model.QaSchoolType;
import my.gov.kpn.quiz.core.model.QaState;
import my.gov.kpn.quiz.core.model.impl.QaInstructorImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/16/13
 */

@Repository("instructorDao")
public class QaInstructorDaoImpl extends DaoSupport<Long, QaInstructor, QaInstructorImpl> implements QaInstructorDao {

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public QaInstructor findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (QaInstructor) session.get(QaInstructorImpl.class, id);
    }

    @Override
    public List<QaInstructor> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from QaInstructor a where " +
                "a.metadata.state = :state");
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<QaSchoolType> findRegisteredByState(QaState state) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct(a.schoolType) from QaInstructor a where " +
                "a.metadata.state = :state and a.state = :schoolState");
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        query.setEntity("schoolState", state);
        return query.list();
    }

    @Override
    public List<String> findSchoolRegisteredByStateAndType(QaState state, QaSchoolType schoolType) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct(a.schoolName) from QaInstructor a where " +
                "a.metadata.state = :state and a.state = :schoolState and a.schoolType = :schoolType");
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        query.setEntity("schoolState", state);
        query.setLong("schoolState", schoolType.ordinal());
        return query.list();
    }

    @Override
    public Integer count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from QaStudent a where " +
                "a.metadata.state = :state");
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }
}
