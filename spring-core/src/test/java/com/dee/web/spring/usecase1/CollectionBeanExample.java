package com.dee.web.spring.usecase1;

import junit.framework.TestCase;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dee.web.spring.usecase1.model.User;

/**
 * @author dien.nguyen
 **/

public class CollectionBeanExample extends TestCase{
    
    private ApplicationContext appContext;
    
    @Override
    protected void setUp() throws Exception {
        appContext = new GenericXmlApplicationContext("/spring/usecase1/collection-app-context.xml");
    }
    
    public void testSetCollectionInLine() {
        User user = appContext.getBean("userPrototype", User.class);
        Assert.assertEquals("DienNM", user.getName());
        Assert.assertEquals("Tan Phu, Ho Chi Minh", user.getAddresses().get("home").getAddress());
        Assert.assertEquals("home", user.getAddresses().get("home").getAddressType());
        Assert.assertEquals("Tan Binh, Ho Chi Minh", user.getAddresses().get("office").getAddress());
        Assert.assertEquals("office", user.getAddresses().get("office").getAddressType());
        
        Assert.assertEquals(2, user.getFavourites().size());

        Assert.assertEquals(2, user.getPhones().size());
        Assert.assertEquals("01659.xxx.xxx", user.getPhones().get(0));
        
        Assert.assertEquals(2, user.getTraining().size());
        Assert.assertEquals("Java Programming", user.getTraining().get("java"));
        Assert.assertEquals("C Programming", user.getTraining().get("C"));
    }
    
    public void testSetCollectionExternalConfig() {
        User user = appContext.getBean("userExternalCollectionDefine", User.class);
        Assert.assertEquals("DienNM", user.getName());
        Assert.assertEquals("Tan Phu, Ho Chi Minh", user.getAddresses().get("home").getAddress());
        Assert.assertEquals("home", user.getAddresses().get("home").getAddressType());
        Assert.assertEquals("Tan Binh, Ho Chi Minh", user.getAddresses().get("office").getAddress());
        Assert.assertEquals("office", user.getAddresses().get("office").getAddressType());
        
        Assert.assertEquals(2, user.getFavourites().size());

        Assert.assertEquals(2, user.getPhones().size());
        Assert.assertEquals("01659.xxx.xxx", user.getPhones().get(0));
        
        Assert.assertEquals(2, user.getTraining().size());
        Assert.assertEquals("Java Programming", user.getTraining().get("java"));
        Assert.assertEquals("C Programming", user.getTraining().get("C"));
    }
    
    public void testSetCollectionSpecificConcreteClass() {
        User user = appContext.getBean("userSpecificConcreteClass", User.class);
        Assert.assertEquals("DienNM", user.getName());
        Assert.assertEquals("Tan Phu, Ho Chi Minh", user.getAddresses().get("home").getAddress());
        Assert.assertEquals("home", user.getAddresses().get("home").getAddressType());
        Assert.assertEquals("Tan Binh, Ho Chi Minh", user.getAddresses().get("office").getAddress());
        Assert.assertEquals("office", user.getAddresses().get("office").getAddressType());
        
        Assert.assertEquals(2, user.getFavourites().size());

        Assert.assertEquals(2, user.getPhones().size());
        Assert.assertEquals("01659.xxx.xxx", user.getPhones().get(0));
        
        Assert.assertEquals(2, user.getTraining().size());
        Assert.assertEquals("Java Programming", user.getTraining().get("java"));
        Assert.assertEquals("C Programming", user.getTraining().get("C"));
    }
}
