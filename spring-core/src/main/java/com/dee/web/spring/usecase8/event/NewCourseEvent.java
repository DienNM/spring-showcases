package com.dee.web.spring.usecase8.event;

import org.springframework.context.ApplicationEvent;

import com.dee.web.spring.usecase8.model.Course;

/**
 * @author dien.nguyen
 */

public class NewCourseEvent extends ApplicationEvent{

    private static final long serialVersionUID = 1L;

    private Course course;
    
    public NewCourseEvent(Course course) {
        super(course);
        this.setCourse(course);
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
