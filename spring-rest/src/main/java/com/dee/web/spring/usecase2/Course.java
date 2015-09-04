package com.dee.web.spring.usecase2;

import java.io.Serializable;


/**
 * @author dien.nguyen
 **/

public class Course implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String subject;
    
    private int length;
    
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
    
}
