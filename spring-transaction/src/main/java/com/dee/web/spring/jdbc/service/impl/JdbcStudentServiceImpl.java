package com.dee.web.spring.jdbc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dee.web.spring.jdbc.dao.JdbcStudentDao;
import com.dee.web.spring.jdbc.model.JdbcStudent;
import com.dee.web.spring.jdbc.service.JdbcStudentService;

/**
 * @author dien.nguyen
 **/

@Service("jdbcStudentService")
public class JdbcStudentServiceImpl implements JdbcStudentService {
    
    @Autowired
    @Qualifier("jdbcStudentDao")
    private JdbcStudentDao jdbcStudentDao;
    
    @Override
    public JdbcStudent getById(int studentId) {
        return jdbcStudentDao.findById(studentId);
    }

    @Override
    public List<JdbcStudent> getAll() {
        return jdbcStudentDao.findAll();
    }

    @Override
    public void save(JdbcStudent student) {
        jdbcStudentDao.insert(student);
    }

    @Override
    public void update(JdbcStudent student) {
        jdbcStudentDao.update(student);
    }

    @Override
    public void deleteAll() {
        jdbcStudentDao.deleteAll();
    }

}
