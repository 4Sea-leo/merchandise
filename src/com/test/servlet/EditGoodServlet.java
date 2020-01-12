package com.test.servlet;

import com.test.dao.GoodDaoImpl;
import com.test.pojo.Good;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/EditGoodServlet")
public class EditGoodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        /*response.setCharacterEncoding("utf-8");*/
        //获取用户请求数据
        boolean isEdit = false;
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        double price = Double.parseDouble(request.getParameter("price"));
        int num = Integer.parseInt(request.getParameter("num"));
        String dateStr = request.getParameter("createTime");
        String description = request.getParameter("description");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Good good = new Good(name, type, price, num, new java.sql.Date(date.getTime()), description);
        good.setId(Integer.parseInt(id));
        GoodDaoImpl goodDao = new GoodDaoImpl();
        isEdit = goodDao.editGood(good);
        if (isEdit){
            response.sendRedirect("GetAllServlet");
        }else {
            response.sendRedirect("edit.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
