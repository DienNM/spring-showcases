package com.dee.spring.testing.basic1.dao;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dee.spring.testing.basic1.DuplicateStudentException;
import com.dee.spring.testing.basic1.Student;
import com.dee.spring.testing.basic1.StudentNotFoundException;
import com.dee.spring.testing.basic1.dao.StudentDao;
import com.dee.spring.testing.basic1.dao.impl.InMemoryStudentDao;

/**
 * @author dien.nguyen
 **/

public class StudentDaoTestNGTest {
    
    private final static long ID1 = 1;
    private final static long ID2 = 2;
    private final static long NOT_FOUND = 3;
    
    private StudentDao studentDao;
    
    private Student student1;
    private Student student2;
    
    @BeforeMethod
    public void startUp() {
        student1 = new Student();
        student1.setId(ID1);
        student1.setEmail("nmdien61@gmail.com");
        
        student2 = new Student();
        student2.setId(ID2);
        student2.setEmail("nguyenminhdien1506@gmail.com");
        
        studentDao = new InMemoryStudentDao();
    }
    
    @AfterMethod
    public void tearDao() {
        studentDao.delete(student1);
        studentDao.delete(student2);
    }
    
    @Test
    public void insert() {
        studentDao.insert(student1);
        Assert.assertEquals("nmdien61@gmail.com", studentDao.findById(ID1).getEmail());
        
        studentDao.insert(student2);
        Assert.assertEquals("nguyenminhdien1506@gmail.com", studentDao.findById(ID2).getEmail());
    }
    
    @Test(expectedExceptions = DuplicateStudentException.class)
    public void insertDuplicated() {
        studentDao.insert(student1);
        Assert.assertEquals("nmdien61@gmail.com", studentDao.findById(ID1).getEmail());
        
        studentDao.insert(student1);
    }
    
    @Test
    public void update() {
        studentDao.insert(student1);
        Student pStudent = studentDao.findById(ID1);
        Assert.assertEquals("nmdien61@gmail.com", pStudent.getEmail());
        
        pStudent.setEmail("nmdien@gmail.com");
        studentDao.update(pStudent);
        pStudent = studentDao.findById(ID1);
        Assert.assertEquals("nmdien@gmail.com", pStudent.getEmail());
    }

    @Test(expectedExceptions = StudentNotFoundException.class)
    public void updateNotFound() {
        studentDao.insert(student1);
        Assert.assertEquals("nmdien61@gmail.com", studentDao.findById(ID1).getEmail());
        studentDao.update(student2);
    }
    
    @Test
    public void findById() {
        studentDao.insert(student1);
        Assert.assertEquals("nmdien61@gmail.com", studentDao.findById(ID1).getEmail());
        Assert.assertNull(studentDao.findById(NOT_FOUND));
    }
    
}
