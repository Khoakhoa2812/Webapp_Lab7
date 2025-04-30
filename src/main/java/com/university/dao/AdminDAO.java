/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.university.model.Admin;
import com.university.util.DBUtil;
import java.sql.Statement;
/**
 *
 * @author Admin
 */
public class AdminDAO {
    public Admin getAdminByUserId(int userId) {
        Admin admin = null;
        String sql = "SELECT * FROM admin WHERE user_id = ?";

        try (Connection conn =DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId); // or stmt.setString(1, someString) etc.
            ResultSet rs = stmt.executeQuery();
    
            if (rs.next()) {
                admin = new Admin();
                admin.setUserId(rs.getInt("user_id"));
                admin.setName(rs.getString("full_name"));
                admin.setAccessLevel(rs.getString("access_level"));
                admin.setLastLogin(rs.getString("last_login"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admin;
    }
}
