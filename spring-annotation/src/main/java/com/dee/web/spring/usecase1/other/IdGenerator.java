package com.dee.web.spring.usecase1.other;

import java.util.Random;

import org.springframework.stereotype.Component;

/**
 * @author dien.nguyen
 **/

@Component("idGenerator")
public class IdGenerator {
    
    public String generate() {
        return String.valueOf(new Random().nextInt());
    }
    
}
