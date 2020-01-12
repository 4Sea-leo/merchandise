package com.test.util;

import java.sql.*;

public class DataBase {
    //打开数据库
    public Connection getConn(){
        Connection conn = null;
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/merchandise?characterEncoding=utf8","root","980814");
        } catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    //关闭
    public void closeConn(Connection conn, PreparedStatement preparedStatement, ResultSet resultSet){
        try {
            if (null!=resultSet){
                resultSet.close();
            }
            if (null!=preparedStatement){
                preparedStatement.close();
            }
            if (null!=conn) {
                conn.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
