<%@ page import="server.totalCourseService" %>
<%@ page import="server.totalCourseServiceImpl" %>
<%@ page import="model.total_course" %>
<%@ page import="java.util.List" %>
<%@ page import="model.course" %>
<%@ page import="server.queryStudentInfoImpl" %>
<%@ page import="server.queryStudentInfo" %>
<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: fengmq
  Date: 2019/10/13
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/info/js/jquery-3.4.1.js"></script>
    <%
        //        数据库所有的课程
        totalCourseService ttcS=new totalCourseServiceImpl();
        List<total_course> ttc=ttcS.query();
        //        学生选的课程
        HttpSession hs=request.getSession();
        User u= (User) hs.getAttribute("user");
        queryStudentInfo qsi=new queryStudentInfoImpl();
        List<course> Lc=qsi.queryScore(u.getId());
        int len=ttc.size();
    %>
</head>
<body style="background: pink;">
<script>
    function course_click(i)
    {
        var target="btn"+i;
        $.ajax({
            type:"GET",
            url:"/info/selectCourse",
            dataType:"json",
            data:{courseId:i},
            success:function (data) {
                alert("选课成功！");
                var butOff=document.getElementById(target);
                butOff.disabled =true;
                butOff.style.background="#dcdfe6";
            }
        });
    }
    function confirm_selected(i) {
        var target="btn"+(i+1);
        var butOff=document.getElementById(target);
        butOff.disabled =true;
        butOff.style.background="#dcdfe6";
    }
</script>
    <table border="1" cellspacing="0" cellpadding="4" style="border-collapse: collapse; width: 100%;height: 100%;">
        <tr style="height: max-content">
            <td style="width: 20%">
                    <%
                        int ls=4;
                        String idBtn;
                        if(ls>len)
                            ls=len;
                        for(int i=0;i<ls;i++){
                            idBtn="btn"+(i+1);
                            total_course ttcC=ttc.get(i);
                        %>
                            <div style="margin:20px;width: 200px;height: 100px;background-color: #fff;opacity: 0.8;">
                                <p style="font-size: 15px"><%=ttcC.getCourse_name()%></p>
                                <p style="font-size: 15px">代课老师：<%=ttcC.getTeacher()%></p>
                                <button id=<%=idBtn%> onclick="course_click(<%=i+1%>)" style="border-radius: 5px;background: aquamarine;margin-left: 150px">选课</button>
                            </div>
<%--                            将已经选的课程按钮disable=true--%>
                            <%
                                for(int j=0;j<Lc.size();j++)
                                {
                                    course cou=Lc.get(j);
                                    if(cou.getCourse_name().equals(ttcC.getCourse_name()))
                                    {
                            %>
                                    <script>
                                        confirm_selected(<%=i%>);
                                    </script>
                            <% break;}}%>

                        <%}%><%--//大for--%>

            </td>
            <td style="width: 20%">
                <%
                     ls=8;
                    if(ls>len)
                        ls=len;
                    for(int i=4;i<ls;i++){
                         idBtn="btn"+(i+1);
                        total_course ttcC=ttc.get(i);
                %>
                <div style="margin:20px;width: 200px;height: 100px;background-color: #fff;opacity: 0.8;">
                    <p style="font-size: 15px"><%=ttcC.getCourse_name()%></p>
                    <p style="font-size: 15px">代课老师：<%=ttcC.getTeacher()%></p>
                    <button id=<%=idBtn%> onclick="course_click(<%=i+1%>)" style="border-radius: 5px;background: aquamarine;margin-left: 150px">选课</button>
                </div>
                <%--                            将已经选的课程按钮disable=true--%>
                <%
                    for(int j=0;j<Lc.size();j++)
                    {
                        course cou=Lc.get(j);
                        if(cou.getCourse_name().equals(ttcC.getCourse_name()))
                        {
                %>
                <script>
                    confirm_selected(<%=i%>);
                </script>
                <% break;}}%>
                <%}%>
            </td>
            <td style="width: 20%">
                <%
                    ls=12;
                    if(ls>len)
                        ls=len;
                    for(int i=8;i<ls;i++){
                        idBtn="btn"+(i+1);
                        total_course ttcC=ttc.get(i);
                %>
                <div style="margin:20px;width: 200px;height: 100px;background-color: #fff;opacity: 0.8;">
                    <p style="font-size: 15px"><%=ttcC.getCourse_name()%></p>
                    <p style="font-size: 15px">代课老师：<%=ttcC.getTeacher()%></p>
                    <button id=<%=idBtn%> onclick="course_click(<%=i+1%>)" style="border-radius: 5px;background: aquamarine;margin-left: 150px">选课</button>
                </div>
                <%--                            将已经选的课程按钮disable=true--%>
                <%
                    for(int j=0;j<Lc.size();j++)
                    {
                        course cou=Lc.get(j);
                        if(cou.getCourse_name().equals(ttcC.getCourse_name()))
                        {
                %>
                <script>
                    confirm_selected(<%=i%>);
                </script>
                <% break;}}%>
                <%}%>
            </td>
            <td style="width: 20%">
                <%
                    ls=16;
                    if(ls>len)
                        ls=len;
                    for(int i=12;i<ls;i++){
                        idBtn="btn"+(i+1);
                        total_course ttcC=ttc.get(i);
                %>
                <div style="margin:20px;width: 200px;height: 100px;background-color: #fff;opacity: 0.8;">
                    <p style="font-size: 15px"><%=ttcC.getCourse_name()%></p>
                    <p style="font-size: 15px">代课老师：<%=ttcC.getTeacher()%></p>
                    <button id=<%=idBtn%> onclick="course_click(<%=i+1%>)" style="border-radius: 5px;background: aquamarine;margin-left: 150px">选课</button>
                </div>
                <%--                            将已经选的课程按钮disable=true--%>
                <%
                    for(int j=0;j<Lc.size();j++)
                    {
                        course cou=Lc.get(j);
                        if(cou.getCourse_name().equals(ttcC.getCourse_name()))
                        {
                %>
                <script>
                    confirm_selected(<%=i%>);
                </script>
                <% break;}}%>
                <%}%>
            </td>
            <td style="width: 20%">
                <%
                    ls=20;
                    if(ls>len)
                        ls=len;
                    for(int i=16;i<ls;i++){
                       idBtn="btn"+(i+1);
                        total_course ttcC=ttc.get(i);
                %>
                <div style="margin:20px;width: 200px;height: 100px;background-color: #fff;opacity: 0.8;">
                    <p style="font-size: 15px"><%=ttcC.getCourse_name()%></p>
                    <p style="font-size: 15px">代课老师：<%=ttcC.getTeacher()%></p>
                    <button id=<%=idBtn%> onclick="course_click(<%=i+1%>)" style="border-radius: 5px;background: aquamarine;margin-left: 150px">选课</button>
                </div>
                <%--                            将已经选的课程按钮disable=true--%>
                <%
                    for(int j=0;j<Lc.size();j++)
                    {
                        course cou=Lc.get(j);
                        if(cou.getCourse_name().equals(ttcC.getCourse_name()))
                        {
                %>
                <script>
                    confirm_selected(<%=i%>);
                </script>
                <% break;}}%>
                <%}%>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
