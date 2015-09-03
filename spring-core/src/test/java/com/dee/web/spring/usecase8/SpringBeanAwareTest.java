package com.dee.web.spring.usecase8;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dee.web.spring.usecase8.model.Course;

import junit.framework.TestCase;

/**
 * @author dien.nguyen
 */

public class SpringBeanAwareTest extends TestCase{
    
    ApplicationContext appContext;
    
    @Override
    protected void setUp() throws Exception {
        appContext = new GenericXmlApplicationContext("/spring/usecase8/aware-app-context.xml");
    }
    
    public void testBeanNameAware() {

        Student student = appContext.getBean("student", Student.class);
        student.setName("UpdatedName");
        
        Course course = appContext.getBean("course", Course.class);
        Assert.assertTrue(student.getCourses().isEmpty());
        
        CustomApplicationEventPublisherAware applicationEventPublisher = appContext.getBean("customApplicationEventPublisherAware", 
                CustomApplicationEventPublisherAware.class);
        
        applicationEventPublisher.publishNewCourse(course);
        Assert.assertEquals(1, student.getCourses().size());
        Assert.assertEquals("Java Programming", student.getCourses().get(0).getName());
        Assert.assertEquals(5, student.getCourses().get(0).getLength());
        
    }
    
}
