package com.dee.web.spring.usecase2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dee.web.spring.usecase2.service.CrawlerService;

/**
 * @author dien.nguyen
 **/

@Service("primaryExecutor")
public class PrimaryExecutor {
    
    @Autowired
    // Automatically auto-wire primary
    private CrawlerService crawlerService;
    
    public void execute() {
        crawlerService.crawl();
    }
    
}
