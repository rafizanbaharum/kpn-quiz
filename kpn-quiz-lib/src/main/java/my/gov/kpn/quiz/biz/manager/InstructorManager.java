package my.gov.kpn.quiz.biz.manager;

import my.gov.kpn.quiz.core.model.QaActor;
import my.gov.kpn.quiz.core.model.QaInstructor;
import my.gov.kpn.quiz.core.model.QaStudent;
import my.gov.kpn.quiz.core.model.QaUser;

import java.util.List;

public interface InstructorManager {

    // finder
    QaInstructor findInstructorById(Long id);

    QaStudent findStudentById(Long id);

    QaUser findUserByActor(QaActor actor);

    List<QaInstructor> findInstructors(Integer offset, Integer limit);

    List<QaStudent> findStudents(QaInstructor instructor);


    // helper
    Boolean isCustodian(QaInstructor instructor, QaStudent student);

    Integer countInstructor();

}
