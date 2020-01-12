package com.test.pojo;

import java.math.BigDecimal;
import java.sql.Date;

public class Good {
    private int id;
    private String name;
    private String type;
    private double price;
    private int num;
    private Date createDate;
    private double total;
    private String desc;

    public Good() {
    }

    public Good(String name, String type, double price, int num, Date createDate, String desc) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.num = num;
        this.createDate = createDate;
        this.desc = desc;
    }

    public Good(String name, String type, double price, int num, String desc) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.num = num;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
