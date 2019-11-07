package servlet;

import server.registerService;
import server.registerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        //获取请求信息
        String name=req.getParameter("name");
        String pwd=req.getParameter("pwd");
        System.out.println(name +"  "+ pwd);
        //处理请求
        registerService rs=new registerServiceImpl();
        String state=rs.add(name,pwd);
        HttpSession hs=req.getSession();
        hs.setAttribute("state",state);
        resp.sendRedirect("/info/register.jsp");
    }
}
