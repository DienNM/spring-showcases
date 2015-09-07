package com.dee.web.spring.jdbc.service;

import com.dee.web.spring.jdbc.model.JdbcStudent;

/**
 * @author dien.nguyen
 **/

public interface JDBCStudentService {
    
    JdbcStudent getById(int studentId);
    
    void save(JdbcStudent student);
    
    void update(JdbcStudent student);
    
    void delete(JdbcStudent student);
    
}
