package com.dee.web.spring.jdbc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dee.web.spring.jdbc.dao.JDBCStudentDao;
import com.dee.web.spring.jdbc.model.JdbcStudent;
import com.dee.web.spring.jdbc.service.JDBCStudentService;

/**
 * @author dien.nguyen
 **/

@Service("jdbcStudentService")
public class JDBCStudentServiceImpl implements JDBCStudentService {

    private JDBCStudentDao studentDao;
    
    public void setStudentDao(JDBCStudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public JdbcStudent getById(int studentId) {
        return studentDao.findById(studentId);
    }
    
    @Override
    public int count() {
        return studentDao.count();
    }
    
    @Override
    public String getEmail(int id) {
        return studentDao.findEmail(id);
    }
    
    @Override
    public List<JdbcStudent> getAll() {
        return studentDao.findAll();
    }
    
    @Override
    public JdbcStudent getByEmail(String email) {
        return studentDao.findByEmail(email);
    }
    
    @Override
    public void save(JdbcStudent student) {
        studentDao.insert(student);
    }
    
    @Override
    public void save(List<JdbcStudent> students) {
        studentDao.insert(students);
    }

    @Override
    public void update(JdbcStudent student) {
        studentDao.update(student);
    }

    @Override
    public void delete(JdbcStudent student) {
        studentDao.delete(student);
    }

    @Override
    public void deleteAll() {
        studentDao.deleteAll();
    }

}
