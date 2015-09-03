package com.dee.web.spring.usecase5;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import junit.framework.TestCase;

/**
 * @author dien.nguyen
 **/

public class LifetimeBeanTest extends TestCase{
    
    private ApplicationContext appContext;
    
    @Override
    protected void setUp() throws Exception {
        appContext = new GenericXmlApplicationContext("/spring/usecase5/lifetime-bean-app-context.xml");
    }
    
    public void testBeanPostProcessor() {
        HandlerRegister registers = appContext.getBean("handlerRegister", HandlerRegister.class);
        
        CrawlerService crawlerService = registers.lookup("episode");
        Assert.assertNotNull(crawlerService);
        Assert.assertEquals("Episode Data", crawlerService.crawl());
        
        crawlerService = registers.lookup("series");
        Assert.assertNotNull(crawlerService);
        Assert.assertEquals("Series Data", crawlerService.crawl());
        
        crawlerService = registers.lookup("none");
        Assert.assertNull(crawlerService);
    }
    
}
