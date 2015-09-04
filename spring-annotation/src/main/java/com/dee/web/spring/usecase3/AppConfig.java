package com.dee.web.spring.usecase3;

/**
 * @author dien.nguyen
 **/

public class AppConfig {
    
    private String version;
    
    private String name;
    
    private int priority;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    
}
