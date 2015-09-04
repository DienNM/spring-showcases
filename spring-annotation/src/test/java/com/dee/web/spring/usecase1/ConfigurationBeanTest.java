package com.dee.web.spring.usecase1;

import java.util.HashMap;
import java.util.HashSet;

import junit.framework.TestCase;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dee.web.spring.usecase1.service.UserService;

/**
 * @author dien.nguyen
 **/

public class ConfigurationBeanTest extends TestCase{
    
    private ApplicationContext appContext;
    
    @Override
    protected void setUp() throws Exception {
        appContext = new GenericXmlApplicationContext("/spring/usecase1/usecase1-app-context.xml");
    }
    
    public void testCreateUserBean() {
        User user = appContext.getBean("user", User.class);
        Assert.assertEquals("DienNM", user.getName());
        
        Assert.assertTrue(user.getAddresses() instanceof HashMap);
        Assert.assertTrue(user.getFavourites() instanceof HashSet);
        
        Assert.assertEquals("Tan Phu, Ho Chi Minh", user.getAddresses().get("home").getAddress());
        Assert.assertEquals("home", user.getAddresses().get("home").getAddressType());
        Assert.assertEquals("Tan Binh, Ho Chi Minh", user.getAddresses().get("office").getAddress());
        Assert.assertEquals("office", user.getAddresses().get("office").getAddressType());
        Assert.assertEquals(2, user.getFavourites().size());
    }
    
    public void testUsingAnnotation() {
        
        User user = appContext.getBean("user", User.class);
        UserService userService = appContext.getBean("userService", UserService.class);
        userService.addUser(user);
        
        Assert.assertEquals(1, userService.getUsers().size());
        
        user = appContext.getBean("user", User.class);
        userService.addUser(user);
        Assert.assertEquals(2, userService.getUsers().size());
    }
}
