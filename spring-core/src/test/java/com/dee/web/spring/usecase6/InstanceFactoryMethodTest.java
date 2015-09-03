package com.dee.web.spring.usecase6;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import junit.framework.TestCase;

/**
 * @author dien.nguyen
 **/

public class InstanceFactoryMethodTest extends TestCase {

    private ApplicationContext appContext;

    @Override
    protected void setUp() throws Exception {
        appContext = new GenericXmlApplicationContext("/spring/usecase6/instance-factory-method-bean-app-context.xml");
    }

    public void testStaticFactoryMethod() {
        EpisodeResult episodeResult = appContext.getBean("episodeResult", EpisodeResult.class);
        SeriesResult seriesResult = appContext.getBean("seriesResult", SeriesResult.class);

        Assert.assertNotNull(episodeResult);
        Assert.assertEquals("Episode Data", episodeResult.getData());

        Assert.assertNotNull(seriesResult);
        Assert.assertEquals("Series Data", seriesResult.getData());
    }

}
