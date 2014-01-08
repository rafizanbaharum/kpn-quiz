package my.gov.kpn.quiz.core;

import my.gov.kpn.quiz.config.Config;
import my.gov.kpn.quiz.core.dao.QaUserDao;
import my.gov.kpn.quiz.core.dao.ReportDao;
import my.gov.kpn.quiz.core.model.QaUser;
import my.gov.kpn.quiz.core.report.StudentStatisticModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class})
@Transactional
public class ReportDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    ReportDao reportDao;

    @Autowired
    private QaUserDao userDao;

    private QaUser root;

    @Before
    public void setUp() {
        root = userDao.findById(0L);
    }


    @Test
    public void testStatisticReport(){

        Collection<StudentStatisticModel> studentStatisticMap = reportDao.getStudentStatisticMap();
        System.out.println(studentStatisticMap);


    }


}
