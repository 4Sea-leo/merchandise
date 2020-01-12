<%--
  Created by IntelliJ IDEA.
  User: liujunmin
  Date: 2020/1/11
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品详情页</title>
    <link rel="stylesheet" href="bootstrap.min.css">
    <script src="jquery-3.4.1.min.js"></script>
    <script src="bootstrap.min.js"></script>
    <style>
        .ex1{padding: 70px}
        .ex2{padding: 50px 50px 0px}
        .box{
            padding: 20px 20px 20px;

            margin:0 auto;

            border:1px solid #ccc;

            background:whitesmoke;


        }
    </style>
</head>
<body style="background-image: url(img/backgroud.jpg)">

<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false"></button>
        <a class="navbar-brand" href="/GetAllServlet">小怀超市商品管理系统</a>
    </div>
    <div>
        <p class="navbar-text">用户：${name}</p>
    </div>
</nav>

    <div class="ex1">
        <div class="box">
            <h4>商品详情信息</h4>
            <table class="table">
                <thead>
                <tr>
                    <th>商品属性</th>
                    <th>商品信息</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>商品id</td>
                    <td>${good.id}</td>
                </tr>
                <tr>
                    <td>商品名称</td>
                    <td>${good.name}</td>
                </tr>
                <tr>
                    <td>商品分类</td>
                    <td>${good.type}</td>
                </tr>
                <tr>
                    <td>商品价格</td>
                    <td>${good.price}</td>
                </tr>
                <tr>
                    <td>商品数量</td>
                    <td>${good.num}</td>
                </tr>
                <tr>
                    <td>商品总价</td>
                    <td>${good.total}</td>
                </tr>
                <tr>
                    <td>商品创建时间</td>
                    <td>${good.createDate}</td>
                </tr>
                <tr>
                    <td>商品描述</td>
                    <td>${good.desc}</td>
                </tr>
                </tbody>
                <td colspan="2" align="center">
                    <input type="button" value="返回" onclick="javascript:location.href='GetAllServlet'">
                </td>
            </table>
        </div>

</div>
</body>
</html>
