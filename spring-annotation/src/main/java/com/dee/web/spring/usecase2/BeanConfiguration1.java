package com.dee.web.spring.usecase2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dien.nguyen
 **/

@Configuration
public class BeanConfiguration1 {
    
    @Bean
    public Class1 class1() {
        return new Class1("Class 1");
    }
    
}
