package my.gov.kpn.quiz.core;

import my.gov.kpn.quiz.config.Config;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author rafizan.baharum
 * @since 11/8/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class})
public class QaSchemaTest extends AbstractTransactionalJUnit4SpringContextTests {

    private Logger log = LoggerFactory.getLogger(QaSchemaTest.class);

    @Autowired
    private SessionFactory sessionFactory;


    @Before
    public void setUp() {
    }

    @Test
    @Rollback(value = true)
    public void test() {
        String capitalize = WordUtils.capitalize("alif haikal abd razak");
        log.debug("capitalize = " + capitalize);
    }

}