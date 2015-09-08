package com.dee.spring.testing.basic.junit;

/**
 * @author dien.nguyen
 **/

public class EpisodeCrawlerService implements CrawlerService{
    
    private CrawledData data;

    @Override
    public CrawledData getData() {
        return data;
    }

    @Override
    public void crawl(InputData inputData) {
        if(inputData.getUrl() == null) {
            throw new IllegalArgumentException("URL must be passed for crawling");
        }
        data = new CrawledData();
        data.setSuccess(true);
        data.getData().add(inputData.getUrl());
    }

}
