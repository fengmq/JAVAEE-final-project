<%--
  Created by IntelliJ IDEA.
  User: fengmq
  Date: 2019/10/6
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息管理系统</title>
    <link  rel="stylesheet"  href="css/register.css" type="text/css" />
</head>
<body>
<script>
    function tip1() {
        alert("已经注册过了")
    }
    function tip2(int ) {
        alert("注册成功！")
    }
</script>

<%
    HttpSession hs=request.getSession();
    String state= (String) hs.getAttribute("state");
    if(state!=null&&state.equals("success")) {
%>
        <script>
            tip2()
        </script>
<%  }
    else if(state!=null&&state.equals("have registered"))
    {
%>
        <script>
            tip1()
        </script>
<%
    }
%>
<div class="login">
    <div class="topic">
        <p>欢迎注册信息管理系统</p>
    </div>
    <div style="alignment: center">
        <form method="post" action="/info/register">
            <div class="div_box">
                <span class="margin_right10">用户名 </span>  <input type="text" name="name" placeholder="请输入用户名" required="required" />
            </div>
            <div class="div_box">
                <span class="margin_right10">密&emsp;码 </span> <input type="password" name="pwd" placeholder="请输入密码" required="required" />
            </div>
            <div style="height: 30px"> </div>
            <div class="div_box">
                <button type="submit" class="btn btn-primary btn-block btn-large">注册</button>
            </div>
        </form>
    </div>
    <h5 style="padding-left: 220px">已有账户？<a href="login.jsp">去登录</a></h5>
</div>
</body>
</html>
