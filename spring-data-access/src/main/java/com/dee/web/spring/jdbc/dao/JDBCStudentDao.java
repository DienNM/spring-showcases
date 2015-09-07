package com.dee.web.spring.jdbc.dao;

import com.dee.web.spring.jdbc.model.JdbcStudent;

/**
 * @author dien.nguyen
 **/

public interface JDBCStudentDao {
    
    JdbcStudent findById(int studentId);
    
    void insert(JdbcStudent student);
    
    void updateWithPreparedStmCreator(JdbcStudent student);
    
    void updateWithPreparedStmSetter(JdbcStudent student);
    
    void delete(JdbcStudent student);
    
}
