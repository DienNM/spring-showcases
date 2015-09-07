package com.dee.web.spring.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.dee.web.spring.jdbc.dao.JDBCStudentDao;
import com.dee.web.spring.jdbc.model.JdbcStudent;

/**
 * @author dien.nguyen
 **/

@Repository("directJdbcStudentDao")
public class DirectJdbcStudentDaoImpl implements JDBCStudentDao {

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Override
    public int count() {
        String sql = "SELECT COUNT(*) FROM STUDENT";
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int count = 0;
            if (rs.next()) {
                count = rs.getInt(1);
            }
            ps.close();
            return count;
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
    public String findEmail(int id) {
        String sql = "SELECT email FROM STUDENT WHERE id = ?";
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            String email = null;
            if (rs.next()) {
                email = rs.getString(1);
            }
            ps.close();
            return email;
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
    public List<JdbcStudent> findAll() {
        String sql = "SELECT id, name, email FROM STUDENT";
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            List<JdbcStudent> students = new ArrayList<JdbcStudent>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                JdbcStudent student = new JdbcStudent();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
                students.add(student);
            }
            ps.close();
            return students;
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
    public JdbcStudent findById(int studentId) {
        String sql = "SELECT id, name, email FROM STUDENT WHERE id = ?";
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, studentId);

            JdbcStudent student = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
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
    public JdbcStudent findByEmail(String email) {
        String sql = "SELECT id, name, email FROM STUDENT WHERE email = ?";
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            JdbcStudent student = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
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
    public void insert(final List<JdbcStudent> students) {

        Connection connection = null;
        try {
            String sql = "INSERT INTO STUDENT (id, name, email) VALUES(?, ?, ?)";
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            for (JdbcStudent student : students) {
                ps.setInt(1, student.getId());
                ps.setString(2, student.getName());
                ps.setString(3, student.getEmail());
                ps.addBatch();
            }
            ps.executeBatch();
            ps.close();
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
    public void update(final JdbcStudent student) {
        Connection connection = null;
        try {
            String sql = "UPDATE STUDENT SET name = ?, email = ? WHERE id = ?";
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getId());
            ps.executeUpdate();
            ps.close();
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
    public void delete(JdbcStudent student) {
        String sql = "DELETE FROM STUDENT WHERE id = ?";
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, student.getId());
            ps.executeUpdate();
            ps.close();
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
    public void deleteAll() {
        String sql = "DELETE FROM STUDENT";
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }
}
