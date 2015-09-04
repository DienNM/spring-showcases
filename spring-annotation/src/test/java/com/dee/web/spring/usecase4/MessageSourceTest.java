package com.dee.web.spring.usecase4;

import java.util.Locale;

import junit.framework.TestCase;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author dien.nguyen
 **/

public class MessageSourceTest extends TestCase {
private ApplicationContext appContext;
    
    @Override
    protected void setUp() throws Exception {
        appContext = new GenericXmlApplicationContext("/spring/usecase4/usecase4-app-context.xml");
    }
    
    public void testBindingExternalResource() {
        MessageSource messageSoucre = appContext.getBean("messageSource", MessageSource.class);
        Assert.assertNotNull(messageSoucre);
        Assert.assertEquals("Today: Year = 2015, Month = 9, Day = 5", 
                messageSoucre.getMessage("message.today", new Object[] {"2015", 9, 5}, Locale.US));
        Assert.assertEquals("Hello DienNM", 
                messageSoucre.getMessage("message.greeting", new Object[] {"DienNM"}, Locale.US));
    }
    
}
