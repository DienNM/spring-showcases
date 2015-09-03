package com.dee.web.spring.usecase2;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import junit.framework.TestCase;

/**
 * @author dien.nguyen
 **/

public class ScopeBeanTest extends TestCase{
    
    private ApplicationContext appContext;
    
    @Override
    protected void setUp() throws Exception {
        appContext = new GenericXmlApplicationContext("/spring/usecase2/scope-app-context.xml");
    }
    
    public void testSingleton() {
        Employee employee1 = appContext.getBean("employeeSingleton", Employee.class);
        Employee employee2 = appContext.getBean("employeeSingleton", Employee.class);
        
        Assert.assertTrue(appContext.isSingleton("employeeSingleton"));
        Assert.assertEquals("nmdien61@gmail.com", employee1.getEmail());
        Assert.assertEquals("nmdien61@gmail.com", employee2.getEmail());
        
        employee1.setEmail("nguyenminhdien1506@gmail.com");
        Assert.assertEquals("nguyenminhdien1506@gmail.com", employee1.getEmail());
        Assert.assertEquals("nguyenminhdien1506@gmail.com", employee2.getEmail());
    }
    
    public void testPrototype() {
        Employee employee1 = appContext.getBean("employeePrototype", Employee.class);
        Employee employee2 = appContext.getBean("employeePrototype", Employee.class);
        
        Assert.assertTrue(appContext.isPrototype("employeePrototype"));
        Assert.assertEquals("nmdien61@gmail.com", employee1.getEmail());
        Assert.assertEquals("nmdien61@gmail.com", employee2.getEmail());
        
        employee1.setEmail("nguyenminhdien1506@gmail.com");
        
        Assert.assertEquals("nguyenminhdien1506@gmail.com", employee1.getEmail());
        Assert.assertEquals("nmdien61@gmail.com", employee2.getEmail());
    }
    
}
