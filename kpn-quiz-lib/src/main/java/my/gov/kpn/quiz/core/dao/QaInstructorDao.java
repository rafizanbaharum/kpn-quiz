package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.model.QaInstructor;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/16/13
 */
public interface QaInstructorDao {

    QaInstructor findById(Long id);

    Integer count();

    List<QaInstructor> find(Integer offset, Integer limit);
}
