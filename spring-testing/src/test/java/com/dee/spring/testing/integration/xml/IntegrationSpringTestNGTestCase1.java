package com.dee.spring.testing.integration.xml;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * @author dien.nguyen
 **/

@ContextConfiguration(locations = {"/spring/testing/integration/app-context.xml"})
public class IntegrationSpringTestNGTestCase1 extends AbstractTestNGSpringContextTests {

}
