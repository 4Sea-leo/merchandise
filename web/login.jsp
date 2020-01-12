<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <link rel="stylesheet" href="bootstrap.min.css">
    <link rel="stylesheet" href="login.css">
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<%--    <script type="text/javascript">
        $(document).ready(function () {
            $("#clear").click(function () {
                $("#username").val("");
                $("#password").val("");
            })
        })
    </script>--%>
    <style>
        .ex1{padding: 70px}
        .ex2{padding: 50px 50px 0px}
        .box{width: 700px ;padding: 50px 100px 50px}
    </style>
</head>
<body bgcolor="#f5f5dc">

<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
<div class="navbar-header">
    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false"></button>
    <a class="navbar-brand" href="#">小怀超市商品管理系统</a>
</div>
</nav>
<div class="ex1">
    <div align="center">
        <br><h2>商品信息管理系统</h2><br>
        <div class="box">
            <h2>登陆</h2>
            <form action="LoginServlet" method="post">
                <div class="inputbox">
                    <input type="text" name="username" required>
                    <label>用户名</label>
                </div>
                <div class="inputbox">
                    <input type="password" name="password" required>
                    <label>密码</label>
                </div>
                <input  class="btn btn-default" type="submit" name="" value="登陆" style="margin-right: 230px;">
                <a class="btn btn-default" href="register.jsp">注册</a>
            </form>
            <p style="color: red">${msg}</p>
        </div>
    </div>
</div>

</body>
</html>
