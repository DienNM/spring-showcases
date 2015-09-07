package com.dee.web.spring.jdbc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dee.web.spring.jdbc.dao.JDBCStudentDao;
import com.dee.web.spring.jdbc.model.JdbcStudent;
import com.dee.web.spring.jdbc.service.JDBCStudentService;

/**
 * @author dien.nguyen
 **/

@Service("jdbcStudentService")
public class JDBCStudentServiceImpl implements JDBCStudentService {

    @Autowired
    @Qualifier("jdbcStudentDao")
    private JDBCStudentDao studentDao;

    @Override
    public JdbcStudent getById(int studentId) {
        return studentDao.findById(studentId);
    }

    @Override
    public void save(JdbcStudent student) {
        studentDao.insert(student);
    }

    @Override
    public void update(JdbcStudent student) {
        studentDao.updateWithPreparedStmCreator(student);
    }

    @Override
    public void delete(JdbcStudent student) {
        studentDao.delete(student);
    }

    @Override
    public void update2(JdbcStudent student) {
        studentDao.updateWithPreparedStmSetter(student);
    }
}
