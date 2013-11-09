package my.gov.kpn.quiz.core;

import com.google.common.io.LineReader;
import my.gov.kpn.quiz.config.Config;
import my.gov.kpn.quiz.core.dao.QaInstitutionDao;
import my.gov.kpn.quiz.core.dao.QaUserDao;
import my.gov.kpn.quiz.core.model.QaInstitution;
import my.gov.kpn.quiz.core.model.QaUser;
import my.gov.kpn.quiz.core.model.impl.QaInstitutionImpl;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class})
public class InstitutionLoader {
    private Logger log = LoggerFactory.getLogger(QaQuizTest.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private QaUserDao userDao;

    @Autowired
    private QaInstitutionDao institutionDao;

    private QaUser root;

    @Before
    public void setUp() {
        root = userDao.findByUsername("root");
    }


    @Test
    @Rollback(value = false)
    public void test() {
        try {
            File file = new File("C:/Projects/GitHub/kpn-quiz/kpn-quiz-web/src/test/resources/data/institution.txt");
            FileReader reader = new FileReader(file);
            LineReader lreader = new LineReader(reader);

            String line = null;
            int index = 0;
            while ((line = lreader.readLine()) != null) {
                QaInstitution institution = new QaInstitutionImpl();
                institution.setCode(Integer.toString(index));
                institution.setName(Integer.toString(index));
                institutionDao.save(institution, root);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
