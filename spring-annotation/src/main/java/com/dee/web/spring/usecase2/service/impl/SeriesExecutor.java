package com.dee.web.spring.usecase2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dee.web.spring.usecase2.service.CrawlerService;

/**
 * @author dien.nguyen
 **/

@Service("seriesExecutor")
public class SeriesExecutor {
    
    private CrawlerService crawlerService;
    
    @Autowired
    public SeriesExecutor(@Qualifier("seriesCrawler") CrawlerService crawlerService) {
        this.crawlerService = crawlerService;
    }
    
    public void execute() {
        this.crawlerService.crawl();
    }
    
}
