package com.dee.web.spring.jdbc1;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dee.web.spring.jdbc1.model.JdbcStudent;
import com.dee.web.spring.jdbc1.service.JdbcStudentService;

import junit.framework.TestCase;

/**
 * @author dien.nguyen
 **/

public class JdbcDaoTest extends TestCase{
    
    ApplicationContext appCtx;
    
    private JdbcStudentService jdbcStudentService;
    
    @Override
    protected void setUp() throws Exception {
        appCtx = new GenericXmlApplicationContext("/spring/jdbc1/app-context.xml");
        jdbcStudentService = appCtx.getBean("jdbcStudentService", JdbcStudentService.class);
    }
    
    @Override
    protected void tearDown() throws Exception {
        jdbcStudentService.deleteAll();
    }
    
    private JdbcStudent createJdbcStudent1() {
        JdbcStudent student = new JdbcStudent();
        student.setId(1);
        student.setEmail("nmdien61@gmail.com");
        student.setName("Dien Nguyen");
        return student;
    }
    
    private JdbcStudent createJdbcStudent2() {
        JdbcStudent student = new JdbcStudent();
        student.setId(2);
        student.setEmail("nguyenminhdien1506@gmail.com");
        student.setName("DEE");
        return student;
    }
    
    public void testAppliedTransaction() {
        jdbcStudentService.save(createJdbcStudent1());
        Assert.assertEquals(1, jdbcStudentService.getAll().size());
        
        jdbcStudentService.save(createJdbcStudent2());
        Assert.assertEquals(2, jdbcStudentService.getAll().size());
        
        JdbcStudent pStudent = jdbcStudentService.getById(1);
        Assert.assertNotNull(pStudent);
        Assert.assertEquals("nmdien61@gmail.com", pStudent.getEmail());
        Assert.assertEquals("Dien Nguyen", pStudent.getName());
        
        
        // Update
        pStudent.setName("DEE1");
        jdbcStudentService.update(pStudent);
        
        pStudent = jdbcStudentService.getById(1);
        Assert.assertNotNull(pStudent);
        Assert.assertEquals("nmdien61@gmail.com", pStudent.getEmail());
        Assert.assertEquals("DEE1", pStudent.getName());
    }
}
