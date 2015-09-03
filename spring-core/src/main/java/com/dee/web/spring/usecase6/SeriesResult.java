package com.dee.web.spring.usecase6;

/**
 * @author dien.nguyen
 **/

public class SeriesResult extends CrawlerResult {
    
    private String data;

    public SeriesResult() {
        this.data = "Series Data";
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
