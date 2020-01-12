package com.test.servlet;

import com.test.dao.UserDao;
import com.test.dao.UserDaoInter;
import com.test.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("username");
        String pwd = request.getParameter("password");
        User user = new User(name,pwd);
        UserDaoInter userDao = new UserDao();
        boolean isSuccess = userDao.addUser(user);
        if (isSuccess){
            response.sendRedirect("login.jsp");
        }else{
            response.sendRedirect("register.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
