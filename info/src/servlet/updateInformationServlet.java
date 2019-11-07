package servlet;

import model.User;
import server.queryStudentInfo;
import server.queryStudentInfoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "updateInformationServlet")
public class updateInformationServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("--------------updateInformationServlet-----------------");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //获取请求信息
        HttpSession hs=req.getSession();
        User u= (User) hs.getAttribute("user");

        String name=req.getParameter("name1");
        String sex=req.getParameter("sex");
        String bir=req.getParameter("birth");
        Date date=null;
        if(!bir.equals(""))
        {
            DateFormat format=new SimpleDateFormat("yyyy-MM-dd");

            try {
                date = format.parse(bir);
            } catch (ParseException e) {
                e.printStackTrace();
            }
         }
        String phone=req.getParameter("phone");
        String native_=req.getParameter("native_");
        String politics=req.getParameter("politics");
        String qq=req.getParameter("qq");
        String email=req.getParameter("email");

        System.out.println(name+"\n"+sex+"\n"+bir+"\n"+phone+"\n"+native_+"\n"+politics+"\n"+qq+"\n"+email);
        //响应
        User user=new User();
        user.set(u.getId(),u.getPwd(),name,sex,date,phone,native_,politics,qq,email);
        queryStudentInfo qsi=new queryStudentInfoImpl();
        qsi.updateInfo(user);
        hs.setAttribute("user",user);
        String a="{\"state\":\"true\"}";
        resp.getWriter().print(a);

    }
}
