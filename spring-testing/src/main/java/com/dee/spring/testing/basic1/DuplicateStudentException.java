package com.dee.spring.testing.basic1;

/**
 * @author dien.nguyen
 **/

public class DuplicateStudentException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public DuplicateStudentException() {
    }
    
    public DuplicateStudentException(String message) {
        super(message);
    }

    public DuplicateStudentException(Throwable t) {
        super(t);
    }

}
