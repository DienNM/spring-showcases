package com.dee.web.spring.usecase1;


/**
 * @author dien.nguyen
 **/

public class IdGenerator {
    
    private int increment;
    private long nextId;
    
    public IdGenerator(long initial, int increment) {
        this.increment = increment;
        this.nextId = initial;
    }
    
    public synchronized long generate() {
        nextId = nextId + increment;
        return nextId;
    }
    
    public int getIncrement() {
        return increment;
    }

    public void setIncrement(int increment) {
        this.increment = increment;
    }

    public long getNextId() {
        return nextId;
    }

    public void setNextId(long nextId) {
        this.nextId = nextId;
    }
    
}
