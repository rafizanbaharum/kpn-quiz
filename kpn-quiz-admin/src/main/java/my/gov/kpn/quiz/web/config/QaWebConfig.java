package my.gov.kpn.quiz.web.config;

import javassist.ClassPath;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.XmlViewResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author alif razak
 */
@Configuration
@ComponentScan({"my.gov.kpn.quiz.core", "my.gov.kpn.quiz.biz", "my.gov.kpn.quiz.web"})
@PropertySource("classpath:app.properties")
@EnableTransactionManagement
public class QaWebConfig {

    @Autowired
    private Environment env;

    @Bean
    public SessionFactory sessionFactory() {
        return new LocalSessionFactoryBuilder(dataSource())
                .scanPackages("my.gov.kpn.quiz.core")
                .addProperties(hibernateProperties())
                .buildSessionFactory();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager(sessionFactory());
        return hibernateTransactionManager;
    }

    @Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.show_sql", "false");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.cache.use_query_cache", "true");
        properties.put("hibernate.cache.use_second_level_cache", "true");
        properties.put("hibernate.generate_statistics", "true");
        properties.put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
        properties.put("javax.persistence.validation.mode", "none");

        //properties.put("hibernate.connection.pool_size", "1");
        //properties.put("hibernate.format_sql", "true");
        //properties.put("hibernate.use_sql_comments", "true");
        //properties.put("hibernate.c3p0.min_size", "5");
        //properties.put("hibernate.c3p0.max_size", "20");
        //properties.put("hibernate.c3p0.timeout", "300");
        //properties.put("hibernate.c3p0.max_statements", "50");
        //properties.put("hibernate.c3p0.idle_test_period", "3000");
        //properties.put("hibernate.cache.use_second_level_cache", "true");
        //properties.put("hibernate.cache.region.factory_class","org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");
        //properties.put("hibernate.cache.use_query_cache", "true");
        //properties.put("hibernate.cache.use_minimal_puts", "true");
        //properties.put("hibernate.max_fetch_depth", "10");
        return properties;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setInitialSize(10);
        dataSource.setMaxActive(5);
        dataSource.setMaxWait(5000);
        return dataSource;
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {

        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("message");

        return messageSource;
    }

    @Bean
    public JavaMailSender mailSender() {
        Properties properties = new Properties();
        properties.put("mail.debug", env.getProperty("mail.debug"));
        properties.put("mail.smtp.auth", env.getProperty("mail.smtp.auth"));
        properties.put("mail.smtp.starttls.enable", env.getProperty("mail.smtp.starttls.enable"));

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(env.getProperty("mail.host"));
        mailSender.setPort(Integer.parseInt(env.getProperty("mail.port")));
        mailSender.setProtocol(env.getProperty("mail.protocol"));
        mailSender.setUsername(env.getProperty("mail.username"));
        mailSender.setPassword(env.getProperty("mail.password"));
        mailSender.setJavaMailProperties(properties);
        return mailSender;
    }

    @Bean
    public XmlViewResolver xmlViewResolver() {
        XmlViewResolver xmlViewResolver = new XmlViewResolver();

        xmlViewResolver.setLocation(new ClassPathResource("jasper-view.xml"));
        xmlViewResolver.setOrder(0);

        return xmlViewResolver;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}