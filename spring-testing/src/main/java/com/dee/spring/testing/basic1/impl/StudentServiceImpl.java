package com.dee.spring.testing.basic1.impl;

import com.dee.spring.testing.basic1.Student;
import com.dee.spring.testing.basic1.StudentService;
import com.dee.spring.testing.basic1.dao.StudentDao;

/**
 * @author dien.nguyen
 **/

public class StudentServiceImpl implements StudentService{
    
    private StudentDao studentDao;
    
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student getById(Long id) {
        return studentDao.findById(id);
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
    public void remove(Long id) {
        Student student = studentDao.findById(id);
        if(student != null) {
            studentDao.delete(student);
        }
    }

    @Override
    public Student updateActive(Long id, boolean active) {
        Student student = studentDao.findById(id);
        student.setActive(active);
        studentDao.update(student);
        
        return student;
    }

}
