package com.dee.web.spring.usecase1;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author dien.nguyen
 **/

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    
    private Long id;
    
    private String name;
    
    @XmlElement(name = "course")
    private List<Course> courses;
    
    public Student() {
        this(null);
    }
    
    public Student(String name) {
        this.name = name;
        courses = new ArrayList<Course>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
