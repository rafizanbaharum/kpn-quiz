package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.model.QaInstructor;
import my.gov.kpn.quiz.core.model.QaStudent;

/**
 * @author rafizan.baharum
 * @since 11/16/13
 */
public interface QaStudentDao {

    QaStudent findById(Long id);

    Integer count(QaInstructor instructor);
}
