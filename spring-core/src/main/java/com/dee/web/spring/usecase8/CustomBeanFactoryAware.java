package com.dee.web.spring.usecase8;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @author dien.nguyen
 */

public class CustomBeanFactoryAware implements BeanFactoryAware{

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(beanFactory.getClass());
    }

}
