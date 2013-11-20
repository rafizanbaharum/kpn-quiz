package my.gov.kpn.quiz.biz.batch.configuration;

import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @author Tobias Flohre
 */
public interface InfrastructureConfiguration {

	@Bean
	public abstract DataSource dataSource();

}