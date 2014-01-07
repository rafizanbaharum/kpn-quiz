package my.gov.kpn.quiz.biz.manager;

import my.gov.kpn.quiz.core.dao.QaActorDao;
import my.gov.kpn.quiz.core.dao.QaPrincipalRoleDao;
import my.gov.kpn.quiz.core.dao.QaStateDao;
import my.gov.kpn.quiz.core.dao.QaUserDao;
import my.gov.kpn.quiz.core.model.*;
import my.gov.kpn.quiz.core.model.impl.QaInstructorImpl;
import my.gov.kpn.quiz.core.model.impl.QaStudentImpl;
import my.gov.kpn.quiz.core.model.impl.QaUserImpl;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.apache.commons.lang.WordUtils.capitalize;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
@Service("instructorRegistrationManager")
@Transactional
public class RegistrationManagerImpl implements RegistrationManager {

    private static final Logger log = Logger.getLogger(RegistrationManagerImpl.class);

    public static final Long ADMIN = 0L;

    @Autowired
    private QaUserDao userDao;

    @Autowired
    private QaPrincipalRoleDao roleDao;

    @Autowired
    private QaActorDao actorDao;

    @Autowired
    private QaStateDao stateDao;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ApplicationContext applicationContext;

    public void registerInstructor(InstructorInfo instructorInfo) {

        QaUser root = userDao.findById(ADMIN);
        QaUser user = new QaUserImpl();
        user.setEmail(instructorInfo.getEmail());
        user.setUsername(instructorInfo.getUsername());
        user.setPassword(instructorInfo.getPassword());
        user.setRealname(instructorInfo.getName());
        user.setEnabled(true);
        user.setLocked(true);
        user.setPrincipalType(QaPrincipalType.USER);
        userDao.save(user, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(user);

        // add roles
        roleDao.grant(user, QaRoleType.ROLE_USER, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(user);

        // add actor
        QaInstructor instructor = new QaInstructorImpl();
        instructor.setName(capitalize(instructorInfo.getName()));
        instructor.setNricNo(instructorInfo.getNricNo());
        instructor.setEmail(instructorInfo.getEmail());
        instructor.setPhone(instructorInfo.getPhone());
        instructor.setFax(instructorInfo.getFax());
        instructor.setSchoolType(QaSchoolType.get(instructorInfo.getSchoolType()));
        instructor.setSchoolName(capitalize(instructorInfo.getSchoolName()));
        instructor.setSchoolPhone(instructorInfo.getSchoolPhone());
        instructor.setSchoolFax(instructorInfo.getSchoolFax());
        instructor.setState(stateDao.findById(instructorInfo.getStateId()));
        actorDao.save(instructor, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(instructor);

        // update user
        user.setActor(instructor);
        userDao.save(user, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(user);
    }


    public void registerStudent(String username,
                                String password,
                                String name,
                                String nricNo,
                                Date dob,
                                Integer genderType,
                                Integer raceType,
                                QaInstructor instructor) {

        QaUser root = userDao.findById(ADMIN);
        QaUser user = new QaUserImpl();
        user.setUsername(username);
        user.setPassword(password);
        user.setRealname(name);
        user.setEnabled(true);
        user.setLocked(true);
        user.setPrincipalType(QaPrincipalType.USER);
        userDao.save(user, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(user);

        // add roles
        roleDao.grant(user, QaRoleType.ROLE_USER, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(user);

        // add actor
        QaStudent student = new QaStudentImpl();
        student.setName(capitalize(name));
        student.setNricNo(nricNo);
        student.setInstructor(instructor);
        student.setDob(dob);
        student.setGenderType(QaGenderType.get(genderType));
        student.setRaceType(QaRaceType.get(raceType));

        student.setSchoolName(capitalize(instructor.getSchoolName()));
        student.setSchoolType(instructor.getSchoolType());
        student.setDistrictName(capitalize(instructor.getDistrictName()));
        student.setState(instructor.getState());
        actorDao.save(student, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(student);

        // update user
        user.setActor(student);
        userDao.save(user, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(student);
    }

    @Override
    public void updateStudent(QaStudent student,
                              String name,
                              Date dob,
                              Integer genderType,
                              Integer raceType
    ) {

        log.debug("Update = " + student);
        QaUser root = userDao.findById(ADMIN);
        QaUser user = userDao.findByActor(student);
        log.debug("user = " + user);
        userDao.update(user, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(user);

        student.setName(name);
        student.setDob(dob);
        student.setGenderType(QaGenderType.get(genderType));
        student.setRaceType(QaRaceType.get(raceType));
        actorDao.update(student, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(student);
    }

    @Override
    public void removeStudent(QaStudent student) {
        QaUser root = userDao.findById(ADMIN);
        userDao.remove(userDao.findById(student.getId()), root);
        actorDao.remove(student, root);
    }

    public boolean isExists(String username) {
        QaUser user = userDao.findByUsername(username);
        return (user != null);
    }
}
