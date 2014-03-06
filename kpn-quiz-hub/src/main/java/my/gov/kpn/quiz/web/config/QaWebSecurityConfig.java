package my.gov.kpn.quiz.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

/**
 * http://spring.io/blog/2013/07/03/spring-security-java-config-preview-web-security/
 */
@Configuration
@EnableWebSecurity
public class QaWebSecurityConfig extends WebSecurityConfigurerAdapter {

    // only allow student
    @Autowired
    @Qualifier(value = "studentDetailService")
    private UserDetailsService userDetailService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/assets/**")
                .antMatchers("/resources/**")
                .antMatchers("/gxt/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .headers()
                .addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/*").permitAll()
                .antMatchers("/gxt/**").permitAll()
                .antMatchers("/quiz/**").hasRole("USER")
                .antMatchers("/secure/**").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/secure/application.jsp") // gwt.codesvr=127.0.0.1:9997
//                .defaultSuccessUrl("/secure/application.jsp?gwt.codesvr=127.0.0.1:9997")
                .failureUrl("/index.jsp?login_error=1")
                .loginPage("/index.jsp")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/index.jsp")
                .invalidateHttpSession(true)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .maximumSessions(1)
//                .sessionRegistry(sessionRegistry())
//                .expiredUrl("/gate/in")
        ;
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }


    @Override
    protected void registerAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService);
    }


}
