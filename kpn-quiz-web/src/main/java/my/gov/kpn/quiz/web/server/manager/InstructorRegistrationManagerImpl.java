package my.gov.kpn.quiz.web.server.manager;

import my.gov.kpn.quiz.core.dao.*;
import my.gov.kpn.quiz.core.exception.LockedGroupException;
import my.gov.kpn.quiz.core.exception.RecursiveGroupException;
import my.gov.kpn.quiz.core.model.*;
import my.gov.kpn.quiz.core.model.impl.QaInstructorImpl;
import my.gov.kpn.quiz.core.model.impl.QaUserImpl;
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
public class InstructorRegistrationManagerImpl implements InstructorRegistrationManager {

    public static final String ADMIN = "root";

    public static final String GROUP_INSTRUCTOR = "GROUP_INSTRUCTOR";

    @Autowired
    private QaUserDao userDao;

    @Autowired
    private QaPrincipalRoleDao roleDao;

    @Autowired
    private QaGroupDao groupDao;

    @Autowired
    private QaActorDao actorDao;

    @Autowired
    private QaInstitutionDao institutionDao;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void register(String username,
                         String password,
                         String name,
                         String nricNo,
                         String email,
                         String fax,
                         String phone, String address1, String address2, String address3,
                         Long institutionId) {

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
            QaInstitution institution = institutionDao.findById(institutionId);
            QaInstructor instructor = new QaInstructorImpl();
            instructor.setName(name);
            instructor.setNricNo(nricNo);
            instructor.setAddress1(address1);
            instructor.setAddress2(address2);
            instructor.setAddress3(address3);
            instructor.setEmail(email);
            instructor.setPhone(phone);
            instructor.setFax(fax);
            instructor.setInstitution(institution);
            actorDao.save(instructor, root);
            sessionFactory.getCurrentSession().flush();
            sessionFactory.getCurrentSession().refresh(instructor);

            // update user
            user.setActor(instructor);
            userDao.save(user, root);
            sessionFactory.getCurrentSession().flush();
            sessionFactory.getCurrentSession().refresh(instructor);

            // add into group GROUP_INSTRUCTOR
            QaGroup group = groupDao.findByName(GROUP_INSTRUCTOR);
            groupDao.addMember(group, user, root);

        } catch (RecursiveGroupException e) {
            e.printStackTrace();
        } catch (LockedGroupException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isExists(String username) {
        return false;  // TODO:
    }
}
