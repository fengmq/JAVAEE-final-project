<%@ page import="model.User" %>
<%@ page import="server.queryStudentInfo" %>
<%@ page import="server.queryStudentInfoImpl" %>
<%@ page import="model.course" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: fengmq
  Date: 2019/10/9
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<%
    HttpSession hs=request.getSession();
    User u= (User) hs.getAttribute("user");
   int id=u.getId();
   String name =u.getName();
   System.out.println("--------------成绩查询！---------------");
%>
</head>
<body style="background:lavenderblush ">
<%
    queryStudentInfo qsi=new queryStudentInfoImpl();
    List<course> Lc=qsi.queryScore(id);
%>
<div style="margin-left: 5px;margin-top: 10px;height: 95%;overflow-y: scroll;background: lavender;border: solid 5px skyblue;" >
    <table width="98%" border="1" cellspacing="0" cellpadding="4" style="border-collapse: collapse;margin-left: 10px" >
        <caption><h3>个人成绩</h3></caption>
        <tbody>
            <tr>
                <th>课程名称</th>
                <th>分数</th>
                <th>是否及格</th>
                <th>GPA</th>
                <th width="750px">备注</th>
            </tr>
        <%for(int i=0;i<Lc.size();i++){
            course c=Lc.get(i);
            String state="是";
            String msg="";
            int score=c.getScore();
            if( c.getScore()<60)
                state="否";
            if(score==0)
            {
                state="";
                msg="暂无成绩";
            }
            System.out.println(c.getCourse_name());%>
            <tr>
                <td align="center"><%=c.getCourse_name()%></td>
                <td align="center"><%=c.getScore()%></td>
                <td align="center"><%=state%></td>
                <td align="center"><%=c.getGPA()%></td>
                <td width="750px" style="text-align: center"><%=msg%></td>
            </tr>
        <%}%>
        </tbody>
    </table>
</div>
</body>
</html>
