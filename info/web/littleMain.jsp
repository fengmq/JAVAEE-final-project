<%--
  Created by IntelliJ IDEA.
  User: fengmq
  Date: 2019/10/9
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<script>
    var arr=["/info/pictures/0.jpg","/info/pictures/1.jpg","/info/pictures/2.jpg","/info/pictures/3.jpg"];
    var i=0;
    var ob;
    function up() {
        if(i>3)  i=0;
        ob=document.getElementById("img1");
        ob.src=arr[i];
        i++;
    }
</script>
</head>
<body style="background: pink;"  onload="window.setInterval(up,1500)">
    <div style="height: 100%;">
        <table border="1" cellspacing="0" cellpadding="4" style="border: 2px #00bfff;border-collapse: collapse; margin-left:20px;display:inline-block;height: 500px;width: 600px;">
            <h2 style="text-align: center">校园通知</h2>
            <tr><td width="600px">关于---的通知</td></tr>
            <tr><td width="600px">关于---的通知</td></tr>
            <tr><td width="600px">关于---的通知</td></tr>
            <tr><td width="600px">关于---的通知</td></tr>
            <tr><td width="600px">关于---的通知</td></tr>
        </table>
        <img style="display:inline-block;height: 500px;width: 600px" id="img1" src="/info/pictures/0.jpg">
    </div>
</body>
</html>
