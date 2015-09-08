package com.dee.spring.testing.basic;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dee.spring.testing.basic.junit.CrawledData;
import com.dee.spring.testing.basic.junit.CrawlerService;
import com.dee.spring.testing.basic.junit.EpisodeCrawlerService;
import com.dee.spring.testing.basic.junit.InputData;

/**
 * @author dien.nguyen
 **/

public class CrawlerServiceJUnit4Test {
    
    private CrawlerService crawlerService;
    
    @Before
    public void startUp() {
        crawlerService = new EpisodeCrawlerService();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testCrawl() {
        crawlerService.crawl(new InputData("url1"));
        CrawledData data = crawlerService.getData();
        Assert.assertNotNull(data);
        Assert.assertEquals(1, data.getData().size());
        Assert.assertEquals("url1", data.getData().get(0));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalInputData() {
        crawlerService.crawl(new InputData());
    }
    
}
