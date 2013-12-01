package my.gov.kpn.quiz.biz.manager;

import my.gov.kpn.quiz.core.model.QaActor;
import my.gov.kpn.quiz.core.model.QaInstructor;
import my.gov.kpn.quiz.core.model.QaStudent;
import my.gov.kpn.quiz.core.model.QaUser;

import java.util.List;

public interface InstructorManager {


    public QaStudent findStudentById(Long id);

    public QaUser findUserByActor(QaActor actor);

    public List<QaStudent> getStudents(QaInstructor instructor);

    public Boolean isCustodian(QaInstructor instructor, QaStudent student);
}
