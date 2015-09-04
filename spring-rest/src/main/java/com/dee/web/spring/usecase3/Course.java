package com.dee.web.spring.usecase3;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author dien.nguyen
 **/

@XmlRootElement
public class Course {
    
    private String subject;
    
    private int length;
    
    private Date startDate;
    
    public Course() {
    }
    
    public Course(String subject, int length) {
        this.subject = subject;
        this.length = length;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
}
