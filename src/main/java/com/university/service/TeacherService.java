/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.service;
import com.university.dao.TeacherDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.university.model.Teacher;

public class TeacherService {
    public static void handleDashboard(HttpServletRequest request, HttpServletResponse response, int userId)
            throws ServletException, IOException {
        TeacherDAO teacherDAO = new TeacherDAO();
        Teacher teacher = teacherDAO.getTeacherByUserId(userId);
        request.getSession().setAttribute("teacher", teacher);
        request.getRequestDispatcher("/WEB-INF/views/teacher/dashboard.jsp").forward(request, response);
    }
}
