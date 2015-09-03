package com.dee.web.spring.usecase1;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dee.web.spring.usecase1.model.User;

/**
 * @author dien.nguyen
 **/

public class CollectionBeanExample {
    
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        
        ApplicationContext appContext = new GenericXmlApplicationContext("/spring/usecase1/collection-app-context.xml");
        User user = appContext.getBean("user", User.class);
        
        Assert.assertEquals("DienNM", user.getName());
        Assert.assertEquals("Tan Phu, Ho Chi Minh", user.getAddresses().get("home").getAddress());
        Assert.assertEquals("home", user.getAddresses().get("home").getAddressType());
        Assert.assertEquals("Tan Binh, Ho Chi Minh", user.getAddresses().get("office").getAddress());
        Assert.assertEquals("office", user.getAddresses().get("office").getAddressType());
        
        Assert.assertEquals(2, user.getFavourites().size());

        Assert.assertEquals(2, user.getPhones().size());
        Assert.assertEquals("01659.xxx.xxx", user.getPhones().get(0));
        Assert.assertEquals("0838.xxx.xxx", user.getPhones().get(1));
    }
    
}
