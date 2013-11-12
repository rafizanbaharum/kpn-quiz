package my.gov.kpn.quiz.biz;

import my.gov.kpn.quiz.biz.manager.RegistrationManager;
import my.gov.kpn.quiz.config.Config;
import my.gov.kpn.quiz.core.dao.QaStateDao;
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
public class RegistrationManagerTest  extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private RegistrationManager registrationManager;


    @Test
    public void create(){

        registrationManager.registerInstructor("ali","abc123","ali","abc123","mail@mail.com"
                ,"fax","phone",2L,"schoolName");
    }
}
