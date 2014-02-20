package my.gov.kpn.quiz.web.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
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
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
        properties.put("hibernate.cache.use_query_cache", env.getProperty("hibernate.cache.use_query_cache"));
        properties.put("hibernate.cache.use_second_level_cache", env.getProperty("hibernate.cache.use_second_level_cache"));
        properties.put("hibernate.generate_statistics", env.getProperty("hibernate.generate_statistics"));
        properties.put("hibernate.cache.region.factory_class", env.getProperty("hibernate.cache.region.factory_class"));

        properties.put("hibernate.order_updates", env.getProperty("hibernate.order_updates"));
        properties.put("hibernate.id.new_generator_mappings", env.getProperty("hibernate.id.new_generator_mappings"));
        properties.put("hibernate.jdbc.fetch_size", env.getProperty("hibernate.jdbc.fetch_size"));
        properties.put("hibernate.jdbc.batch_size", env.getProperty("hibernate.jdbc.batch_size"));
        properties.put("hibernate.connection.release_mode", env.getProperty("hibernate.connection.release_mode"));
        properties.put("hibernate.bytecode.use_reflection_optimizer", env.getProperty("hibernate.bytecode.use_reflection_optimizer"));
        properties.put("hibernate.bytecode.provider", env.getProperty("hibernate.bytecode.provider"));
        properties.put("javax.persistence.validation.mode", env.getProperty("javax.persistence.validation.mode"));
        return properties;
    }

    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setUser(env.getProperty("db.username"));
            dataSource.setPassword(env.getProperty("db.password"));
            dataSource.setJdbcUrl(env.getProperty("db.url"));
            dataSource.setDriverClass(env.getProperty("db.driver"));

            // custom config
            dataSource.setAcquireIncrement(Integer.parseInt(env.getProperty("c3p0.acquire_increment")));
            dataSource.setMinPoolSize(Integer.parseInt(env.getProperty("c3p0.min_pool_size")));
            dataSource.setMaxPoolSize(Integer.parseInt(env.getProperty("c3p0.max_pool_size")));
            dataSource.setMaxIdleTime(Integer.parseInt(env.getProperty("c3p0.max_idle_time")));
            dataSource.setMaxStatements(Integer.parseInt(env.getProperty("c3p0.max_statements")));
            dataSource.setIdleConnectionTestPeriod(Integer.parseInt(env.getProperty("c3p0.idle_conn_test_period")));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}