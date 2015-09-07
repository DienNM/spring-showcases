package com.dee.web.spring.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.dee.web.spring.jdbc.dao.JDBCStudentDao;
import com.dee.web.spring.jdbc.model.JdbcStudent;

/**
 * @author dien.nguyen
 **/

@Repository("jdbcDaoSupportStudentDao")
public class JdbcDaoSupportStudentDao extends JdbcDaoSupport implements JDBCStudentDao {
    
    @Autowired(required = false)
    private JdbcTemplate jdbcTemplate;
    
    @PostConstruct
    void init() {
        setJdbcTemplate(jdbcTemplate);
    }
    
    @Override
    public int count() {
        String sql = "SELECT COUNT(*) FROM STUDENT";
        return getJdbcTemplate().queryForObject(sql, Integer.class);
        
    }
    
    @Override
    public String findEmail(final int id) {
        String sql = "SELECT EMAIL FROM STUDENT WHERE id = ?";
        return getJdbcTemplate().queryForObject(sql, String.class, id);
    }

    @Override
    public JdbcStudent findByEmail(String email) {
        String sql = "SELECT id, name, email FROM STUDENT WHERE email = ?";
        final JdbcStudent jdbcStudent = new JdbcStudent();
        getJdbcTemplate().query(sql, new RowCallbackHandler() {

            @Override
            public void processRow(ResultSet rs) throws SQLException {
                jdbcStudent.setId(rs.getInt(1));
                jdbcStudent.setName(rs.getString(2));
                jdbcStudent.setEmail(rs.getString(3));
            }

        }, email);
        return jdbcStudent;
    }

    @Override
    public List<JdbcStudent> findAll() {
        String sql = "SELECT id, name, email FROM STUDENT";

        List<JdbcStudent> students = new ArrayList<JdbcStudent>();

        List<Map<String, Object>> mapData = getJdbcTemplate().queryForList(sql);
        for(Map<String, Object> map : mapData) {
            JdbcStudent student = new JdbcStudent();
            student.setId(Integer.valueOf(map.get("id").toString()));
            student.setEmail(map.get("email").toString());
            student.setName(map.get("name").toString());
            students.add(student);
        }

        return students;
    }
    
    @Override
    public JdbcStudent findById(final int studentId) {
        return getJdbcTemplate().query(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection cnn) throws SQLException {
                String sql = "SELECT id, name, email FROM STUDENT WHERE id = ?";
                PreparedStatement ps = cnn.prepareStatement(sql);
                ps.setInt(1, studentId);
                return ps;
            }
        }, new ResultSetExtractor<JdbcStudent>() {
            @Override
            public JdbcStudent extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()) {
                    JdbcStudent jdbcStudent = new JdbcStudent();
                    jdbcStudent.setId(rs.getInt(1));
                    jdbcStudent.setName(rs.getString(2));
                    jdbcStudent.setEmail(rs.getString(3));
                    return jdbcStudent;
                }
                return null;
            }
        });
    }

    @Override
    public void insert(final JdbcStudent student) {
        getJdbcTemplate().update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection cnn) throws SQLException {
                String sql = "INSERT INTO STUDENT (id, name, email) VALUES(?, ?, ?)";
                PreparedStatement ps = cnn.prepareStatement(sql);
                ps.setInt(1, student.getId());
                ps.setString(2, student.getName());
                ps.setString(3, student.getEmail());
                return ps;
            }
        });
    }

    @Override
    public void insert(final List<JdbcStudent> students) {
        String sql = "INSERT INTO STUDENT (id, name, email) VALUES(?, ?, ?)";
        getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {

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
        getJdbcTemplate().update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                String sql = "UPDATE STUDENT SET name = ?, email = ? WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, student.getName());
                ps.setString(2, student.getEmail());
                ps.setInt(3, student.getId());
                return ps;
            }
        });

    }

    @Override
    public void delete(final JdbcStudent student) {
        getJdbcTemplate().update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                String sql = "DELETE FROM STUDENT WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, student.getId());
                return ps;
            }
        });
    }

    @Override
    public void deleteAll() {
        getJdbcTemplate().update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                String sql = "DELETE FROM STUDENT";
                PreparedStatement ps = conn.prepareStatement(sql);
                return ps;
            }
        });
    }
}
