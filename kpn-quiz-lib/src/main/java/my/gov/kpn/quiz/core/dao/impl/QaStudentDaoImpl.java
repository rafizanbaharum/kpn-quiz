package my.gov.kpn.quiz.core.dao.impl;

import my.gov.kpn.quiz.core.dao.QaStudentDao;
import my.gov.kpn.quiz.core.model.QaStudent;
import my.gov.kpn.quiz.core.model.impl.QaStudentImpl;
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
}
