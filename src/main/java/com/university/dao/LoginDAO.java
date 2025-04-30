package com.university.dao;
 import com.university.model.User;
 import com.university.util.DBUtil;
 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;
 import java.time.LocalDateTime;
 import java.util.ArrayList;
 import java.util.List;


public class LoginDAO {
    public boolean login(String email, String password, String role) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, password); // Note: consider hashing in production
            stmt.setString(3, role);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return true; // Match found
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // No match
    }
    
    public List getAllUsers(){
        List<User> userlist = new ArrayList<>();
        String sql = "SELECT * FROM users";
        
        try(Connection conn =DBUtil.getConnection();
             Statement stmt =conn.createStatement();
             ResultSet rs =stmt.executeQuery(sql)){
            
            while (rs.next()){
                User user =new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                userlist.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return userlist;
    }
    public User getUserByEmailAndPassword(String email, String password, String role) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ? AND role = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, password);
            stmt.setString(3, role);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setRole(rs.getString("role"));
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
