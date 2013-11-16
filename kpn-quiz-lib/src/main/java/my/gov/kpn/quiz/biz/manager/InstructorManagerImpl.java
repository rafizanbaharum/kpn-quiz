package my.gov.kpn.quiz.biz.manager;

import my.gov.kpn.quiz.core.dao.QaActorDao;
import my.gov.kpn.quiz.core.dao.QaStudentDao;
import my.gov.kpn.quiz.core.dao.QaUserDao;
import my.gov.kpn.quiz.core.model.QaActor;
import my.gov.kpn.quiz.core.model.QaInstructor;
import my.gov.kpn.quiz.core.model.QaStudent;
import my.gov.kpn.quiz.core.model.QaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("instructorManager")
@Transactional
public class InstructorManagerImpl implements InstructorManager {


    @Autowired
    private QaActorDao actorDao;

    @Autowired
    private QaStudentDao studentDao;

    @Autowired
    private QaUserDao userDao;

    @Override
    public QaUser findUserByActor(QaActor actor) {
        return userDao.findByActor(actor);
    }

    @Override
    public QaStudent findStudentById(Long id) {
        return studentDao.findById(id);
    }

    @Override
    public List<QaStudent> getStudents(QaInstructor instructor) {
        return actorDao.findStudent(instructor);
    }

}
