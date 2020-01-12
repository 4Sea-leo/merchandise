package com.test.dao;

import com.test.pojo.User;
import com.test.util.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao implements UserDaoInter {
    DataBase dataBase = new DataBase();
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    @Override
    public boolean getLogin(User user) {
        boolean flag = false;
        try {
            connection = dataBase.getConn();
            String sql = "select * from user where user.username=? and user.userpassword=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getUserpwd());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dataBase.closeConn(connection, preparedStatement, resultSet);
        }
        return flag;
    }

    @Override
    public boolean addUser(User user) {
        boolean isSuccess = false;
        String sql = "insert into user (username,userpassword) value (?,?)";
        connection = dataBase.getConn();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getUserpwd());
            int num = preparedStatement.executeUpdate();
            if (num > 0){
                isSuccess = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dataBase.closeConn(connection,preparedStatement,null);
        }
        return isSuccess;
    }

    @Override
    public boolean getUserByName(String name) {
        boolean isExist = false;

        String sql ="select * from myuser where name=?";
        connection = dataBase.getConn();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                isExist = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dataBase.closeConn(connection,preparedStatement,resultSet);
        }

        return isExist;
    }
}

