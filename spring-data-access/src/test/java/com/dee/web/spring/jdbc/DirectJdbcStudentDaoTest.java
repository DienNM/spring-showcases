package com.dee.web.spring.jdbc;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dee.web.spring.jdbc.dao.JDBCStudentDao;
import com.dee.web.spring.jdbc.model.JdbcStudent;
import com.dee.web.spring.jdbc.service.JDBCStudentService;

/**
 * @author dien.nguyen
 **/

public class DirectJdbcStudentDaoTest extends TestCase {

    ApplicationContext appCtx;

    private JDBCStudentService studentService;

    @Override
    protected void setUp() throws Exception {
        appCtx = new GenericXmlApplicationContext("/spring/jdbc/nonconnectionpool/app-context.xml");
        studentService = appCtx.getBean("jdbcStudentService", JDBCStudentService.class);

        JDBCStudentDao jdbcStudentDao = appCtx.getBean("directJdbcStudentDao", JDBCStudentDao.class);
        studentService.setStudentDao(jdbcStudentDao);
    }

    @Override
    protected void tearDown() throws Exception {
        studentService.deleteAll();
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

    public void testQuery() {
        studentService.save(createJdbcStudent1());
        
        JdbcStudent pStudent = studentService.getById(1);
        Assert.assertNotNull(pStudent);
        Assert.assertEquals("Dien Nguyen", pStudent.getName());
        Assert.assertEquals("nmdien61@gmail.com", pStudent.getEmail());
        
        pStudent = studentService.getById(2);
        Assert.assertNull(pStudent);
        
        Assert.assertEquals(1, studentService.count());
        assertEquals("nmdien61@gmail.com", studentService.getEmail(1));
        
        // Query All
        List<JdbcStudent> students = studentService.getAll();
        Assert.assertEquals(1, students.size());
        for (JdbcStudent std : students) {
            if (std.getId() == 1) {
                Assert.assertEquals("Dien Nguyen", std.getName());
                Assert.assertEquals("nmdien61@gmail.com", std.getEmail());
            } else {
                Assert.fail();
            }
        }
        // Add more
        studentService.save(createJdbcStudent2());
        Assert.assertEquals(2, studentService.count());
    }

    public void testUpdate() {
        studentService.save(createJdbcStudent1());

        JdbcStudent pStudent = studentService.getById(1);
        Assert.assertNotNull(pStudent);
        Assert.assertEquals("Dien Nguyen", pStudent.getName());
        Assert.assertEquals("nmdien61@gmail.com", pStudent.getEmail());

        pStudent.setName("DienNM-DEE");
        studentService.update(pStudent);
        
        //Query after updating
        pStudent = studentService.getById(1);
        Assert.assertNotNull(pStudent);
        Assert.assertEquals("DienNM-DEE", pStudent.getName());
        Assert.assertEquals("nmdien61@gmail.com", pStudent.getEmail());
    }
    
    public void testDelete() {
        studentService.save(createJdbcStudent1());
        // Query
        JdbcStudent pStudent = studentService.getById(1);
        Assert.assertNotNull(pStudent);

        studentService.delete(pStudent);
        pStudent = studentService.getById(1);
        Assert.assertNull(pStudent);
    }

    public void testBatchInsert() {
        JdbcStudent student1 = createJdbcStudent1();
        JdbcStudent student2 = createJdbcStudent2();
        studentService.save(Arrays.asList(student1, student2));

        JdbcStudent pStudent1 = studentService.getById(1);
        
        Assert.assertNotNull(pStudent1);
        Assert.assertEquals("Dien Nguyen", pStudent1.getName());
        Assert.assertEquals("nmdien61@gmail.com", pStudent1.getEmail());

        JdbcStudent pStudent2 = studentService.getById(2);
        Assert.assertNotNull(pStudent2);
        Assert.assertEquals("DEE", pStudent2.getName());
        Assert.assertEquals("nguyenminhdien1506@gmail.com", pStudent2.getEmail());
        
        Assert.assertEquals(2, studentService.count());
    }

}
