package com.dee.web.spring.usecase1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dee.web.spring.usecase1.Student;
import com.dee.web.spring.usecase1.Students;
import com.dee.web.spring.usecase1.service.StudentService;

/**
 * @author dien.nguyen
 **/

@Controller
@RequestMapping(value = "/usecase1/students")
public class Student1Controller {
    
    @Autowired
    @Qualifier("studentService1")
    private StudentService studentService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String getStudents(Model model) {
        
        List<Student> studentsList = studentService.getAll();
        
        Students students = new Students();
        for(Student student : studentsList) {
            students.getStudents().add(student);
        }
        
        model.addAttribute("students", students);
        
        return "studentTemaplate";
    }
    
}
