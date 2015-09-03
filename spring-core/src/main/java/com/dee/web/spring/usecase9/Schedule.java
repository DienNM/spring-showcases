package com.dee.web.spring.usecase9;

import java.util.Date;

/**
 * @author dien.nguyen
 */

public class Schedule {
    
    private String name;
    
    private Date startDate;
    
    private Date endDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
}
