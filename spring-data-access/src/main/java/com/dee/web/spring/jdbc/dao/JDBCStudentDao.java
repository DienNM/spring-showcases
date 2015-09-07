package com.dee.web.spring.jdbc.dao;

import java.util.List;

import com.dee.web.spring.jdbc.model.JdbcStudent;

/**
 * @author dien.nguyen
 **/

public interface JDBCStudentDao {
    
    int count();
    
    String findEmail(int id);
    
    List<JdbcStudent> findAll();
    
    JdbcStudent findById(int studentId);
    
    JdbcStudent findByEmail(String email);
    
    void insert(JdbcStudent student);
    
    void insert(List<JdbcStudent> students);
    
    void update(JdbcStudent student);
    
    void delete(JdbcStudent student);
    
    void deleteAll();
    
}
