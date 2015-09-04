package com.dee.web.spring.usecase2;

/**
 * @author dien.nguyen
 **/

public class Class4 {
    
    private String name;
    
    private Class2 class2;
    
    public Class4() {
    }
    
    public Class4(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class2 getClass2() {
        return class2;
    }

    public void setClass2(Class2 class2) {
        this.class2 = class2;
    }
    
    
}
