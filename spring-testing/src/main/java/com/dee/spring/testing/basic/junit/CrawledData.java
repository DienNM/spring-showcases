package com.dee.spring.testing.basic.junit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dien.nguyen
 **/

public class CrawledData {
    
    private List<String> data = new ArrayList<String>();
    private boolean success;
    
    public List<String> getData() {
        return data;
    }
    public void setData(List<String> data) {
        this.data = data;
    }
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    
}
