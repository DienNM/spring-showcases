package com.dee.web.spring.usecase9;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import junit.framework.TestCase;

/**
 * @author dien.nguyen
 */

public class PropertyEditorTest extends TestCase{
    
    private ApplicationContext appContext;
    
    @Override
    protected void setUp() throws Exception {
        appContext = new GenericXmlApplicationContext("/spring/usecase9/property-editor-app-context.xml");
    }
    
    public void testFormatField() {
        Schedule schedule = appContext.getBean("schedule1", Schedule.class);
        Assert.assertNotNull(schedule);
        Assert.assertNotNull(schedule.getStartDate());
        Assert.assertNotNull(schedule.getEndDate());
    }
    
    public void testPropertyEditor() {
        Schedule schedule = appContext.getBean("schedule2", Schedule.class);
        Assert.assertNotNull(schedule);
        Assert.assertNotNull(schedule.getStartDate());
        Assert.assertNotNull(schedule.getEndDate());
    }
    
}
