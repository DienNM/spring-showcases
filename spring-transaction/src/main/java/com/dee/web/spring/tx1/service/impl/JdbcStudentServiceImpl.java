package com.dee.web.spring.tx1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dee.web.spring.tx1.dao.JdbcStudentDao;
import com.dee.web.spring.tx1.model.JdbcStudent;
import com.dee.web.spring.tx1.service.JdbcStudentService;


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
    @Transactional
    public void save(JdbcStudent student) {
        jdbcStudentDao.insert(student);
    }

    @Override
    @Transactional
    public void update(JdbcStudent student) {
        jdbcStudentDao.update(student);
    }

    @Override
    @Transactional
    public void deleteAll() {
        jdbcStudentDao.deleteAll();
    }

}
