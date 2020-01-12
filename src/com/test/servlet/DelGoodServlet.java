package com.test.servlet;

import com.test.dao.GoodDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DelGoodServlet")
public class DelGoodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ids = request.getParameter("ids");

        String[] arr_ids = ids.split(",");
        int[] int_ids = new int[arr_ids.length];
        for (int i = 0; i<arr_ids.length; i++){
            int_ids[i] = Integer.parseInt(arr_ids[i]);
        }
        GoodDaoImpl goodDao = new GoodDaoImpl();
        boolean isDelete = goodDao.delGood(int_ids);
        if (isDelete){
            response.sendRedirect("GetAllServlet");
        }
    }
}
