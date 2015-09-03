package com.dee.web.spring.usecase3;

/**
 * @author dien.nguyen
 **/

public class ThreadPoolConfig {
    
    private int initSize;
    
    private int maxSize;
    
    private String prefixName;
    
    private int idleSize;

    public int getInitSize() {
        return initSize;
    }

    public void setInitSize(int initSize) {
        this.initSize = initSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public String getPrefixName() {
        return prefixName;
    }

    public void setPrefixName(String prefixName) {
        this.prefixName = prefixName;
    }

    public int getIdleSize() {
        return idleSize;
    }

    public void setIdleSize(int idleSize) {
        this.idleSize = idleSize;
    }
    
}
