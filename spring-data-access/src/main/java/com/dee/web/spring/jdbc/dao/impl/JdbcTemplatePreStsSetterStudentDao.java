package com.dee.web.spring.jdbc.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.dee.web.spring.jdbc.dao.StudentRowMapper;
import com.dee.web.spring.jdbc.model.JdbcStudent;

/**
 * @author dien.nguyen
 **/

@Repository("jdbcTemplatePreStsSetterStudentDao")
public class JdbcTemplatePreStsSetterStudentDao extends JdbcTemplateStudentDaoSupport {

    @Override
    public JdbcStudent findByEmail(String email) {
        String sql = "SELECT id, name, email FROM STUDENT WHERE email = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.queryForObject(sql, new StudentRowMapper(), email);
    }

    @Override
    public JdbcStudent findById(int studentId) {
        String sql = "SELECT id, name, email FROM STUDENT WHERE id = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<JdbcStudent> students = jdbcTemplate.query(sql, new StudentRowMapper(), studentId);
        if (students.isEmpty()) {
            return null;
        }
        return students.get(0);
    }

    @Override
    public void insert(final JdbcStudent student) {
        String sql = "INSERT INTO STUDENT (id, name, email) VALUES(?, ?, ?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, new PreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, student.getId());
                ps.setString(2, student.getName());
                ps.setString(3, student.getEmail());
            }
        });
    }

    @Override
    public void insert(final List<JdbcStudent> students) {
        String sql = "INSERT INTO STUDENT (id, name, email) VALUES(?, ?, ?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int index) throws SQLException {
                JdbcStudent student = students.get(index);
                ps.setInt(1, student.getId());
                ps.setString(2, student.getName());
                ps.setString(3, student.getEmail());
            }

            @Override
            public int getBatchSize() {
                return students.size();
            }
        });
    }

    @Override
    public void update(final JdbcStudent student) {
        String sql = "UPDATE STUDENT SET name = ?, email = ? WHERE id = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, new PreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, student.getName());
                ps.setString(2, student.getEmail());
                ps.setInt(3, student.getId());
            }
        });

    }

    @Override
    public void delete(final JdbcStudent student) {
        String sql = "DELETE FROM STUDENT WHERE id = ?";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, new PreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, student.getId());
            }
        });
    }
}
