package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.model.QaInstructor;
import my.gov.kpn.quiz.core.model.QaSchoolType;
import my.gov.kpn.quiz.core.model.QaState;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/16/13
 */
public interface QaInstructorDao {

    QaInstructor findById(Long id);

    Integer count();

    List<QaInstructor> find(Integer offset, Integer limit);

    List<QaSchoolType> findRegisteredByState(QaState state);

    List<String> findSchoolRegisteredByStateAndType(QaState state, QaSchoolType schoolType);
}
