package com.dee.web.spring.usecase3;

import junit.framework.TestCase;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author dien.nguyen
 **/

public class ExternalResourceYamlBeanTest extends TestCase{
    
    private ApplicationContext appContext;
    
    @Override
    protected void setUp() throws Exception {
        appContext = new GenericXmlApplicationContext("/spring/usecase3/yaml-resource-app-context.xml");
    }
    
    public void testLoadFile() {
        AppConfig appConfig = appContext.getBean("appConfig", AppConfig.class);
        Assert.assertEquals("1.0", appConfig.getVersion());
        Assert.assertEquals("DEV", appConfig.getProfile());
        
        ThreadPoolConfig threadPoolConfig = appContext.getBean("threadPoolConfig", ThreadPoolConfig.class);
        Assert.assertEquals(5, threadPoolConfig.getInitSize());
        Assert.assertEquals(20, threadPoolConfig.getMaxSize());
        Assert.assertEquals("DEE", threadPoolConfig.getPrefixName());
        Assert.assertEquals(10, threadPoolConfig.getIdleSize());
    }
    
}
