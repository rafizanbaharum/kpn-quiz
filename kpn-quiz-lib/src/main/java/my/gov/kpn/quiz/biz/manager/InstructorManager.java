package my.gov.kpn.quiz.biz.manager;

import my.gov.kpn.quiz.core.model.QaActor;
import my.gov.kpn.quiz.core.model.QaInstructor;
import my.gov.kpn.quiz.core.model.QaStudent;
import my.gov.kpn.quiz.core.model.QaUser;

import java.util.List;

public interface InstructorManager {

    public List<QaStudent> getStudents(QaInstructor instructor);

    public QaUser findUserByActor(QaActor actor);
}
