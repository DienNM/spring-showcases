package com.dee.spring.testing.basic;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dee.spring.testing.basic.junit.CrawledData;
import com.dee.spring.testing.basic.junit.CrawlerService;
import com.dee.spring.testing.basic.junit.EpisodeCrawlerService;
import com.dee.spring.testing.basic.junit.InputData;

/**
 * @author dien.nguyen
 **/

public class CrawlerServiceTestNGTest {
    
    private CrawlerService crawlerService;
    
    @BeforeMethod
    public void startUp() {
        crawlerService = new EpisodeCrawlerService();
    }
    
    @DataProvider(name = "valid")
    public Object[][] createInputData() {
        return new Object[][] {
                new Object[] {new InputData("url1"), "url1"}, 
                new Object[] {new InputData("url2"), "url2"}};
    }

    @DataProvider(name = "illegal")
    public Object[][] createIllegalInputData() {
        return new Object[][] {new Object[] {new InputData()}};
    }
    
    @Test(dataProvider = "valid")
    public void testCrawl(InputData inputData, String result) {
        crawlerService.crawl(inputData);
        CrawledData data = crawlerService.getData();
        Assert.assertNotNull(data);
        Assert.assertEquals(1, data.getData().size());
        Assert.assertEquals(result, data.getData().get(0));
    }
    
    @Test(dataProvider = "illegal",
            expectedExceptions = {IllegalArgumentException.class})
    public void testIllegalInputData(InputData inputData) {
        crawlerService.crawl(inputData);
    }
    
}
