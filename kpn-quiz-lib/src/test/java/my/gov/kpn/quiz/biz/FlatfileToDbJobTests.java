package my.gov.kpn.quiz.biz;

import my.gov.kpn.quiz.biz.batch.configuration.FlatfileToDbJobConfiguration;
import my.gov.kpn.quiz.config.Config;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {Config.class, FlatfileToDbJobConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FlatfileToDbJobTests {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    @Qualifier("flatfileToDbJob")
    private Job job;

    @Before
    public void setup() {
    }

    @Test
    @Rollback(value = true)
    public void testLaunchJob() throws Exception {
        jobLauncher.run(job, new JobParameters());
//        assertThat(jdbcTemplate.queryForObject("select count(*) from QaActor", Integer.class), is(6));
    }

}
