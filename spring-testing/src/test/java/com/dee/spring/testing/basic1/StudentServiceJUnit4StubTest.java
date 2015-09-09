package com.dee.spring.testing.basic1;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dee.spring.testing.basic1.dao.StudentDao;
import com.dee.spring.testing.basic1.impl.StudentServiceImpl;

/**
 * @author dien.nguyen
 **/

public class StudentServiceJUnit4StubTest {
    
    private final static long ID1 = 1;
    
    private StudentDao studentDao;
    private StudentService studentService;
    
    private Student student1;
    
    @Before
    public void startUp() {
        student1 = new Student();
        student1.setId(ID1);
        student1.setEmail("nmdien61@gmail.com");
        student1.setActive(true);
        
        studentDao = new StudentStubDao();
        studentService = new StudentServiceImpl(studentDao);
    }
    
    private class StudentStubDao implements StudentDao {

        @Override
        public Student findById(Long id) {
            return student1;
        }

        @Override
        public void insert(Student student) {}

        @Override
        public void update(Student student) {}

        @Override
        public void delete(Student student) {}
    }
    
    @Test
    public void updateActive() {
        Student student = studentService.updateActive(ID1, false);
        Assert.assertEquals(false, student.isActive());
    }
    
}
