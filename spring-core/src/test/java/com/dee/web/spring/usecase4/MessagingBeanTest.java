package com.dee.web.spring.usecase4;

import java.util.Calendar;
import java.util.Locale;

import junit.framework.TestCase;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author dien.nguyen
 **/

public class MessagingBeanTest extends TestCase {

    private ApplicationContext appContext;

    @Override
    protected void setUp() throws Exception {
        appContext = new GenericXmlApplicationContext("/spring/usecase4/message-resource-app-context.xml");
    }

    public void testMessageResource() {
        Assert.assertEquals("USD", appContext.getMessage("currenncy.unit", null, Locale.US));
        Assert.assertEquals("MM-dd-yyyy", appContext.getMessage("datetime.format", null, Locale.US));
        
        System.out.println(appContext.getMessage("datetime.message.today", 
                new Object[] {Calendar.getInstance().getTime()}, Locale.US));
    }

}
