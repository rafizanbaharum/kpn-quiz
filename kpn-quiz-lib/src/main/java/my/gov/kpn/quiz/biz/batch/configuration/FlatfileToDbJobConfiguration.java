package my.gov.kpn.quiz.biz.batch.configuration;

import my.gov.kpn.quiz.biz.batch.listener.LogProcessListener;
import my.gov.kpn.quiz.biz.batch.listener.ProtocolListener;
import my.gov.kpn.quiz.biz.batch.processor.LogItemProcessor;
import my.gov.kpn.quiz.core.model.QaActor;
import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.util.List;

@Configuration
//@Transactional
@EnableBatchProcessing
public class FlatfileToDbJobConfiguration extends DefaultBatchConfigurer {
    public static final Logger log = Logger.getLogger(FlatfileToDbJobConfiguration.class);

    @Autowired
    private JobBuilderFactory jobBuilders;

    @Autowired
    private StepBuilderFactory stepBuilders;

    /*
    @Autowired
      private QaActorDao actorDao;

      @Autowired
      private QaUserDao userDao;

      @Autowired
      private QaStateDao stateDao;
  */
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
                .<QaActor, QaActor>chunk(1)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .listener(logProcessListener())
                .build();
    }

    @Bean
    public FlatFileItemReader<QaActor> reader() {
        FlatFileItemReader<QaActor> itemReader = new FlatFileItemReader<QaActor>();
        itemReader.setLineMapper(lineMapper());
        itemReader.setResource(new ClassPathResource("actor-import.csv"));
        return itemReader;
    }

    @Bean
    public LineMapper<QaActor> lineMapper() {
        DefaultLineMapper<QaActor> lineMapper = new DefaultLineMapper<QaActor>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames(new String[]{"name", "email"});
        lineTokenizer.setIncludedFields(new int[]{0, 2});
        BeanWrapperFieldSetMapper<QaActor> fieldSetMapper = new BeanWrapperFieldSetMapper<QaActor>();
        fieldSetMapper.setTargetType(QaActor.class);
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }

    @Bean
    public ItemProcessor<QaActor, QaActor> processor() {
        return new LogItemProcessor<QaActor>();
    }

    @Bean
    public ItemWriter<QaActor> writer() {
        return new ItemWriter<QaActor>() {
            @Override
            public void write(List<? extends QaActor> items) throws Exception {
                if (!items.isEmpty()) {
                    log.debug("XXXXXXX");
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


}


