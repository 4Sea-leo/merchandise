package com.test.servlet;

import com.test.dao.GoodDaoImpl;
import com.test.pojo.Good;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/GetAllServlet")
public class GetAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodDaoImpl goodDao = new GoodDaoImpl();
        List<Good> list = goodDao.getAllGoods();
        double sum = goodDao.getGoodsSum();
        //转发
        request.setAttribute("list",list);
        request.setAttribute("sum", sum);
        request.setAttribute("goodId", "");
        request.getRequestDispatcher("welcome.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
