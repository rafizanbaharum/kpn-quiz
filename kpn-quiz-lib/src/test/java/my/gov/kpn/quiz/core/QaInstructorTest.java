package my.gov.kpn.quiz.core;

import my.gov.kpn.quiz.config.Config;
import my.gov.kpn.quiz.core.dao.QaActorDao;
import my.gov.kpn.quiz.core.dao.QaStateDao;
import my.gov.kpn.quiz.core.dao.QaUserDao;
import my.gov.kpn.quiz.core.model.QaInstructor;
import my.gov.kpn.quiz.core.model.QaUser;
import my.gov.kpn.quiz.core.model.impl.QaInstructorImpl;
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
public class QaInstructorTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private QaUserDao userDao;

    @Autowired
    private QaStateDao stateDao;

    @Autowired
    private QaActorDao actorDao;

    private QaUser root;


    @Before
    public void setUp() {

        root = userDao.findByActor(0L);
    }

    @Test
    public void createInstructor() {

        QaInstructor instructor = new QaInstructorImpl();
        instructor.setName("name");
        instructor.setNricNo("nricNo");
        instructor.setEmail("email");
        instructor.setPhone("phone");
        instructor.setFax("fax");
        instructor.setState(stateDao.findByCode("01"));
        instructor.setSchoolName("schoolName");
        actorDao.save(instructor, root);


    }
}
