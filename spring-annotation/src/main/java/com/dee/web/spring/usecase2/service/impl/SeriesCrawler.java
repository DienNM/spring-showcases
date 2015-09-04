package com.dee.web.spring.usecase2.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dee.web.spring.usecase2.service.CrawlerService;

/**
 * @author dien.nguyen
 **/

@Service("seriesCrawler")
@Primary
public class SeriesCrawler implements CrawlerService {
    
    private List<String> datas = new ArrayList<String>();
    
    @Override
    public void crawl() {
        datas.add("[Series Data]");
    }

    @Override
    public String collectCrawledData() {
        StringBuilder sbr = new StringBuilder();
        for(String data : datas) {
            sbr.append(data);
        }
        return sbr.toString();
    }

}
