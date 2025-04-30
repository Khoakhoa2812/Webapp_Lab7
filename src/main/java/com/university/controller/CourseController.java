package com.university.controller;

import com.university.dao.CourseDAO;
import com.university.model.Course;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CourseController", urlPatterns = {"/courses", "/course/*"})
public class CourseController extends HttpServlet {

    private CourseDAO courseDAO;

    @Override
    public void init() {
        courseDAO = new CourseDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getPathInfo();
        if (path == null) {
            listCourses(request, response);
        } else {
            switch (path) {
                case "/new":
                    showForm(request, response, null);
                    break;
                case "/edit":
                    editForm(request, response);
                    break;
                case "/delete":
                    deleteCourse(request, response);
                    break;
                case "/view":
                    viewCourse(request, response);
                    break;
                default:
                    listCourses(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo();
        if ("/add".equals(path)) {
            addCourse(request, response);
        } else if ("/update".equals(path)) {
            updateCourse(request, response);
        } else {
            listCourses(request, response);
        }
    }

    private void listCourses(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Course> courses = courseDAO.getAllCourses();
        request.setAttribute("courses", courses);
        request.getRequestDispatcher("/WEB-INF/views/course-list.jsp").forward(request, response);
    }

    private void viewCourse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Course course = courseDAO.getCourseById(id);
        request.setAttribute("course", course);
        request.getRequestDispatcher("/WEB-INF/views/course-view.jsp").forward(request, response);
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response, Course course)
            throws ServletException, IOException {
        request.setAttribute("course", course);
        request.getRequestDispatcher("/WEB-INF/views/course-form.jsp").forward(request, response);
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Course course = courseDAO.getCourseById(id);
        showForm(request, response, course);
    }

    private void addCourse(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Course course = extractCourseFromRequest(request);
        courseDAO.addCourse(course);
        response.sendRedirect(request.getContextPath() + "/courses");
    }

    private void updateCourse(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Course course = extractCourseFromRequest(request);
        course.setId(Integer.parseInt(request.getParameter("id")));
        courseDAO.updateCourse(course);
        response.sendRedirect(request.getContextPath() + "/courses");
    }

    private void deleteCourse(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        courseDAO.deleteCourse(id);
        response.sendRedirect(request.getContextPath() + "/courses");
    }

    private Course extractCourseFromRequest(HttpServletRequest request) {
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int credits = Integer.parseInt(request.getParameter("credits"));

        return new Course(0, code, name, description, credits);
    }
}
