package com.dee.web.spring.usecase5;

/**
 * @author dien.nguyen
 **/

public class EpisodeCrawler implements CrawlerService {

    @Override
    public String getType() {
        return "episode";
    }

    @Override
    public String crawl() {
        return "Episode Data";
    }

}
