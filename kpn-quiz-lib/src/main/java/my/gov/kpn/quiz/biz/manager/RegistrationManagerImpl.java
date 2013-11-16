package my.gov.kpn.quiz.biz.manager;

import my.gov.kpn.quiz.core.dao.QaActorDao;
import my.gov.kpn.quiz.core.dao.QaGroupDao;
import my.gov.kpn.quiz.core.dao.QaPrincipalRoleDao;
import my.gov.kpn.quiz.core.dao.QaUserDao;
import my.gov.kpn.quiz.core.exception.LockedGroupException;
import my.gov.kpn.quiz.core.exception.RecursiveGroupException;
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

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
@Service("instructorRegistrationManager")
@Transactional
public class RegistrationManagerImpl implements RegistrationManager {

    private static final Logger log = Logger.getLogger(RegistrationManagerImpl.class);

    public static final String ADMIN = "root";
    public static final String GROUP_INSTRUCTOR = "GROUP_INSTRUCTOR";
    public static final String GROUP_STUDENT = "GROUP_STUDENT";

    @Autowired
    private QaUserDao userDao;

    @Autowired
    private QaPrincipalRoleDao roleDao;

    @Autowired
    private QaGroupDao groupDao;

    @Autowired
    private QaActorDao actorDao;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ApplicationContext applicationContext;

    public void registerInstructor(String username,
                                   String password,
                                   String name,
                                   String nricNo,
                                   String email,
                                   String fax,
                                   String phone, Long stateId, String schoolName) {

        try {
            QaUser root = userDao.findByUsername(ADMIN);
            QaUser user = new QaUserImpl();
            user.setEmail(email);
            user.setUsername(username);
            user.setPassword(password);
            user.setRealname(name);
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
            instructor.setName(name);
            instructor.setNricNo(nricNo);
            instructor.setEmail(email);
            instructor.setPhone(phone);
            instructor.setFax(fax);
//            instructor.setStateName(stateId);
//            instructor.setDistrictName(districtId);
            instructor.setSchoolName(schoolName);
            actorDao.save(instructor, root);
            sessionFactory.getCurrentSession().flush();
            sessionFactory.getCurrentSession().refresh(instructor);

            // update user
            user.setActor(instructor);
            userDao.save(user, root);
            sessionFactory.getCurrentSession().flush();
            sessionFactory.getCurrentSession().refresh(user);

            // add into group GROUP_INSTRUCTOR
            QaGroup group = groupDao.findByName(GROUP_INSTRUCTOR);
            groupDao.addMember(group, user, root);

            sessionFactory.getCurrentSession().flush();
            sessionFactory.getCurrentSession().refresh(group);

            //create new team
//            QaTeam team = new QaTeamImpl();
//            team.setLeader(user);
//            teamDao.save(team,root);
//
//            sessionFactory.getCurrentSession().flush();
//            sessionFactory.getCurrentSession().refresh(team);

        } catch (RecursiveGroupException e) {
            e.printStackTrace();
        } catch (LockedGroupException e) {
            e.printStackTrace();
        }
    }


    public void registerStudent(String username,
                                String password,
                                String name,
                                String nricNo,
                                QaInstructor instructor) {

        try {

            QaUser root = userDao.findByUsername(ADMIN);
            QaUser user = new QaUserImpl();
            user.setUsername(username);
            user.setPassword(password);
            user.setRealname(name);
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
            student.setName(name);
            student.setNricNo(nricNo);
            student.setInstructor(instructor);
            actorDao.save(student, root);
            sessionFactory.getCurrentSession().flush();
            sessionFactory.getCurrentSession().refresh(student);

            // update user
            user.setActor(student);
            userDao.save(user, root);
            sessionFactory.getCurrentSession().flush();
            sessionFactory.getCurrentSession().refresh(student);

            QaGroup group = groupDao.findByName(GROUP_STUDENT);
            groupDao.addMember(group, user, root);

        } catch (RecursiveGroupException e) {
            e.printStackTrace();
        } catch (LockedGroupException e) {
            e.printStackTrace();
        }
    }

    public boolean isExists(String username) {
        return false;  // TODO:
    }
}
