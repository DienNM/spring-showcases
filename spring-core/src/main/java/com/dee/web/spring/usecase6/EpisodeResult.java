package com.dee.web.spring.usecase6;

/**
 * @author dien.nguyen
 **/

public class EpisodeResult extends CrawlerResult {
    
    private String data;
    
    public EpisodeResult() {
        this.data = "Episode Data";
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
}
