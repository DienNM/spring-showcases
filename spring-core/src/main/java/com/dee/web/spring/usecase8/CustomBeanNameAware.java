package com.dee.web.spring.usecase8;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @author dien.nguyen
 */

public class CustomBeanNameAware implements BeanNameAware{

    @Override
    public void setBeanName(String beanName) {
        System.out.println(beanName);
    }

}
