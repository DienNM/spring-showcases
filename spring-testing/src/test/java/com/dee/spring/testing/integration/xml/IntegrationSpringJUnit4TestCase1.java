package com.dee.spring.testing.integration.xml;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * @author dien.nguyen
 **/

@ContextConfiguration(locations = {"/spring/testing/integration/app-context.xml"})
public class IntegrationSpringJUnit4TestCase1 extends AbstractJUnit4SpringContextTests {

}
