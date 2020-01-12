package com.test.dao;

import com.test.pojo.Good;

import java.util.List;

/**
 * 商品接口
 */
public interface GoodDao {
    //新增
    boolean addGoods(Good good);
    //查询
    List<Good> getAllGoods();
    //根据商品号查询信息
    Good getGoodById(int id);
    //修改商品信息
    boolean editGood(Good good);
    //删除商品信息
    boolean delGood(int[] ids);
    // 计算商品总价
    double getGoodsSum();
}
