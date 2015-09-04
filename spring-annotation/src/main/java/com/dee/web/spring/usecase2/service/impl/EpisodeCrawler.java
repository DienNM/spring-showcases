package com.dee.web.spring.usecase2.service.impl;

import org.springframework.stereotype.Service;

import com.dee.web.spring.usecase2.service.CrawlerService;

/**
 * @author dien.nguyen
 **/

@Service("episodeCrawler")
public class EpisodeCrawler implements CrawlerService {
    
    private String episode;
    
    @Override
    public void crawl() {
        episode = "Episode Data";
    }

    @Override
    public String collectCrawledData() {
        return episode;
    }

}
