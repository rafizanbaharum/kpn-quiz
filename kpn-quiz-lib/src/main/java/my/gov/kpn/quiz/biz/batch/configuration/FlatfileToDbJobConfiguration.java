package my.gov.kpn.quiz.biz.batch.configuration;

import my.gov.kpn.quiz.biz.batch.listener.LogProcessListener;
import my.gov.kpn.quiz.biz.batch.listener.ProtocolListener;
import my.gov.kpn.quiz.biz.batch.processor.LogItemProcessor;
import my.gov.kpn.quiz.core.dao.QaActorDao;
import my.gov.kpn.quiz.core.dao.QaStateDao;
import my.gov.kpn.quiz.core.dao.QaUserDao;
import my.gov.kpn.quiz.core.model.impl.QaStudentImpl;
import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.List;

//@Configuration
//@Transactional
@EnableBatchProcessing
public class FlatfileToDbJobConfiguration implements BatchConfigurer {
    public static final Logger log = Logger.getLogger(FlatfileToDbJobConfiguration.class);

    @Autowired
    private JobBuilderFactory jobBuilders;

    @Autowired
    private StepBuilderFactory stepBuilders;

    @Autowired
    private DataSource dataSource;

    @Autowired
    @Qualifier(value = "txManager")
    private PlatformTransactionManager transactionManager;

    @Autowired
    private QaActorDao actorDao;

    @Autowired
    private QaUserDao userDao;

    @Autowired
    private QaStateDao stateDao;

    @Bean
    public Job flatfileToDbJob() {
        return jobBuilders.get("flatfileToDbJob")
                .listener(protocolListener())
                .start(step())
                .build();
    }

    @Bean
    public Step step() {
        return stepBuilders.get("step")
                .<QaStudentImpl, QaStudentImpl>chunk(1)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .listener(logProcessListener())
                .build();
    }

    @Bean
    public FlatFileItemReader<QaStudentImpl> reader() {
        FlatFileItemReader<QaStudentImpl> itemReader = new FlatFileItemReader<QaStudentImpl>();
        itemReader.setLineMapper(lineMapper());
        itemReader.setResource(new ClassPathResource("actor-import.csv"));
        return itemReader;
    }

    @Bean
    public LineMapper<QaStudentImpl> lineMapper() {
        DefaultLineMapper<QaStudentImpl> lineMapper = new DefaultLineMapper<QaStudentImpl>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames(new String[]{"name", "email"});
        lineTokenizer.setIncludedFields(new int[]{0, 2});
        BeanWrapperFieldSetMapper<QaStudentImpl> fieldSetMapper = new BeanWrapperFieldSetMapper<QaStudentImpl>();
        fieldSetMapper.setTargetType(QaStudentImpl.class);
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }

    @Bean
    public ItemProcessor<QaStudentImpl, QaStudentImpl> processor() {
        return new LogItemProcessor<QaStudentImpl>();
    }

    @Bean
    public ItemWriter<QaStudentImpl> writer() {
        return new ItemWriter<QaStudentImpl>() {
            @Override
            public void write(List<? extends QaStudentImpl> items) throws Exception {
                if (!items.isEmpty()) {
                    log.debug(stateDao.findByCode("01").toString());
                }
            }
        };
    }

    @Bean
    public ProtocolListener protocolListener() {
        return new ProtocolListener();
    }

    @Bean
    public LogProcessListener logProcessListener() {
        return new LogProcessListener();
    }

    public JobRepository getJobRepository() throws Exception {
        JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
        factory.setDataSource(dataSource);
        factory.setTransactionManager(getTransactionManager());
        factory.afterPropertiesSet();
        return (JobRepository) factory.getObject();
    }

    public PlatformTransactionManager getTransactionManager() throws Exception {
        return transactionManager;
        //return new WebSphereUowTransactionManager();
    }

    public JobLauncher getJobLauncher() throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(getJobRepository());
        jobLauncher.afterPropertiesSet();
        return jobLauncher;
    }
}


