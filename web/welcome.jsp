<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>小怀超市商品管理系统</title>
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
    <script>
        function addGood() {
            location.href = "add.jsp"
        }

        function editStu() {
            var chks = document.getElementsByName("chk");
            var count = 0;
            var index = 0;
            for (var i=0; i<chks.length; i++){
                if (chks[i].checked == true){
                    count++;
                    index = i;
                }
            }
            if (count == 0){
                alert("请选择要编辑的商品");
            }else if (count > 1){
                alert("只能对一件商品进行编辑");
            }else {
                var sno = chks[index].value;
                alert(sno);
                //进入编辑页面，从数据库获取 信息
                //调用 servlet
                window.location.href = "GetStuBySnoServlet?sno="+sno;

            }
        }
        function delGood() {
            var chks = document.getElementsByName("chk");
            var ids = "";
            for (var i=0; i<chks.length; i++){
                if (chks[i].checked == true){
                    ids += chks[i].value;
                    ids += ",";
                }
            }
            if (ids == ""){
                alert("请选择要删除的记录");
            }else {
                if (confirm("确定删除？")){
                    window.location.href = "DelGoodServlet?ids="+ids
                }
            }

        }
        function checkAll() {
            var node = document.getElementById("chkAll");
            var chks = document.getElementsByName("chk");
            if (node.checked){
                for (var i=0; i<chks.length; i++){
                    chks[i].checked = true;
                }
            }else {
                for (var i=0; i<chks.length; i++){
                    chks[i].checked = false;
                }
            }
        }
        function unchk(chk_s) {
            var chkall = document.getElementById("chkAll");
            if (chk_s.checked == false){
                chkall.checked = false;
            }else {
                var chks = document.getElementsByName("chk");
                var isALL = true;
                for (var i=0; i<chks.length; i++){
                    if (chks[i].checked == false){
                        isALL = false;
                        break;
                    }
                }
                chkall.checked = isALL;
            }
        }
        //声明全局数组，用于存放取值
        var inputArr = document.getElementsByTagName("input");

        function check(o)
        {
            var nameStr = "";
            for (var i = 0; i < inputArr.length-1; i++)
            {
                nameStr += inputArr[i].value + ";";
            }
            nameStr += inputArr[inputArr.length - 1];
            window.name = nameStr;
        }

        if (window.name)
        {
            //声明数组，用于存放从window.name中分离出的值
            var nameArr = new Array();
            nameArr = window.name.split(";");

            for (var i = 0; i < nameArr.length; i++)
            {
                if (inputArr[i].type == "text")
                {
                    inputArr[i].value = nameArr[i];
                }
            }
        }
    </script>
</head>
<body style="background-image: url(img/backgroud.jpg)">
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        </button>
        <a class="navbar-brand" href="/GetAllServlet">小怀超市商品管理系统</a>
    </div>
    <div>
        <p class="navbar-text">用户：${name} ${msg}</p>
        <%--<p class="navbar-text">登陆时间：<%out.print(createTime);%></p>--%>
    </div>

    </nav><%--<div align="right" style="padding:0px 10px 0px 0px">
        <button onclick="window.location.href = 'release.jsp'" class="navbar-btn btn btn-primary">
            发布
        </button>
    </div>--%>
    <div class="ex1">
        <div class="box">
            <div class="ex2">
                <h3>管理货品</h3>
                <form action="QueryStuServlet" method="post" onsubmit="check(this)">
                    <input type="text" size="10px" name="id" placeholder="请输入商品号" id="id" value=${goodId}>
                    <input type="submit" value="查询" class="btn btn-primary">
                </form>
                <input type="button" value="新增" onclick="addGood()" class="btn btn-default">
                <input type="button" value="删除" onclick="delGood()" class="btn btn-default">
                <table class="table table-hover">
                    <tr>
                        <td align="center"><input type="checkbox" onclick="checkAll()" id="chkAll"></td>
                        <td align="center">商品id</td>
                        <td align="center">名称</td>
                        <td align="center">单价</td>
                        <td align="center">数量</td>
                        <td align="center">总价</td>
                        <td align="center">详情</td>
                    </tr>
                    <c:forEach items="${list}" var="good">
                        <tr>
                            <td align="center"><input type="checkbox" value="${good.id}" name="chk" onclick="unchk(this)"></td>
                            <td align="center">${good.id}</td>
                                <%--                <td align="center"><a href="edit.jsp>${good.name}</a></td>--%>
                            <td><a href="EditServlet?id=${good.id}">${good.name}</a> </td>
                            <td align="center">${good.price}</td>
                            <td align="center">${good.num}</td>
                            <td align="center">${good.total}</td>
                            <td align="center"><a href="GetGoodServlet?id=${good.id}">商品详情</a> </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td align="center">总价</td>
                        <td align="center">${sum}</td>
                        <td></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>

</body>
</html>