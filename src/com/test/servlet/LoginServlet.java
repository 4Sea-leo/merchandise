package com.test.servlet;

import com.test.dao.UserDao;
import com.test.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求处理，获取用户名及密码
        request.setCharacterEncoding("utf-8");

        String name = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User(name,password);
        UserDao userDao = new UserDao();
        // 保存用户状态
        HttpSession session = request.getSession();
        if (userDao.getLogin(user)){
            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String msg ="于"+df.format(day) + "时间访问商品管理系统";
            session.setAttribute("name",name);
            session.setAttribute("msg", msg);
            request.getRequestDispatcher("/GetAllServlet").forward(request, response);
        }else{
            session.setAttribute("msg", "用户或密码错误，请重新登录");
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
