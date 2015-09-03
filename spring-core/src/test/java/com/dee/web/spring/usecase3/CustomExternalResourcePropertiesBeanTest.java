package com.dee.web.spring.usecase3;

import junit.framework.TestCase;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dee.web.spring.usecase3.config.AppPropertiesPlacehober;

/**
 * @author dien.nguyen
 **/

public class CustomExternalResourcePropertiesBeanTest extends TestCase{
    
    private ApplicationContext appContext;
    
    @Override
    protected void setUp() throws Exception {
        appContext = new GenericXmlApplicationContext("/spring/usecase3/customproperties-resource-app-context.xml");
    }
    
    public void testLoadFile() {
        
        ThreadPoolConfig threadPoolConfig = appContext.getBean("threadPoolConfig", ThreadPoolConfig.class);
        Assert.assertEquals(5, threadPoolConfig.getInitSize());
        Assert.assertEquals(20, threadPoolConfig.getMaxSize());
        Assert.assertEquals("DEE", threadPoolConfig.getPrefixName());
        Assert.assertEquals(10, threadPoolConfig.getIdleSize());
        
        AppConfig appConfig = appContext.getBean("appConfig", AppConfig.class);
        Assert.assertEquals("1.0", appConfig.getVersion());
        Assert.assertEquals("DEV", appConfig.getProfile());
        
        // Get properties
        
        Assert.assertEquals("1.0", AppPropertiesPlacehober.getProperty("version"));
        Assert.assertEquals("DEV", AppPropertiesPlacehober.getProperty("profile"));
        
    }
    
}
