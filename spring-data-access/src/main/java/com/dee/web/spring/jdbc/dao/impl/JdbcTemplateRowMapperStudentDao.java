package com.dee.web.spring.jdbc.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dee.web.spring.jdbc.dao.StudentRowMapper;
import com.dee.web.spring.jdbc.model.JdbcStudent;

/**
 * @author dien.nguyen
 **/

@Repository("jdbcTemplateRowMapperStudentDao")
public class JdbcTemplateRowMapperStudentDao extends JdbcTemplateStudentDaoSupport {
    
    @Override
    public JdbcStudent findByEmail(String email) {
        String sql = "SELECT id, name, email FROM STUDENT WHERE email = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.queryForObject(sql, new StudentRowMapper(), email);
    }

    @Override
    public List<JdbcStudent> findAll() {
        String sql = "SELECT id, name, email FROM STUDENT";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }
    
    @Override
    public JdbcStudent findById(int studentId) {
        String sql = "SELECT id, name, email FROM STUDENT WHERE id = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<JdbcStudent> students = jdbcTemplate.query(sql, new StudentRowMapper(), studentId);
        if(students.isEmpty()) {
            return null;
        }
        return students.get(0);
    }

}
