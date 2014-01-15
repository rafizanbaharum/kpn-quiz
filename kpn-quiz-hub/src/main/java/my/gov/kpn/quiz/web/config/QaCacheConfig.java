package my.gov.kpn.quiz.web.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.interceptor.DefaultKeyGenerator;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * http://blog.goyello.com/2012/01/20/quick-start-with-methods-caching-using-spring-3-1-and-ehcache/
 * http://stackoverflow.com/questions/8646582/java-based-configuration-for-ehcache-based-caching-not-working
 *
 * @author rafizan.baharum
 * @since 11/12/13
 */
@Configuration
@EnableCaching
public class QaCacheConfig  implements CachingConfigurer {

    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        ehCacheManagerFactoryBean.setCacheManagerName("objectCacheManager");
        ehCacheManagerFactoryBean.setShared(true);
        return ehCacheManagerFactoryBean;
    }

    @Bean
    public CacheManager cacheManager() {
        EhCacheCacheManager cacheManager = new EhCacheCacheManager();
        cacheManager.setCacheManager(ehCacheManagerFactoryBean().getObject());
        return cacheManager;
    }


    public KeyGenerator keyGenerator() {
        return new DefaultKeyGenerator();
    }
}
