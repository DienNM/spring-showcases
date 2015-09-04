package com.dee.web.spring.usecase2;

import junit.framework.TestCase;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author dien.nguyen
 **/

public class BeansInteractionBeanTest extends TestCase{
    
    private ApplicationContext appContext;
    
    @Override
    protected void setUp() throws Exception {
        appContext = new GenericXmlApplicationContext("/spring/usecase2/usecase2-app-context.xml");
    }
    
    public void testCreateUserBean() {
        Class2 class2 = appContext.getBean("class2", Class2.class);
        Assert.assertNotNull(class2);
        Assert.assertNotNull(class2.getClass1());
        Assert.assertNotNull(class2.getClass3());

        Class1 class1 = appContext.getBean("class1", Class1.class);
        Assert.assertNotNull(class1);
        
        Class3 class3 = appContext.getBean("class3", Class3.class);
        Assert.assertNotNull(class3);
        
    }
    
}
