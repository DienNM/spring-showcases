package com.dee.web.spring.usecase7;

import junit.framework.TestCase;

import org.junit.Assert;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author dien.nguyen
 **/

public class ProfileTest extends TestCase {

    @SuppressWarnings("resource")
    public void testStaticFactoryMethod() {
        GenericXmlApplicationContext appContext = new GenericXmlApplicationContext();
        
        appContext.getEnvironment().setActiveProfiles("global", "dev");
        appContext.load("/spring/usecase7/*-profile-app-context.xml");
        appContext.refresh();
        
        AppConfig appConfig = appContext.getBean("appConfig", AppConfig.class);
        Assert.assertNotNull(appConfig);
        Assert.assertEquals("DEV", appConfig.getProfile());
        Assert.assertEquals("1.0.0-SNAPSHOT", appConfig.getVersion());
        Assert.assertTrue(appConfig.isCleanDb());
        
        // Change profile

        appContext.getEnvironment().setActiveProfiles("global", "prod");
        appContext.load("/spring/usecase7/*-profile-app-context.xml");
        
        appConfig = appContext.getBean("appConfig", AppConfig.class);
        Assert.assertNotNull(appConfig);
        Assert.assertEquals("PRO", appConfig.getProfile());
        Assert.assertEquals("1.0.0", appConfig.getVersion());
        Assert.assertFalse(appConfig.isCleanDb());
    }
}
