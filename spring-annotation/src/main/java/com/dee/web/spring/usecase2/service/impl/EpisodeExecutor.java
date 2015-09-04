package com.dee.web.spring.usecase2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dee.web.spring.usecase2.service.CrawlerService;

/**
 * @author dien.nguyen
 **/

@Service("episodeExecutor")
public class EpisodeExecutor {
    
    @Autowired
    @Qualifier("episodeCrawler")
    private CrawlerService crawlerService;
    
    public void execute() {
        crawlerService.crawl();
    }
    
}
