<%--
  Created by IntelliJ IDEA.
  User: 雷耀宏
  Date: 2020/1/10
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员注册</title>
    <link rel="stylesheet" href="bootstrap.min.css">
    <link rel="stylesheet" href="login.css">
    <script src="jquery-3.4.1.min.js"></script>
    <script src="bootstrap.min.js"></script>
    <style>
        .ex1{padding: 70px}
        .ex2{padding: 50px 50px 0px}
        .box{width: 700px ;padding: 50px 100px 50px}
    </style>
    <script>
        function chk_pwd() {
            //获取密码
            var pwd = document.getElementById("pwd").value;
            var pwd_c = document.getElementById("pwd_c").value;

            //alert(pwd.length) 可以获取密码长度

            if(pwd != pwd_c){
                document.getElementById("msg").innerHTML = "输入的密码不一致";
                return false;
            }else {
                document.getElementById("msg").innerHTML = "";
                return true;
            }
        }
        function creatXml() {
            //用来创建ajax依赖的一个对象
            try{
                return new XMLHttpRequest();
            }catch (e) {
                try{
                    return new ActiveXObject("Microsoft.XMLHttp");
                }catch (e) {
                    alert("浏览器版本过低")
                }
            }
        }
        function chk_name() {
            var username = document.getElementById("username").value;
            //ajax访问后台，局部刷新，页面其他位置不会发生变化
            var xmlh = creatXml();

            xmlh.open("get","ExistServlet?username="+username,true);

            xmlh.send(null);

            var isTrue = true;//监听用户名是否通过

            xmlh.onreadystatechange = function () {
                //后台状态码发生变化，就会进入func
                if(xmlh.readyState == 4 && xmlh.status == 200){//后台代码200表示成功
                    //后台执行结束并执行正确
                    var msg = xmlh.responseText;
                    document.getElementById("name_msg").innerHTML = msg;//后台响应文本转到前台
                    if(msg == "用户名已被占用"){
                        isTrue = false;
                    }
                }
            }
            return isTrue;
        }
        function chk(){
            var msg = document.getElementById("msg_name").innerHTML;
            if(chk_pwd() && chk_name() && msg != "用户名已被占用"){
                return true;
            }else{
                return false;
            }
        }
    </script>
</head>
<body>
    <%--顶部导航栏--%>
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
            </button>
            <a class="navbar-brand" href="#">小怀超市商品管理系统</a>
        </div>
        <%--<div>
            <p class="navbar-text">${username} Name</p>
            <p class="navbar-text">${creattime} Date</p>
        </div>--%>
    </nav>
    <div class="ex1">
        <div class="box">
            <h2>注册</h2>
            <form action="/RegisterServlet" method="post" onsubmit="chk()">
                <div class="inputbox">
                    <input type="text" name="username" required="">
                    <label>用户名</label><span style="color: red">${msg}</span>
                </div>
                <div class="inputbox">
                    <input type="password" name="password" required="">
                    <label>密码</label>
                </div>
                <div class="inputbox">
                    <input type="password" name="pwd_c" required="" onblur="chk_pwd()">
                    <label>确认密码</label>
                </div>

                    <input  class="btn btn-default" type="submit" name="" value="注册">
                    <a class="btn btn-default" style="float: right" href="login.jsp">取消</a>

            </form>

        </div>

    </div>


</body>
</html>
