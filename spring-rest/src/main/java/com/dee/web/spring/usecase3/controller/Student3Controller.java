package com.dee.web.spring.usecase3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dee.web.spring.usecase3.Student;
import com.dee.web.spring.usecase3.Students;
import com.dee.web.spring.usecase3.service.StudentService;

/**
 * @author dien.nguyen
 **/

@Controller
@RequestMapping(value = "/usecase3/students")
public class Student3Controller {
    
    @Autowired
    @Qualifier("studentService3")
    private StudentService studentService;
    
    @RequestMapping(method = RequestMethod.GET, produces = {"application/xml"})
    @ResponseBody
    public Students getStudents() {
        List<Student> studentsList = studentService.getAll();
        
        Students students = new Students();
        for(Student student : studentsList) {
            students.getStudents().add(student);
        }
        
        return students;
    }
    
}
