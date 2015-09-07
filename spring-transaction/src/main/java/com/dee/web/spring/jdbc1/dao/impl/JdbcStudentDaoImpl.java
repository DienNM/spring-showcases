package com.dee.web.spring.jdbc1.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.dee.web.spring.jdbc1.dao.JdbcStudentDao;
import com.dee.web.spring.jdbc1.model.JdbcStudent;

/**
 * @author dien.nguyen
 **/

@Repository("jdbcStudentDao")
public class JdbcStudentDaoImpl implements JdbcStudentDao {

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public List<JdbcStudent> findAll() {
        String sql = "SELECT id, email, name FROM STUDENT";
        List<Map<String, Object>> mapDatas = jdbcTemplate.queryForList(sql);

        List<JdbcStudent> students = new ArrayList<JdbcStudent>();
        for (Map<String, Object> map : mapDatas) {
            JdbcStudent student = new JdbcStudent();
            student.setId(Integer.valueOf(map.get("ID").toString()));
            student.setEmail(map.get("EMAIL").toString());
            student.setName(map.get("NAME").toString());
            students.add(student);
        }
        return students;
    }

    @Override
    public JdbcStudent findById(final int studentId) {
        return jdbcTemplate.query(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection cnn) throws SQLException {
                String sql = "SELECT id, email, name FROM STUDENT WHERE id = ?";
                PreparedStatement ps = cnn.prepareStatement(sql);
                ps.setInt(1, studentId);
                return ps;
            }
        }, new ResultSetExtractor<JdbcStudent>() {

            @Override
            public JdbcStudent extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    JdbcStudent student = new JdbcStudent();
                    student.setId(rs.getInt(1));
                    student.setEmail(rs.getString(2));
                    student.setName(rs.getString(3));
                    return student;
                }
                return null;
            }
        });
    }

    @Override
    public void insert(final JdbcStudent student) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                String sql = "INSERT INTO STUDENT (id, name, email) VALUES(?, ?, ?)";
                jdbcTemplate.update(sql, new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps) throws SQLException {
                        ps.setInt(1, student.getId());
                        ps.setString(2, student.getName());
                        ps.setString(3, student.getEmail());
                    }
                });
            }
        });
    }

    @Override
    public void update(final JdbcStudent student) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {

            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                String sql = "UPDATE STUDENT SET name = ?, email = ? WHERE id = ?";
                jdbcTemplate.update(sql, new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps) throws SQLException {
                        ps.setString(1, student.getName());
                        ps.setString(2, student.getEmail());
                        ps.setInt(3, student.getId());
                    }
                });
            }
        });
    }

    @Override
    public void deleteAll() {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                jdbcTemplate.update(new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                        String sql = "DELETE FROM STUDENT";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        return ps;
                    }
                });
            }
        });
    }

}
