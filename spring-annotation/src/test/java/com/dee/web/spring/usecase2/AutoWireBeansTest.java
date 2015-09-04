package com.dee.web.spring.usecase2;

import junit.framework.TestCase;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dee.web.spring.usecase2.service.CrawlerExecutorService;
import com.dee.web.spring.usecase2.service.CrawlerService;
import com.dee.web.spring.usecase2.service.impl.EpisodeExecutor;
import com.dee.web.spring.usecase2.service.impl.PrimaryExecutor;
import com.dee.web.spring.usecase2.service.impl.SeriesExecutor;

/**
 * @author dien.nguyen
 **/

public class AutoWireBeansTest extends TestCase{
    
    private ApplicationContext appContext;
    
    @Override
    protected void setUp() throws Exception {
        appContext = new GenericXmlApplicationContext("/spring/usecase2/usecase2-app-context.xml");
    }
    
    public void testAutoWriteCollectionBeans() {
        CrawlerExecutorService executorService = appContext.getBean("crawlerExecutorService", CrawlerExecutorService.class);
        Assert.assertNotNull(executorService);
        executorService.executeWithMap();
        
        CrawlerService expisodeCrawler = appContext.getBean("episodeCrawler", CrawlerService.class);
        CrawlerService seriesCrawler = appContext.getBean("seriesCrawler", CrawlerService.class);
        Assert.assertNotNull(seriesCrawler);
        Assert.assertNotNull(expisodeCrawler);
        
        Assert.assertEquals("[Series Data]", seriesCrawler.collectCrawledData());
        Assert.assertEquals("Episode Data", expisodeCrawler.collectCrawledData());
        
        
        // Crawl Again
        executorService.executeWithList();
        Assert.assertEquals("[Series Data][Series Data]", seriesCrawler.collectCrawledData());
        Assert.assertEquals("Episode Data", expisodeCrawler.collectCrawledData());
        
        // Crawl Again
        executorService.executeWithArray();
        Assert.assertEquals("[Series Data][Series Data][Series Data]", seriesCrawler.collectCrawledData());
        Assert.assertEquals("Episode Data", expisodeCrawler.collectCrawledData());
    }
    
    public void testAutoWireSpecificBean() {
        EpisodeExecutor episodeExecutor = appContext.getBean("episodeExecutor", EpisodeExecutor.class);
        Assert.assertNotNull(episodeExecutor);
        
        // Episode Crawler crawls data
        episodeExecutor.execute();
        
        CrawlerService expisodeCrawler = appContext.getBean("episodeCrawler", CrawlerService.class);
        CrawlerService seriesCrawler = appContext.getBean("seriesCrawler", CrawlerService.class);
        Assert.assertNotNull(seriesCrawler);
        Assert.assertNotNull(expisodeCrawler);
        
        Assert.assertEquals("", seriesCrawler.collectCrawledData());
        Assert.assertEquals("Episode Data", expisodeCrawler.collectCrawledData());
        
        // Primary
        PrimaryExecutor primaryExecutor = appContext.getBean("primaryExecutor", PrimaryExecutor.class);
        Assert.assertNotNull(primaryExecutor);
        
        // Series Crawler crawls data
        primaryExecutor.execute();
        
        Assert.assertEquals("[Series Data]", seriesCrawler.collectCrawledData());
        Assert.assertEquals("Episode Data", expisodeCrawler.collectCrawledData());
        
        
        // Series Executor
        SeriesExecutor seriesExecutor = appContext.getBean("seriesExecutor", SeriesExecutor.class);
        Assert.assertNotNull(seriesExecutor);
        seriesExecutor.execute();
        Assert.assertEquals("[Series Data][Series Data]", seriesCrawler.collectCrawledData());
        Assert.assertEquals("Episode Data", expisodeCrawler.collectCrawledData());
    }
    
}
