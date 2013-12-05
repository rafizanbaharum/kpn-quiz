package my.gov.kpn.quiz.core.dao.impl;

import my.gov.kpn.quiz.core.dao.QaStudentDao;
import my.gov.kpn.quiz.core.model.QaInstructor;
import my.gov.kpn.quiz.core.model.QaMetaState;
import my.gov.kpn.quiz.core.model.QaStudent;
import my.gov.kpn.quiz.core.model.impl.QaStudentImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * @author rafizan.baharum
 * @since 11/16/13
 */

@Repository("studentDao")
public class QaStudentDaoImpl extends DaoSupport<Long, QaStudent, QaStudentImpl> implements QaStudentDao {

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public QaStudent findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (QaStudent) session.get(QaStudentImpl.class, id);
    }

    @Override
    public Integer count(QaInstructor instructor) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from QaStudent a where " +
                "a.instructor = :instructor " +
                "and a.metadata.state = :state");
        query.setEntity("instructor", instructor);
        query.setInteger("state", QaMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }
}
