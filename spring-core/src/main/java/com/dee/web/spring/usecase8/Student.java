package com.dee.web.spring.usecase8;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationListener;

import com.dee.web.spring.usecase8.event.NewCourseEvent;
import com.dee.web.spring.usecase8.model.Course;

/**
 * @author dien.nguyen
 */

public class Student implements ApplicationListener<NewCourseEvent>{
    
    private String name;
    
    public List<Course> courses = new ArrayList<Course>();
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public void onApplicationEvent(NewCourseEvent courseEvent) {
        System.out.println(String.format("Student: %s registed new course: %s [length=%d]", name, 
                courseEvent.getCourse().getName(), courseEvent.getCourse().getLength()));
        courses.add(courseEvent.getCourse());
    }
    
}
