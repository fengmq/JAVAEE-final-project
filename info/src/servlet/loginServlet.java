package servlet;

import model.User;
import server.loginService;
import server.loginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class loginServlet extends javax.servlet.http.HttpServlet {
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
        loginService ls=new loginServiceImpl();
        User u=ls.checkLogin(name,pwd);

        //响应请求
        if(u!=null)
        {
            u.show();
            HttpSession hs=req.getSession();
            hs.setAttribute("user",u);
            resp.sendRedirect("/info/mainPage.jsp");
        }
        else
        {
            HttpSession hs=req.getSession();
            hs.setAttribute("error","user or password error!");
//            req.setAttribute("error","user or password error!"); //使用req传递参数也可以！
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;

        }
    }
}
