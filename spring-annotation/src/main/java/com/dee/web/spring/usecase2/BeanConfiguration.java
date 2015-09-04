package com.dee.web.spring.usecase2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author dien.nguyen
 **/

@Configuration
@Import({BeanConfiguration1.class, BeanConfiguration2.class})
public class BeanConfiguration {
    
    @Value("#{class2}")
    private Class2 class2;
    
    @Bean
    public Class4 class4() {
        Class4 class4 = new Class4("Class 4");
        class4.setClass2(class2);
        return class4;
    }
}
