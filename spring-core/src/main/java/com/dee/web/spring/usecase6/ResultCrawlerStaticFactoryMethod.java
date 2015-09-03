package com.dee.web.spring.usecase6;


/**
 * @author dien.nguyen
 **/

public class ResultCrawlerStaticFactoryMethod {

    public static CrawlerResult createCrawlerData(String type) {
        if ("episode".equals(type)) {
            return new EpisodeResult();
        } else if ("series".equals(type)) {
            return new SeriesResult();
        }
        return null;
    }
}
