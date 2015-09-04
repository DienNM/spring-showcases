package com.dee.web.spring.usecase3;

import junit.framework.TestCase;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author dien.nguyen
 **/

public class ExternalResourceTest extends TestCase {
private ApplicationContext appContext;
    
    @Override
    protected void setUp() throws Exception {
        appContext = new GenericXmlApplicationContext("/spring/usecase3/usecase3-app-context.xml");
    }
    
    public void testBindingExternalResource() {
        AppConfig appConfig = appContext.getBean("appConfig", AppConfig.class);
        Assert.assertNotNull(appConfig);
        Assert.assertEquals("DEE", appConfig.getName());
        Assert.assertEquals(10, appConfig.getPriority());
        Assert.assertEquals("1.0", appConfig.getVersion());
    }
    
}
