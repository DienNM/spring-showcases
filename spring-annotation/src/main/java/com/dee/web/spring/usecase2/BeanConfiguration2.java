package com.dee.web.spring.usecase2;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dien.nguyen
 **/

@Configuration
public class BeanConfiguration2 implements ApplicationContextAware{
    
    private ApplicationContext appCtx;
    
    @Bean
    public Class2 class2() {
        Class2 class2 = new Class2("Class 2");
        class2.setClass3(class3());
        Class1 class1 = appCtx.getBean("class1", Class1.class);
        class2.setClass1(class1);
        return class2;
    }
    
    @Bean
    public Class3 class3() {
        return new Class3("Class 3");
    }

    @Override
    public void setApplicationContext(ApplicationContext appCtx) throws BeansException {
        this.appCtx = appCtx;
    }
    
}
