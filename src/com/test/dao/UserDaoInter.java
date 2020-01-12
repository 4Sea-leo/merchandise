package com.test.dao;

import com.test.pojo.User;

public interface UserDaoInter {
    //登陆
    boolean getLogin(User user);
    //注册
    boolean addUser(User user);
    //查询用户名是否被占用
    boolean getUserByName(String name);
}


