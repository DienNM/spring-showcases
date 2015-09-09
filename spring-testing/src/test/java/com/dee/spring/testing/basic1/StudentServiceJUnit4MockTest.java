package com.dee.spring.testing.basic1;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import com.dee.spring.testing.basic1.dao.StudentDao;
import com.dee.spring.testing.basic1.impl.StudentServiceImpl;

/**
 * @author dien.nguyen
 **/

public class StudentServiceJUnit4MockTest {
    
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
        
        studentDao = mock(StudentDao.class);
        studentService = new StudentServiceImpl(studentDao);
    }
    
    @Test
    public void getById() {
        when(studentDao.findById(ID1)).thenReturn(student1);
        Student student = studentService.getById(ID1);
        
        Assert.assertEquals("nmdien61@gmail.com", student.getEmail());
    }
    
    @Test(expected = StudentNotFoundException.class)
    public void updateActiveIllegal() {
        when(studentDao.findById(ID1)).thenThrow(new StudentNotFoundException());
        studentService.updateActive(ID1, false);
    }
    
    @Test
    public void updateActive() {
        when(studentDao.findById(ID1)).thenReturn(student1);
        Student student = studentService.updateActive(ID1, false);
        Assert.assertFalse(student.isActive());
        
        verify(studentDao, times(1)).findById(anyLong());
        verify(studentDao, times(1)).findById(any(Long.class));
        verify(studentDao, times(1)).findById(ID1);
        verify(studentDao, times(1)).update(student);
    }
    
}
