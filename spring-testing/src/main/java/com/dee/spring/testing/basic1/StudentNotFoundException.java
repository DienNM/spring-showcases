package com.dee.spring.testing.basic1;

/**
 * @author dien.nguyen
 **/

public class StudentNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public StudentNotFoundException() {
    }
    
    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(Throwable t) {
        super(t);
    }

}
