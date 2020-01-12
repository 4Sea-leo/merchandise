package com.test.servlet;

import com.test.dao.GoodDaoImpl;
import com.test.pojo.Good;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GetGoodServlet")
public class GetGoodServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        /*response.setCharacterEncoding("utf-8");*/
        //获取用户请求数据
        String id = request.getParameter("id");
        GoodDaoImpl goodDao = new GoodDaoImpl();
        Good good = goodDao.getGoodById(Integer.parseInt(id));
        request.setAttribute("good", good);
        request.getRequestDispatcher("details.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
