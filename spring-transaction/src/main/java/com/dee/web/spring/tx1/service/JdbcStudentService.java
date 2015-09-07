package com.dee.web.spring.tx1.service;

import java.util.List;

import com.dee.web.spring.tx1.model.JdbcStudent;


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
