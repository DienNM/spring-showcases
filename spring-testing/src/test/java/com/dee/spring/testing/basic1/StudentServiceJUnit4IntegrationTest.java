package com.dee.spring.testing.basic1;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dee.spring.testing.basic1.DuplicateStudentException;
import com.dee.spring.testing.basic1.Student;
import com.dee.spring.testing.basic1.StudentNotFoundException;
import com.dee.spring.testing.basic1.dao.StudentDao;
import com.dee.spring.testing.basic1.dao.impl.InMemoryStudentDao;
import com.dee.spring.testing.basic1.impl.StudentServiceImpl;

/**
 * @author dien.nguyen
 **/

public class StudentServiceJUnit4IntegrationTest {
    
    private final static long ID1 = 1;
    private final static long ID2 = 2;
    private final static long NOT_FOUND = 3;
    
    private StudentDao studentDao;
    private StudentService studentService;
    
    private Student student1;
    private Student student2;
    
    @Before
    public void startUp() {
        student1 = new Student();
        student1.setId(ID1);
        student1.setEmail("nmdien61@gmail.com");
        student1.setActive(true);
        
        student2 = new Student();
        student2.setId(ID2);
        student2.setEmail("nguyenminhdien1506@gmail.com");
        student2.setActive(true);
        
        studentDao = new InMemoryStudentDao();
        studentService = new StudentServiceImpl(studentDao);
    }
    
    @After
    public void tearDao() {
        studentService.remove(ID1);
        studentService.remove(ID2);
    }
    
    @Test
    public void insert() {
        studentService.save(student1);
        Assert.assertEquals("nmdien61@gmail.com", studentService.getById(ID1).getEmail());
        
        studentService.save(student2);
        Assert.assertEquals("nguyenminhdien1506@gmail.com", studentService.getById(ID2).getEmail());
    }
    
    @Test(expected = DuplicateStudentException.class)
    public void insertDuplicated() {
        studentService.save(student1);
        Assert.assertEquals("nmdien61@gmail.com", studentService.getById(ID1).getEmail());
        
        studentService.save(student1);
    }
    
    @Test
    public void update() {
        studentService.save(student1);
        Student pStudent = studentService.getById(ID1);
        Assert.assertEquals("nmdien61@gmail.com", pStudent.getEmail());
        
        pStudent.setEmail("nmdien@gmail.com");
        studentService.update(pStudent);
        pStudent = studentService.getById(ID1);
        Assert.assertEquals("nmdien@gmail.com", pStudent.getEmail());
    }

    @Test(expected = StudentNotFoundException.class)
    public void updateNotFound() {
        studentService.save(student1);
        Assert.assertEquals("nmdien61@gmail.com", studentService.getById(ID1).getEmail());
        studentService.update(student2);
    }
    
    @Test
    public void findById() {
        studentService.save(student1);
        Assert.assertEquals("nmdien61@gmail.com", studentService.getById(ID1).getEmail());
        Assert.assertNull(studentService.getById(NOT_FOUND));
    }
    
}
