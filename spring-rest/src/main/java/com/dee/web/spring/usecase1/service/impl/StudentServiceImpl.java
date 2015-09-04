package com.dee.web.spring.usecase1.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.dee.web.spring.usecase1.Course;
import com.dee.web.spring.usecase1.Student;
import com.dee.web.spring.usecase1.service.StudentService;

/**
 * @author dien.nguyen
 **/

@Service("studentService1")
public class StudentServiceImpl implements StudentService {

    private Map<Long, Student> students = new HashMap<Long, Student>();

    @PostConstruct
    public void initData() {
        Course course1 = new Course("course1", 5);
        Course course2 = new Course("course2", 10);
        Course course3 = new Course("course3", 12);
        Course course4 = new Course("course4", 7);
        Course course5 = new Course("course5", 2);
        Course course6 = new Course("course6", 10);

        Student student1 = new Student("Student 1");
        student1.setId(1L);
        student1.getCourses().add(course1);
        student1.getCourses().add(course2);
        student1.getCourses().add(course3);

        Student student2 = new Student("Student 2");
        student2.setId(2L);
        student2.getCourses().add(course3);
        student2.getCourses().add(course4);
        student2.getCourses().add(course5);

        Student student3 = new Student("Student 3");
        student3.setId(3L);
        student3.getCourses().add(course5);
        student3.getCourses().add(course6);

        students.put(student1.getId(), student1);
        students.put(student2.getId(), student2);
        students.put(student3.getId(), student3);
    }

    @Override
    public List<Student> getAll() {
        return new ArrayList<Student>(students.values());
    }

    @Override
    public Student getStudent(Long id) {
        return students.get(id);
    }

    @Override
    public List<Course> getCourses(Long studentId) {
        Student student = students.get(studentId);
        if (student == null) {
            return new ArrayList<Course>();
        }
        return student.getCourses();
    }

    @Override
    public Course getCourse(Long studentId, String subject) {
        Student student = students.get(studentId);
        if (student == null) {
            return null;
        }

        for (Course course : student.getCourses()) {
            if (course.getSubject().equals(subject)) {
                return course;
            }
        }

        return null;
    }

}
