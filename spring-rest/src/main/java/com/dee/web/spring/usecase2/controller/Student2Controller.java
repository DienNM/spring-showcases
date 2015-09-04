package com.dee.web.spring.usecase2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dee.web.spring.usecase2.Course;
import com.dee.web.spring.usecase2.Student;
import com.dee.web.spring.usecase2.service.StudentService;

/**
 * @author dien.nguyen
 **/

@Controller
@RequestMapping(value = "/usecase2/students", produces = { "application/json"} )
public class Student2Controller {

    @Autowired
    @Qualifier("studentService2")
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getStudents() {
        List<Student> studentsList = studentService.getAll();
        return studentsList;
    }

    @RequestMapping(value = "/{studentId}", method = RequestMethod.GET)
    @ResponseBody
    public Student getStudent(@PathVariable(value = "studentId") Long studentId) {
        Student student = studentService.getStudent(studentId);
        return student;
    }
    
    @RequestMapping(value = "/{studentId}/courses", method = RequestMethod.GET)
    @ResponseBody
    public List<Course> getCoursesOfStudent(@PathVariable(value = "studentId") Long studentId) {
        Student student = studentService.getStudent(studentId);
        if(student == null) {
            return new ArrayList<Course>();
        }
        return student.getCourses();
    }
    
    @RequestMapping(value = "/{studentId}/courses/{courseSubject}", method = RequestMethod.GET)
    @ResponseBody
    public Course getCourseDetailOfStudent(@PathVariable(value = "studentId") Long studentId, 
            @PathVariable(value = "courseSubject") String courseSubject) {
        return studentService.getCourse(studentId, courseSubject);
    }
}
