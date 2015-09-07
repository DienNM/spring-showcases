package com.dee.web.spring.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.dee.web.spring.jdbc.dao.JDBCStudentDao;
import com.dee.web.spring.jdbc.model.JdbcStudent;

/**
 * @author dien.nguyen
 **/

@Repository("jdbcStudentDao")
public class JDBCStudentDaoImpl implements JDBCStudentDao {
    
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;
    
    @Override
    public JdbcStudent findById(int studentId) {
        String sql = "SELECT id, name, email FROM STUDENT WHERE id = ?";
        Connection connection  = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, studentId);
            
            JdbcStudent student = null;
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                student = new JdbcStudent();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
            }
            ps.close();
            return student;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

    @Override
    public void insert(JdbcStudent student) {
        String sql = "INSERT INTO STUDENT (id, name, email) VALUES(?, ?, ?)";
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());
            ps.executeUpdate();
            ps.close();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

    @Override
    public void update(JdbcStudent student) {
        String sql = "UPDATE STUDENT SET name = ?, email = ? WHERE id = ?";
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getId());
            ps.executeUpdate();
            ps.close();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

    @Override
    public void delete(JdbcStudent student) {
        String sql = "DELETE FROM STUDENT WHERE id = ?";
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, student.getId());
            ps.executeUpdate();
            ps.close();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

}
