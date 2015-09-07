package com.dee.web.spring.tx.service;

import java.util.List;

import com.dee.web.spring.tx.model.JdbcStudent;


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
