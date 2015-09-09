package com.dee.spring.testing.mvc;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author dien.nguyen
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebAppConfiguration.class)
public abstract class MvcSpringJUnit4Test {
    
    
}
