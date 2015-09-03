package com.dee.web.spring.usecase5;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author dien.nguyen
 **/

public class HandlerRegister implements BeanPostProcessor {
    
    private Map<String, CrawlerService> crawlers = new HashMap<String, CrawlerService>();
    
    public CrawlerService lookup(String type) {
        return crawlers.get(type);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String paramString) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String paramString) throws BeansException {
        if(bean instanceof CrawlerService) {
            CrawlerService crawlerService = (CrawlerService) bean;
            crawlers.put(crawlerService.getType(), crawlerService);
        }
        return bean;
    }

}
