package com.dee.web.spring.jdbc;

import junit.framework.TestCase;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dee.web.spring.jdbc.model.JdbcStudent;
import com.dee.web.spring.jdbc.service.JDBCStudentService;

/**
 * @author dien.nguyen
 **/

public class SpringJdbc1Test extends TestCase {

    ApplicationContext appCtx;

    private JDBCStudentService studentService;

    @Override
    protected void setUp() throws Exception {
        appCtx = new GenericXmlApplicationContext("/spring/jdbc/nonconnectionpool/app-context.xml");
        studentService = appCtx.getBean("jdbcStudentService", JDBCStudentService.class);
    }

    public void testCRUD() {
        JdbcStudent student = new JdbcStudent();
        student.setId(1);
        student.setEmail("nmdien61@gmail.com");
        student.setName("Dien Nguyen");
        
        studentService.save(student);

        JdbcStudent pStudent = studentService.getById(2);
        Assert.assertNull(pStudent);
        
        pStudent = studentService.getById(student.getId());
        Assert.assertNotNull(pStudent);
        Assert.assertEquals("Dien Nguyen", pStudent.getName());
        Assert.assertEquals("nmdien61@gmail.com", pStudent.getEmail());

        // Update
        pStudent.setName("DienNM-DEE");
        studentService.update(pStudent);
        
        pStudent = studentService.getById(student.getId());
        Assert.assertNotNull(pStudent);
        Assert.assertEquals("DienNM-DEE", pStudent.getName());
        Assert.assertEquals("nmdien61@gmail.com", pStudent.getEmail());
        
        // DELETE
        studentService.delete(pStudent);
        pStudent = studentService.getById(student.getId());
        Assert.assertNull(pStudent);
    }
}
