package com.dee.spring.testing.basic1.dao;

import com.dee.spring.testing.basic1.Student;

/**
 * @author dien.nguyen
 **/

public interface StudentDao {

    Student findById(Long id);
    
    void insert(Student student);
    
    void update(Student student);
    
    void delete(Student student);
    
}
