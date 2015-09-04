package com.dee.web.spring.usecase4.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dee.web.spring.usecase4.Course;
import com.dee.web.spring.usecase4.Student;
import com.dee.web.spring.usecase4.service.StudentService;

/**
 * @author dien.nguyen
 **/

@RestController
@RequestMapping(value = "/usecase5/students", produces = { "application/json"} )
public class Student5Controller {

    @Autowired
    @Qualifier("studentService4")
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Student> getStudents() {
        return studentService.getAll();
    }

    @RequestMapping(value = "/{studentId}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudent(@PathVariable(value = "studentId") Long studentId) {
        Student student = studentService.getStudent(studentId);
        ResponseEntity<Student> responseEntity = null;
        if(student == null) {
            responseEntity = new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        } else {
            responseEntity = new ResponseEntity<Student>(student, HttpStatus.OK);
        }
        return responseEntity;
    }
    
    @RequestMapping(value = "/{studentId}/courses", method = RequestMethod.GET)
    public List<Course> getCoursesOfStudent(@PathVariable(value = "studentId") Long studentId) {
        Student student = studentService.getStudent(studentId);
        if(student == null) {
            return new ArrayList<Course>();
        }
        return student.getCourses();
    }
    
    @RequestMapping(value = "/{studentId}/courses/{courseSubject}", method = RequestMethod.GET)
    public Course getCourseDetailOfStudent(@PathVariable(value = "studentId") Long studentId, 
            @PathVariable(value = "courseSubject") String courseSubject) {
        return studentService.getCourse(studentId, courseSubject);
    }
}
