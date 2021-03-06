package com.dee.spring.testing.basic1;

/**
 * @author dien.nguyen
 **/

public class Student {
    
    private long id;
    
    private String email;
    
    private boolean active;

    public Student() {
    }
    
    public Student(long id, String email) {
        this.id = id;
        this.email = email;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
}
