package com.test.servlet;

import com.test.dao.GoodDaoImpl;
import com.test.pojo.Good;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/QueryStuServlet")
public class QueryGoodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id_s = request.getParameter("id");
        int id = 0;
        if (!("".equals(id_s))){
            id = Integer.parseInt(id_s);
            GoodDaoImpl goodDao = new GoodDaoImpl();
            Good good = goodDao.getGoodById(id);
            List<Good> goods = new ArrayList<>();
            goods.add(good);
            request.setAttribute("list", goods);
            request.setAttribute("goodId", id);
            request.getRequestDispatcher("welcome.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/GetAllServlet").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
