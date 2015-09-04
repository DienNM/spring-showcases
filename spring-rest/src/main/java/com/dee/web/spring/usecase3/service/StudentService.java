package com.dee.web.spring.usecase3.service;

import java.util.List;

import com.dee.web.spring.usecase3.Course;
import com.dee.web.spring.usecase3.Student;

/**
 * @author dien.nguyen
 **/

public interface StudentService {
    
    List<Student> getAll();
    
    Student getStudent(Long id);
    
    List<Course> getCourses(Long studentId);
    
    Course getCourse(Long studentId, String subject);
    
}
