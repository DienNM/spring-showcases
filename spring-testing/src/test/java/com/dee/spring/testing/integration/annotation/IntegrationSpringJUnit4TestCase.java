package com.dee.spring.testing.integration.annotation;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dee.spring.testing.integration.AppConfiguration;

/**
 * @author dien.nguyen
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfiguration.class)
public class IntegrationSpringJUnit4TestCase {

}
