package com.university.controller;

import com.university.dao.LoginDAO;
import com.university.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import com.university.service.TeacherService;
import com.university.service.AdminService;

import java.io.IOException;

@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    private LoginDAO loginDAO;

    @Override
    public void init() {
        loginDAO = new LoginDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        User user = loginDAO.getUserByEmailAndPassword(email, password, role);

        if (user != null) {
            // Valid login
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            if ("Admin".equalsIgnoreCase(user.getRole())) {
                AdminService.handleDashboard(request, response, user.getId());
            } else if ("Teacher".equalsIgnoreCase(user.getRole())) {
                TeacherService.handleDashboard(request, response, user.getId());
            } else {
                response.sendRedirect(request.getContextPath() + "/");
            }
//            request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);

        } else {
            // Invalid login
            request.setAttribute("error", "Invalid email or password.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
