package com.dee.web.spring.usecase4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * @author dien.nguyen
 **/

@Configuration
public class MessageConfiguration {
    
    @Bean
    public static ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageResource = new ReloadableResourceBundleMessageSource();
        messageResource.setBasenames(new String[] {"classpath:spring/usecase4/messages/message"});
        messageResource.setCacheSeconds(1);
        
        return messageResource;
    }
}
