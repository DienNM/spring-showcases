package com.dee.web.spring.usecase8;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import com.dee.web.spring.usecase8.event.NewCourseEvent;
import com.dee.web.spring.usecase8.model.Course;

/**
 * @author dien.nguyen
 */

public class CustomApplicationEventPublisherAware implements ApplicationEventPublisherAware {
    
    private ApplicationEventPublisher appEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher appEventPublisher) {
        this.appEventPublisher = appEventPublisher;
    }

    public void publishNewCourse(Course course) {
        appEventPublisher.publishEvent(new NewCourseEvent(course));
    }
    
}
