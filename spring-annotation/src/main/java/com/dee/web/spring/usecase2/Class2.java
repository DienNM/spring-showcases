package com.dee.web.spring.usecase2;

/**
 * @author dien.nguyen
 **/

public class Class2 {
    
    private String name;
    
    private Class1 class1;
    
    private Class3 class3;
    
    public Class2() {
    }
    
    public Class2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class1 getClass1() {
        return class1;
    }

    public void setClass1(Class1 class1) {
        this.class1 = class1;
    }

    public Class3 getClass3() {
        return class3;
    }

    public void setClass3(Class3 class3) {
        this.class3 = class3;
    }
    
}
