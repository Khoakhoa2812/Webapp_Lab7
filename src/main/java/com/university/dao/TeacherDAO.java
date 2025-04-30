/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.dao;

/**
 *
 * @author Admin
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.university.model.Teacher;
import com.university.util.DBUtil;
import java.sql.Statement;

public class TeacherDAO {

    public Teacher getTeacherByUserId(int userId) {
        Teacher teacher = null;
        String sql = "SELECT * FROM teacher WHERE user_id = ?";

        try (Connection conn =DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId); // or stmt.setString(1, someString) etc.
            ResultSet rs = stmt.executeQuery();
    
            if (rs.next()) {
                teacher = new Teacher();
                teacher.setUserId(rs.getInt("user_id"));
                teacher.setName(rs.getString("full_name"));
                teacher.setDepartment(rs.getString("department"));
                teacher.setHiredate(rs.getString("hire_date"));
                teacher.setOffice(rs.getString("office"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teacher;
    }
}

