package servlet;

import model.User;
import model.total_course;
import server.queryStudentInfo;
import server.queryStudentInfoImpl;
import server.totalCourseService;
import server.totalCourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "selectCourseServlet")
public class selectCourseServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("--------------selectCourseServlet-----------------");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //获取请求信息
        HttpSession hs=req.getSession();
        User u= (User) hs.getAttribute("user");
        String i=req.getParameter("courseId");
        System.out.println(i);
        //处理
            //查询
        totalCourseService ttcS=new totalCourseServiceImpl();
        total_course ttc= ttcS.query_one(Integer.parseInt(i));
            //增加
        queryStudentInfo qsi=new queryStudentInfoImpl();
        qsi.select(u.getId(),ttc);
        String a="{\"state\":\"true\"}";
        resp.getWriter().print(a);
    }
}
