/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.service;

import com.university.dao.AdminDAO;
import com.university.model.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class AdminService {
    public static void handleDashboard(HttpServletRequest request, HttpServletResponse response, int userId)
            throws ServletException, IOException {
        AdminDAO adminrDAO = new AdminDAO();
        Admin admin = adminrDAO.getAdminByUserId(userId);
        request.getSession().setAttribute("admin", admin);
        request.getRequestDispatcher("/WEB-INF/views/admin/dashboard.jsp").forward(request, response);
    }
}
