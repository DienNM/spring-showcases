package com.dee.web.spring.jdbc.dao;

import java.util.List;

import com.dee.web.spring.jdbc.model.JdbcStudent;

/**
 * @author dien.nguyen
 **/

public interface JdbcStudentDao {
    
    List<JdbcStudent> findAll();
    
    JdbcStudent findById(int studentId);
    
    void insert(JdbcStudent student);
    
    void update(JdbcStudent student);
    
    void deleteAll();
}
