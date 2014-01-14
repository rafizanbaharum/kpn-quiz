package my.gov.kpn.quiz.core;

import my.gov.kpn.quiz.config.Config;
import my.gov.kpn.quiz.core.dao.QaQuestionDao;
import my.gov.kpn.quiz.core.dao.QaStateDao;
import my.gov.kpn.quiz.core.model.QaActor;
import my.gov.kpn.quiz.core.model.QaQuestion;
import my.gov.kpn.quiz.core.model.QaState;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class})
public class QaHibernateCacheTest extends AbstractTransactionalJUnit4SpringContextTests {

    private static final Logger log = Logger.getLogger(QaHibernateCacheTest.class);

    @Autowired
    private QaQuestionDao questionDao;

    @Autowired
    private QaStateDao stateDao;

    @Autowired
    private SessionFactory sessionFactory;

    @Before
    public void setUp() {
    }


    @Test
    @Repeat(3)
    public void loadCachableEntity() {
        QaQuestion question = questionDao.findById(1L);
        log.debug("question = " + question);

        long queryCacheHitCount = sessionFactory.getCurrentSession().getStatistics().getEntityCount();
        Statistics secondLevelCacheHitCount = sessionFactory.getStatistics();
        log.debug("queryCacheHitCount = " + queryCacheHitCount);
        log.debug("secondLevelCacheHitCount = " + secondLevelCacheHitCount);
    }

    @Test
    @Repeat(3)
    public void loadUnCachableEntity() {
        QaState state = stateDao.findById(1L);
        log.debug("state = " + state);

        long queryCacheHitCount = sessionFactory.getCurrentSession().getStatistics().getEntityCount();
        Statistics secondLevelCacheHitCount = sessionFactory.getStatistics();
        log.debug("queryCacheHitCount = " + queryCacheHitCount);
        log.debug("secondLevelCacheHitCount = " + secondLevelCacheHitCount);
    }
}
