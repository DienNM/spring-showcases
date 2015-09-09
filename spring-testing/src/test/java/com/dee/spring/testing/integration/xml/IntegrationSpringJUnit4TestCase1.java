package com.dee.spring.testing.integration.xml;

import org.junit.BeforeClass;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.dee.spring.testing.integration.xml.case1.ProductServiceJUnit4Test;

/**
 * @author dien.nguyen
 **/

@ContextConfiguration(locations = {"/spring/testing/integration/app-context.xml"})
public class IntegrationSpringJUnit4TestCase1 extends AbstractJUnit4SpringContextTests {

    
    @BeforeClass
    public static void initClass() {
        System.out.println("=========================================");
        System.out.println(ProductServiceJUnit4Test.class);
        System.out.println("=========================================");
    }
    
}
