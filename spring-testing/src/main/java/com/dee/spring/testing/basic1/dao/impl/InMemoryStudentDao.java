package com.dee.spring.testing.basic1.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.dee.spring.testing.basic1.DuplicateStudentException;
import com.dee.spring.testing.basic1.Student;
import com.dee.spring.testing.basic1.StudentNotFoundException;
import com.dee.spring.testing.basic1.dao.StudentDao;

/**
 * @author dien.nguyen
 **/

public class InMemoryStudentDao implements StudentDao {

    private Map<Long, Student> students = new HashMap<Long, Student>();

    @Override
    public Student findById(Long id) {
        return students.get(id);
    }

    @Override
    public void insert(Student student) {
        if(students.containsKey(student.getId())) {
            throw new DuplicateStudentException();
        }
        students.put(student.getId(), student); 
    }

    @Override
    public void update(Student student) {
        if (!students.containsKey(student.getId())) {
            throw new StudentNotFoundException();
        }
        students.put(student.getId(), student);
    }

    @Override
    public void delete(Student student) {
        students.remove(student.getId());
    }

}
