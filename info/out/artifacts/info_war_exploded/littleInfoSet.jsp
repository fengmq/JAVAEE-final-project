<%@ page import="server.queryStudentInfo" %>
<%@ page import="server.queryStudentInfoImpl" %>
<%@ page import="model.relative" %>
<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page import="java.awt.*" %><%--
  Created by IntelliJ IDEA.
  User: fengmq
  Date: 2019/10/9
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link  rel="stylesheet"  href="css/littleInfoSet.css" type="text/css" />
    <script src="js/jquery-3.4.1.js"></script>
<%
    HttpSession hs=request.getSession();
    User u= (User) hs.getAttribute("user");
    System.out.println("----------------信息维护！---------------------");
    queryStudentInfo qsi=new queryStudentInfoImpl();
    List<relative> Lr=qsi.queryRelation(u.getId());
%>
</head>
<script type="text/javascript">
    function  up() {
        $.ajax({
            type:"POST",
            url:"/info/updatePwd",
            dataType:"json",
            data:$('#formId').serialize(),
            success:function (data) {
                var s=data.state;
                if(s=="oldPwd_error")
                {
                    alert("旧密码错误！");
                }
                    else if(s=="confirm_error"){
                        alert("密码确认错误");
                }
                    else if(s=="true")
                {
                 alert("密码修改成功！")   ;
                }

                // var parsedJson = jQuery.parseJSON(data);
                // alert("aa"+parsedJson.message);
            }
        });
        return false;
    }
</script>
<script type="text/javascript">
    function updateInfo() {
        $.ajax({
            type:"POST",
            url:"/info/updateInfo",
            dataType:"json",
            data:$('#forId').serialize(),
            success:function (data) {
                alert("信息修改成功！");
            },
            error:function () {
                alert("有未知错误！");
            }
        });
        return false;
    }
</script>
<script type="text/javascript">
    function  updateRelation(){
        $.ajax({
            type:"POST",
            url:"/info/updateRelation",
            dataType:"json",
            data:$('#formId2').serialize(),
            success:function (data) {
                alert("信息修改成功！");
            },
            error:function () {
                alert("有未知错误！");
            }
        });
        return false;
    }
</script>
<body style="background: lavender">
<table style="height: 100%;width: 100%"  rules="cols" >
    <div style="width: 100%;height: 20px;">
        <h3 style="display:inline-block;width: 30%;text-align: center;padding-top: 10px">个人信息维护</h3>
        <h3 style="display:inline-block;width: 40%;text-align: center;padding-top: 10px">家庭成员信息维护</h3>
        <h3 style="display:inline-block;width: 25%;text-align: center;padding-top: 10px">密码修改</h3>
    </div>
    <tr style="height: max-content">
        <td style="width: 30%;padding-top: 0px">

            <form id="forId"  method="post" onsubmit="return updateInfo()">
                <div class="info">
                    <label class="label3">姓&emsp;&emsp;名</label>
                    <input class="input1" type="text" name="name1" value="<%=u.getName()%>" >
                </div>
                <div class="info">
                    <label class="label3">性&emsp;&emsp;别</label>
                    <input class="input1" type="text" name="sex" value="<%=u.getSex()%>">
                </div>
                <div class="info">
                    <label class="label3" >生&emsp;&emsp;日</label>
                    <input class="input1" type="text" name="birth" value="<%=u.getBirth()%>">
                </div>
                <div class="info">
                    <label class="label3">电&emsp;&emsp;话</label>
                    <input class="input1" type="text" name="phone" value="<%=u.getPhone()%>">
                </div>
                <div class="info">
                    <label class="label3">籍&emsp;&emsp;贯</label>
                    <input class="input1" type="text" name="native_" value="<%=u.getNative_place()%>">
                </div>
                <div class="info">
                    <label class="label3">政治面貌</label>
                    <input class="input1" type="text" name="politics" value="<%=u.getPolitics_status()%>">
                </div>
                <div class="info">
                    <label class="label3">Q Q&emsp;&emsp;  </label>
                    <input class="input1" type="text" name="qq" value="<%=u.getQq()%>">
                </div>
                <div class="info">
                    <label class="label3">邮&emsp;&emsp;箱</label>
                    <input class="input1" type="text" name="email" value="<%=u.getEmail()%>">
                </div>
                <div class="info">
                <input style="background: #4CAF50; padding: 8px;width: 180px;text-align: center; border-radius: 5px;"
                       type="button" value="确定" onclick="updateInfo()">
            </div>
            </form>

        </td>
        <td style="width: 40%">
            <form id="formId2"  method="post" onsubmit="return updateRelation()">
                <table style="alignment: center" border="1" cellspacing="0" cellpadding="4">

                    <tr>
                        <th style="width: 80px;height: 40px">姓名</th>
                        <th style="width: 80px;height: 40px">关系</th>
                        <th style="width: 80px;height: 40px">年龄</th>
                        <th style="width: 220px;height:40px">工作单位</th>
                    </tr>
                    <%
                        int i=0;
                        for(i=0;i<Lr.size();i++)
                        {
                            relative rl=Lr.get(i);
                            String name1="name"+i;
                            String name2="relation"+i;
                            String name3="age"+i;
                            String name4="work"+i;
                     %>
                    <tr>
                        <td><input style="border:none;background: lavender;height: 40px;width: 80px;text-align: center" type="text" value="<%=rl.getName()%>" name=<%=name1%>></td>
                        <td><input style="border:none;background: lavender;height: 40px;width: 80px;text-align: center" type="text" value="<%=rl.getRelation()%>"name=<%=name2%>></td>
                        <td><input style="border:none;background: lavender;height: 40px;width: 80px;text-align: center" type="text" value="<%=rl.getAge()%>"name=<%=name3%>></td>
                        <td><input style="border:none;background: lavender;height: 40px;width: 250px;text-align: center" type="text" value="<%=rl.getWork_unit()%>"name=<%=name4%>></td>
                    </tr>
                    <% } %>
                    <%
                        for(int j=i;j<5;j++){
                            String name1="name"+j;
                            String name2="relation"+j;
                            String name3="age"+j;
                            String name4="work"+j;
                    %>
                    <tr>
                        <td><input style="border:none;background: lavender;height: 40px;width: 80px;text-align: center" type="text"  name=<%=name1%>></td>
                        <td><input style="border:none;background: lavender;height: 40px;width: 80px;text-align: center" type="text"  name=<%=name2%>></td>
                        <td><input style="border:none;background: lavender;height: 40px;width: 80px;text-align: center" type="text"  name=<%=name3%>></td>
                        <td><input style="border:none;background: lavender;height: 40px;width: 250px;text-align: center" type="text"  name=<%=name4%>></td>
                    </tr>
                    <%}%>
                    <h5 ><span style="color: #00bfff">*请按照父母、兄弟、姐妹，祖父母，外祖父母的顺序填写,最多五个</span></h5><br>
                </table>
                <div class="info">
                <input style="background: #4CAF50; margin-top:50px;padding:8px;width: 180px;text-align: center; border-radius: 5px;" type="button" value="确定" onclick="updateRelation()">
                </div>
            </form>
        </td>
        <td style="width: 30%">
                        <form id="formId"  method="post" onsubmit="return up()">
                            <div style="margin-top: 90px" class="info">
                                <label class="label3">旧密码&emsp;:</label>
                                <input class="input1" type="password" name="oldPwd" required="required">
                            </div>
                            <div class="info">
                                <label class="label3">新密码&emsp;:</label>
                                <input class="input1" type="password" name="newPwd" required="required">
                            </div>
                            <div class="info">
                                <label class="label3">确认密码:</label>
                                <input class="input1" type="password" name="confirm_newPwd" required="required">
                            </div>
                            <div class="info">
                            <input style="background: #4CAF50; margin-top:80px;padding: 8px;width: 180px;text-align: center; border-radius: 5px;"
                                   type="button" value="确定" onclick="up()">
                            </div>
                        </form>
        </td>
    </tr>
</table>

</body>
</html>
