package com.dee.web.spring.jdbc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.dee.web.spring.jdbc.dao.JDBCStudentDao;
import com.dee.web.spring.jdbc.model.JdbcStudent;

/**
 * @author dien.nguyen
 **/

@Repository("namedParameterJdbcStudentDao")
public class NamedParameterJdbcStudentDaoImpl extends NamedParameterJdbcDaoSupport implements JDBCStudentDao {
    
    @Autowired(required = false)
    private JdbcTemplate jdbcTemplate;
    
    @PostConstruct
    void init() {
        setJdbcTemplate(jdbcTemplate);
    }

    @Override
    public int count() {
        String sql = "SELECT COUNT(*) FROM STUDENT";
        return getNamedParameterJdbcTemplate().queryForObject(sql, new HashMap<String, Object>(), 
                Integer.class);
        
    }
    
    @Override
    public String findEmail(final int id) {
        String sql = "SELECT EMAIL FROM STUDENT WHERE id = :id";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        return getNamedParameterJdbcTemplate().queryForObject(sql, params, 
                String.class);
    }

    @Override
    public JdbcStudent findByEmail(String email) {
        String sql = "SELECT id, name, email FROM STUDENT WHERE email = :email";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("email", email);
        return getNamedParameterJdbcTemplate().query(sql, params, new ResultSetExtractor<JdbcStudent>() {

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
    public List<JdbcStudent> findAll() {
        String sql = "SELECT id, name, email FROM STUDENT";
        List<JdbcStudent> students = new ArrayList<JdbcStudent>();
        List<Map<String, Object>> mapData = 
                getNamedParameterJdbcTemplate().queryForList(sql, new HashMap<String, Object>());
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
        String sql = "SELECT id, name, email FROM STUDENT WHERE id = :id";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", studentId);
        return getNamedParameterJdbcTemplate().query(sql, params, new ResultSetExtractor<JdbcStudent>() {

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
        String sql = "INSERT INTO STUDENT (id, name, email) VALUES(:id, :name, :email)";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", student.getId());
        params.put("name", student.getName());
        params.put("email", student.getEmail());
        getNamedParameterJdbcTemplate().update(sql, params);
    }

    @Override
    public void insert(final List<JdbcStudent> students) {
        String sql = "INSERT INTO STUDENT (id, name, email) VALUES(:id, :name, :email)";
        SqlParameterSource[] mapParams = new MapSqlParameterSource[students.size()];
        int index = 0;
        for(JdbcStudent student : students) {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("id", student.getId());
            params.put("name", student.getName());
            params.put("email", student.getEmail());
            SqlParameterSource sqlParam = new MapSqlParameterSource(params);
            mapParams[index++] =  sqlParam;
        }
        getNamedParameterJdbcTemplate().batchUpdate(sql, mapParams);
    }

    @Override
    public void update(final JdbcStudent student) {
        String sql = "UPDATE STUDENT SET name = :name, email = :email WHERE id = :id";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", student.getId());
        params.put("name", student.getName());
        params.put("email", student.getEmail());
        
        getNamedParameterJdbcTemplate().update(sql, params);
    }

    @Override
    public void delete(final JdbcStudent student) {
        String sql = "DELETE FROM STUDENT WHERE id = :id";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", student.getId());
        
        getNamedParameterJdbcTemplate().update(sql, params);
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM STUDENT";
        Map<String, Object> params = new HashMap<String, Object>();
        getNamedParameterJdbcTemplate().update(sql, params);
    }

}
