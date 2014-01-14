package my.gov.kpn.quiz.core;

import my.gov.kpn.quiz.config.Config;
import my.gov.kpn.quiz.core.dao.QaActorDao;
import my.gov.kpn.quiz.core.dao.QaStateDao;
import my.gov.kpn.quiz.core.dao.QaUserDao;
import my.gov.kpn.quiz.core.model.QaInstructor;
import my.gov.kpn.quiz.core.model.QaPrincipalType;
import my.gov.kpn.quiz.core.model.QaStudent;
import my.gov.kpn.quiz.core.model.QaUser;
import my.gov.kpn.quiz.core.model.impl.QaInstructorImpl;
import my.gov.kpn.quiz.core.model.impl.QaStudentImpl;
import my.gov.kpn.quiz.core.model.impl.QaUserImpl;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class})
@Transactional
public class QaStudentTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private QaUserDao userDao;

    @Autowired
    private QaStateDao stateDao;

    @Autowired
    private QaActorDao actorDao;

    private QaUser root;


    @Before
    public void setUp() {
        root = userDao.findById(0L);
    }

    @Test
    public void createStudent() {

        QaStudent student = new QaStudentImpl();
        student.setName("Mike Wazowski");
        student.setNricNo("123456789012");
        student.setEmail("mike@yahoo.com");
        student.setPhone("0123456789");
        student.setSchoolName("SMK Teknik Kuala Klawang");
        student.setState(stateDao.findByCode("01"));
        actorDao.save(student, root);

        QaUserImpl user = new QaUserImpl();
        user.setActor(student);
        user.setUsername(student.getNricNo());
        user.setPassword(StringUtils.substring(student.getNricNo(), 0, 6));
        user.setRealname(student.getName());
        user.setPrincipalType(QaPrincipalType.USER);
        user.setEnabled(true);
        user.setLocked(true);
        userDao.save(user, root);
    }
}
