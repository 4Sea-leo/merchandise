<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改商品信息</title>
    <link rel="stylesheet" href="bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" href="bootstrap.min.css">
    <script src="jquery-3.4.1.min.js"></script>
    <script src="bootstrap.min.js"></script>
    <style>
        .ex1{padding: 70px}
        .ex2{padding: 0px 100px 0px}
        .box{
            padding: 20px 200px 20px;

            margin:0 auto;

            border:1px solid #ccc;

            background:whitesmoke;


        }
    </style>
    <script>
        function chk() {
            var name = document.getElementById("name").value;
            var type = document.getElementById("type").value;
            var price = document.getElementById("price").value;
            var num = document.getElementById("num").value;
            var createTime = document.getElementById("createTime").value;
            var description = document.getElementById("description").value;
            if (name == ""){
                //alert("请填写用户名！");
                document.getElementById("name_msg").innerHTML = "请填写商品名！";
                return false;
            }else if (type == ""){
                //alert("请填写用户名！");
                document.getElementById("type_msg").innerHTML = "请填写商品分类！";
                return false;
            }else if (price == ""){
                document.getElementById("price_msg").innerHTML = "请填写商品价格！";
                return false;
            }else if (num == ""){
                document.getElementById("num_msg").innerHTML = "请填写商品数量！";
                return false;
            }else if (createTime == ""){
                document.getElementById("createTime_msg").innerHTML = "请填写商品创建时间！";
                return false;
            } else if (description == ""){
                document.getElementById("description_msg").innerHTML = "请填写商品描述！";
                return false;
            } else {
                return true;
            }
        }
        function chkPrice(input_price) {
            var price = input_price.value;
            if (isNaN(price)){
                document.getElementById("price_msg").innerHTML = "必须是数字";
                return false;
            }else {
                document.getElementById("price_msg").innerHTML = "";
                return true;
            }
        }

        function chkNum(input_num) {
            var num = input_num.value;
            if (isNaN(num)){
                document.getElementById("num_msg").innerHTML = "必须是数字";
                return false;
            }else {
                document.getElementById("num_msg").innerHTML = "";
                return true;
            }
        }
    </script>
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

<div class="ex1" align="center">
    <div class="box">
        <h4>修改商品信息</h4>
        <div class="ex2">
            <form class="form-horizontal" action="EditGoodServlet" method="post" onsubmit="return chk()">
                <input type="hidden" id="id" name="id" value=${good.id}>
                <div class="form-group" id="nameDiv">
                    <label class="col-sm-2 control-label">商品名称</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="name" name="name" value=${good.name}>
                    </div>
                    <br><label style="color: red" class="col-sm-2 control-label" id="name_msg"></label>
                </div>
                <div class="form-group" id="typeDiv">
                    <label class="col-sm-2 control-label">商品分类</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="type" name="type" value=${good.type}>
                    </div>
                    <br><label style="color: red" class="col-sm-2 control-label" id="type_msg"></label>
                </div>
                <div class="form-group" id="priceDiv">
                    <label class="col-sm-2 control-label">商品价格</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="price" name="price" onsubmit="chkPrice(this)" value=${good.price}>
                    </div>
                    <br><label style="color: red" class="col-sm-2 control-label" id="price_msg"></label>
                </div>
                <div class="form-group" id="numDiv">
                    <label class="col-sm-2 control-label">商品数量</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="num" name="num" onsubmit="chkNum(this)" value=${good.num}>
                    </div>
                    <br><label style="color: red" class="col-sm-2 control-label" id="num_msg"></label>
                </div>
                <div class="form-group" id="dateDiv">
                    <label class="col-sm-2 control-label">商品创建时间</label>
                    <div class="col-sm-8">
                        <input type="date" class="form-control" id="createTime" name="createTime" value=${good.createDate}>
                    </div>
                    <br><label style="color: red" class="col-sm-2 control-label" id="createTime_msg"></label>
                </div>
                <%--        <div class="control-group">--%>
                <%--            <label class="col-sm-2 control-label">商品创建时间</label>--%>
                <%--            <div class="col-sm-8" id="form_date">--%>
                <%--                <input id="createTime" name="createTime" type="text" class="form-control" placeholder="请输入创建时间">--%>
                <%--            </div>--%>
                <%--            <br><label class="col-sm-2 control-label" id="createTime_msg"></label>--%>
                <%--        </div>--%>

                <div class="form-group" id="dateDiv">
                    <label class="col-sm-2 control-label">商品描述</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="description" name="description" value=${good.desc}>
                    </div>
                    <br><label style="color: red" class="col-sm-2 control-label" id="description_msg"></label>
                </div>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="修改">
                        <input type="button" value="返回" onclick="javascript:location.href='GetAllServlet'">
                    </td>
                </tr>
            </form>
        </div>
    </div>
</div>
</body>
</html>
