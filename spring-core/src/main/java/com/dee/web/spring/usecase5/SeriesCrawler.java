package com.dee.web.spring.usecase5;

/**
 * @author dien.nguyen
 **/

public class SeriesCrawler implements CrawlerService{

    @Override
    public String getType() {
        return "series";
    }

    @Override
    public String crawl() {
        return "Series Data";
    }

}
