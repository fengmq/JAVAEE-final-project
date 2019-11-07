<%@ page import="server.queryStudentInfo" %>
<%@ page import="server.queryStudentInfoImpl" %><%--
  Created by IntelliJ IDEA.
  User: fengmq
  Date: 2019/10/6
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String url=request.getSession().getServletContext().getRealPath("/");%>

<html>
<head>
    <title>信息管理系统</title>
    <link  rel="stylesheet"  href="css/login.css" type="text/css" />
    <base herf=<%=url%>>
</head>
<body>
<script>
    function tip() {
        alert("用户名或密码错误！ ")
    }
</script>
<%
    HttpSession hs=request.getSession();
    String a= (String) hs.getAttribute("error");
//   String b= (String) request.getAttribute("error");
//   System.out.println("session:"+a+"\nrequest:"+b);
    if(a!=null)
    {%>
        <script>
            tip();
        </script>
<%    }%>
<div class="login">
    <div class="topic">
        <p>欢迎登陆信息管理系统</p>
    </div>
    <div style="alignment: center">
        <form method="post" action="/info/login">
            <div class="div_box">
               <span class="margin_right10">用户名 </span>  <input type="text" name="name" placeholder="请输入用户名" required="required" />
            </div>
            <div class="div_box">
               <span class="margin_right10">密&emsp;码 </span> <input type="password" name="pwd" placeholder="请输入密码" required="required" />
            </div>
            <div style="height: 30px"> </div>
            <div class="div_box">
             <button type="submit" class="btn btn-primary btn-block btn-large">登录</button>
            </div>
        </form>
    </div>
    <h5 style="padding-left: 220px">还没有账户？<a href="register.jsp">去注册</a></h5>
</div>
</body>
</html>
