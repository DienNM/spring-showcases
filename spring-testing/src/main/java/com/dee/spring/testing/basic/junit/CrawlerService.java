package com.dee.spring.testing.basic.junit;

/**
 * @author dien.nguyen
 **/

public interface CrawlerService {
    
    CrawledData getData();
    
    void crawl(InputData inputData);
    
}
