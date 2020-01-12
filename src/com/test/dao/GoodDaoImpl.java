package com.test.dao;

import com.test.pojo.Good;
import com.test.util.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodDaoImpl implements GoodDao{
    private DataBase dataBase = new DataBase();
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public boolean addGoods(Good good) {
        boolean flag = false;
        connection = dataBase.getConn();
        String sql = "INSERT INTO goods (name, type, price, num, create_date, description) VALUES (?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,good.getName());
            preparedStatement.setString(2,good.getType());
            preparedStatement.setDouble(3,good.getPrice());
            preparedStatement.setDouble(4,good.getNum());
            preparedStatement.setDate(5, good.getCreateDate());
            preparedStatement.setString(6, good.getDesc());
            int num = preparedStatement.executeUpdate();
            if (0!=num){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dataBase.closeConn(connection,preparedStatement,resultSet);
        }
        return flag;
    }

    @Override
    public List<Good> getAllGoods() {
        List<Good> list = new ArrayList<Good>();

        String sql = "select id,name,price,num,total,create_date,description from goods";
        connection = dataBase.getConn();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Good good = new Good();
                good.setId(resultSet.getInt("id"));
                good.setName(resultSet.getString("name"));
                good.setPrice(resultSet.getDouble("price"));
                good.setNum(resultSet.getInt("num"));
                good.setTotal(resultSet.getInt("total"));
                good.setCreateDate(resultSet.getDate("create_date"));
                good.setDesc(resultSet.getString("description"));
                list.add(good);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dataBase.closeConn(connection,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public Good getGoodById(int id) {
        Good good = null;
        String sql = "select id,name,price,num,total,create_date,description,type from goods where id = ?";
        connection = dataBase.getConn();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                good = new Good();
                good.setId(resultSet.getInt(1));
                good.setName(resultSet.getString(2));
                good.setPrice(resultSet.getDouble(3));
                good.setNum(resultSet.getInt(4));
                good.setTotal(resultSet.getDouble(5));
                good.setCreateDate(resultSet.getDate(6));
                good.setDesc(resultSet.getString(7));
                good.setType(resultSet.getString(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dataBase.closeConn(connection,preparedStatement,resultSet);
        }
        return good;
    }

    @Override
    public boolean editGood(Good good) {
        boolean isEdit = false;

        String sql = "update goods set name = ?, type = ?,  price = ?, num = ?, create_date = ?, description = ? where id = ?";
        connection = dataBase.getConn();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,good.getName());
            preparedStatement.setString(2,good.getType());
            preparedStatement.setDouble(3,good.getPrice());
            preparedStatement.setInt(4,good.getNum());
            preparedStatement.setDate(5,good.getCreateDate());
            preparedStatement.setString(6,good.getDesc());
            preparedStatement.setInt(7, good.getId());
            preparedStatement.executeUpdate();
            isEdit = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isEdit;
    }

    @Override
    public boolean delGood(int[] ids) {
        boolean isDelete = false;

        String sql = "delete from goods where id in (" ;
        for (int i=0; i<ids.length; i++){
            sql += "?";
            if (i != ids.length - 1) {
                sql += ",";
            }
        }
             sql +=   ") ";

        connection = dataBase.getConn();
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i<ids.length; i++){
                preparedStatement.setInt((i+1),ids[i]);
            }
            int num = preparedStatement.executeUpdate();
            if (num>0){
                isDelete = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dataBase.closeConn(connection,preparedStatement,null);
        }

        return  isDelete;
    }

    @Override
    public double getGoodsSum() {
        String sql = "select sum(total) from goods";
        connection = dataBase.getConn();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return resultSet.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
