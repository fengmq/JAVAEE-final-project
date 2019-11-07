<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: fengmq
  Date: 2019/10/7
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息管理系统</title>
    <link  rel="stylesheet"  href="css/mainPage.css" type="text/css" />
<%
    HttpSession hs=request.getSession();
    User u= (User) hs.getAttribute("user");
%>
</head>
<body>

    <div class="system_pic">
        <h1 class="label1">信息管理系统</h1>
        <h3 class="label2">欢迎您：<%=u.getName()%></h3>
    </div>
    <div style="height: 10px;background: lightcyan"></div>
    <div style="height: 580px;width:100%;background: lightcyan">
        <div   style="vertical-align: top;margin-left:10px;width: 15%; height: 550px;display: inline-block;" >
            <ul>
                <li><a class="active" href="littleMain.jsp" target="iframe1">主页</a></li>
                <li><a href="littleScore.jsp" target="iframe1">成绩查询</a></li>
                <li><a href="littleSelect.jsp" target="iframe1">选课界面</a></li>
                <li><a href="littleInfoSet.jsp" target="iframe1">信息维护</a></li>
            </ul>
        </div>
        <div style="vertical-align: top;width: 84%;height: 580px;display: inline-block">
            <iframe style="height:570px;width: 99%"  name="iframe1" src="littleMain.jsp ">浏览器不支持，请使用谷歌或者火狐！</iframe>
        </div>
    </div>
</body>
</html>
