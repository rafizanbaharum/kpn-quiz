package my.gov.kpn.quiz.web.config;

import my.gov.kpn.quiz.web.interceptor.CurrentUserHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author rafizan.baharum
 * @since 9/14/13
 */
@Configuration
@EnableWebMvc
public class QaMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
        registry.addResourceHandler("/docs/**").addResourceLocations("/docs/");
        registry.addResourceHandler("/gxt/**").addResourceLocations("/gxt/");
        registry.addResourceHandler("/quiz/**").addResourceLocations("/quiz/");
    }


    @Bean
    public ViewResolver jspViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CurrentUserHandlerInterceptor()).addPathPatterns("/secure/**");
    }
}
