package com.dee.web.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dee.web.spring.jdbc.model.JdbcStudent;

/**
 * @author dien.nguyen
 **/

public class StudentRowMapper implements RowMapper<JdbcStudent>{

    @Override
    public JdbcStudent mapRow(ResultSet rs, int index) throws SQLException {
        JdbcStudent jdbcStudent = new JdbcStudent();
        jdbcStudent.setId(rs.getInt(1));
        jdbcStudent.setName(rs.getString(2));
        jdbcStudent.setEmail(rs.getString(3));
        
        return jdbcStudent;
    }

}
