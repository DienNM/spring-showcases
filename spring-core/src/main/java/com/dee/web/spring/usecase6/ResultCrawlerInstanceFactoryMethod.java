package com.dee.web.spring.usecase6;

import java.util.Map;

/**
 * @author dien.nguyen
 **/

public class ResultCrawlerInstanceFactoryMethod {
    
    private Map<String, CrawlerResult> crawlerResults;

    public Map<String, CrawlerResult> getCrawlerResults() {
        return crawlerResults;
    }

    public void setCrawlerResults(Map<String, CrawlerResult> crawlerResults) {
        this.crawlerResults = crawlerResults;
    }
    
    public CrawlerResult createCrawlerResult(String type) {
        return crawlerResults.get(type);
    }
    
}
