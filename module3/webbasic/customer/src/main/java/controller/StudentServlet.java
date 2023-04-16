package controller;

import model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    private static List<Student> studentList;

    static {
        studentList = new ArrayList<>();
        studentList.add(new Student(1, "hoc", 1, 90, "avatar.png"));
        studentList.add(new Student(2, "hoc1", 0, 80, "avatar_1.jpg"));
        studentList.add(new Student(3, "hoc2", 1, 60, "avatar_2.png"));
        studentList.add(new Student(4, "hoc3", 0, 40, "avatar_3.jpg"));
        studentList.add(new Student(5, "hoc4", 1, 90, "avatar_4.jpg"));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("studentList", studentList);
        request.getRequestDispatcher("/index").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
