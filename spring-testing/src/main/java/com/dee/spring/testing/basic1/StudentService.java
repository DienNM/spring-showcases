package com.dee.spring.testing.basic1;

/**
 * @author dien.nguyen
 **/

public interface StudentService {
    
    Student getById(Long id);
    
    void save(Student student);
    
    void update(Student student);
    
    void remove(Student student);
    
}
