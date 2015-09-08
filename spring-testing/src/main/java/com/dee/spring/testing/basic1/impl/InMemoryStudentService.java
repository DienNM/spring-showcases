package com.dee.spring.testing.basic1.impl;

import com.dee.spring.testing.basic1.Student;
import com.dee.spring.testing.basic1.StudentService;
import com.dee.spring.testing.basic1.dao.StudentDao;

/**
 * @author dien.nguyen
 **/

public class InMemoryStudentService implements StudentService{
    
    private StudentDao studentDao;
    
    public InMemoryStudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student getById(Long id) {
        return null;
    }

    @Override
    public void save(Student student) {
        studentDao.insert(student);
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    public void remove(Student student) {
        studentDao.delete(student);
    }

}
