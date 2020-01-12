package com.test.servlet;

import com.test.dao.GoodDaoImpl;
import com.test.pojo.Good;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddGoodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理编码字符集
        request.setCharacterEncoding("utf-8");
        //获取提交信息
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
        GoodDaoImpl goodDao = new GoodDaoImpl();
        goodDao.addGoods(good);
        //转发,查询所有数据，显示
        request.getRequestDispatcher("GetAllServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
