package com.dee.web.spring.usecase3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author dien.nguyen
 **/

@Configuration
@PropertySource("classpath:spring/usecase3/app-config.properties")
public class AppConfiguration {
    
    private @Value("${app.version}") String version;
    private @Value("${app.name}") String appName;
    private @Value("${app.priority}") int priority;
    
    private @Value("${app.notfound:1}") int notfound;
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer config = new PropertySourcesPlaceholderConfigurer();
        config.setIgnoreResourceNotFound(true);
        config.setIgnoreUnresolvablePlaceholders(true);
        return config;
    }
    
    @Bean
    public AppConfig appConfig() {
        AppConfig appConfig = new AppConfig();
        appConfig.setName(appName);
        appConfig.setVersion(version);
        appConfig.setPriority(priority);
        return appConfig;
    }
    
}
