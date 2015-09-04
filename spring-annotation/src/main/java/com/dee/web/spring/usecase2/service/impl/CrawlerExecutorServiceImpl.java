package com.dee.web.spring.usecase2.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dee.web.spring.usecase2.service.CrawlerExecutorService;
import com.dee.web.spring.usecase2.service.CrawlerService;

/**
 * @author dien.nguyen
 **/

@Service("crawlerExecutorService")
public class CrawlerExecutorServiceImpl implements CrawlerExecutorService {
    
    @Autowired
    private Map<String, CrawlerService> crawlerServicesMap;
    
    @Autowired
    private List<CrawlerService> crawlerServicesList;
    
    @Autowired
    private CrawlerService[] crawlerServicesArray;
    
    @Override
    public void executeWithMap() {
        for(Entry<String, CrawlerService> entry : crawlerServicesMap.entrySet()) {
            entry.getValue().crawl();
        }
    }

    @Override
    public void executeWithList() {
        for(CrawlerService crawlerService : crawlerServicesList) {
            crawlerService.crawl();
        }
    }

    @Override
    public void executeWithArray() {
        for(CrawlerService crawlerService : crawlerServicesArray) {
            crawlerService.crawl();
        }
    }

}
