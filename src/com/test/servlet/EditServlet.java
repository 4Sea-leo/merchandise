package com.test.servlet;

import com.test.dao.GoodDaoImpl;
import com.test.pojo.Good;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        /*resp.setCharacterEncoding("utf-8");*/
        String id_s = req.getParameter("id");
        int id = Integer.parseInt(id_s);
        GoodDaoImpl goodDao = new GoodDaoImpl();
        Good good = goodDao.getGoodById(id);
        req.setAttribute("good", good);
        req.getRequestDispatcher("edit.jsp").forward(req, resp);
    }
}
