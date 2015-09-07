package com.dee.web.spring.jdbc.service;

import java.util.List;

import com.dee.web.spring.jdbc.model.JdbcStudent;

/**
 * @author dien.nguyen
 **/

public interface JdbcStudentService {
    
    JdbcStudent getById(int studentId);
    
    List<JdbcStudent> getAll();
    
    void save(JdbcStudent student);
    
    void update(JdbcStudent student);

    void deleteAll();
    
}
