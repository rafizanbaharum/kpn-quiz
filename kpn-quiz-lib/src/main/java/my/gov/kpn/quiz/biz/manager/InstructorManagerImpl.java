package my.gov.kpn.quiz.biz.manager;

import my.gov.kpn.quiz.core.dao.QaActorDao;
import my.gov.kpn.quiz.core.dao.QaInstructorDao;
import my.gov.kpn.quiz.core.dao.QaStudentDao;
import my.gov.kpn.quiz.core.dao.QaUserDao;
import my.gov.kpn.quiz.core.model.*;
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
    private QaInstructorDao instructorDao;

    @Autowired
    private QaUserDao userDao;

    @Override
    public QaInstructor findInstructorById(Long id) {
        return instructorDao.findById(id);
    }

    @Override
    public QaStudent findStudentById(Long id) {
        return studentDao.findById(id);
    }

    @Override
    public QaUser findUserByActor(QaActor actor) {
        return userDao.findByActor(actor);
    }

    @Override
    public List<QaInstructor> findInstructors(Integer offset, Integer limit) {
        return instructorDao.find(offset, limit);
    }


    @Override
    public List<QaStudent> findStudents(QaInstructor instructor) {
        return actorDao.findStudent(instructor);
    }

    @Override
    public Boolean isCustodian(QaInstructor instructor, QaStudent student) {
        if (null != student)
            return actorDao.isCustodian(instructor, student);
        return Boolean.FALSE;
    }

    @Override
    public Integer countInstructor() {
        return instructorDao.count();
    }
}
