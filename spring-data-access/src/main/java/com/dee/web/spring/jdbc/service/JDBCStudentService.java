package com.dee.web.spring.jdbc.service;

import java.util.List;

import com.dee.web.spring.jdbc.dao.JDBCStudentDao;
import com.dee.web.spring.jdbc.model.JdbcStudent;

/**
 * @author dien.nguyen
 **/

public interface JDBCStudentService {
    
    void setStudentDao(JDBCStudentDao studentDao);
    
    JdbcStudent getById(int studentId);
    
    JdbcStudent getByEmail(String email);
    
    int count();
    
    String getEmail(int id);
    
    List<JdbcStudent> getAll();
    
    void save(JdbcStudent student);
    
    void save(List<JdbcStudent> students);
    
    void update(JdbcStudent student);

    void delete(JdbcStudent student);
    
    void deleteAll();
    
}
