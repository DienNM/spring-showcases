package com.dee.web.spring.usecase1.service;

import java.util.List;

import com.dee.web.spring.usecase1.Course;
import com.dee.web.spring.usecase1.Student;

/**
 * @author dien.nguyen
 **/

public interface StudentService {
    
    List<Student> getAll();
    
    Student getStudent(Long id);
    
    List<Course> getCourses(Long studentId);
    
    Course getCourse(Long studentId, String subject);
    
}
