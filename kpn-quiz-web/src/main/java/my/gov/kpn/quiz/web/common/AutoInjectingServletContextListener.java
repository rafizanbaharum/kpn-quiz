package my.gov.kpn.quiz.web.common;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author rafizan.baharum
 * @since 10/20/13
 */
public abstract class AutoInjectingServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent e) {
        WebApplicationContext ctx = WebApplicationContextUtils
                .getRequiredWebApplicationContext(e.getServletContext());
        AutowireCapableBeanFactory beanFactory = ctx.getAutowireCapableBeanFactory();
        beanFactory.autowireBean(this);
        doContextInitialized();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        doContextDestroyed();
    }

    protected abstract void doContextInitialized();

    protected abstract void doContextDestroyed();
}
