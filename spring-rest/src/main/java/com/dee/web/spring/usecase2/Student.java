package com.dee.web.spring.usecase2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dien.nguyen
 **/

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

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
