package servlet;

import model.User;
import net.sf.json.JSONObject;
import server.queryStudentInfo;
import server.queryStudentInfoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "updatePwdServlet")
public class updatePwdServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("--------------updatePwdServlet-----------------");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //获取请求信】
        HttpSession hs=req.getSession();
        User u= (User) hs.getAttribute("user");
        int id=u.getId();
        String oldPwd=req.getParameter("oldPwd");
        String newPwd=req.getParameter("newPwd");
        String confirm_newPwd=req.getParameter("confirm_newPwd");
        //处理请求
        if(!oldPwd.equals(u.getPwd()))
        {
            String a="{\"state\":\"oldPwd_error\"}";
            resp.getWriter().print(a);
            return;
        }
        if(!newPwd.equals(confirm_newPwd))
        {
            String a="{\"state\":\"confirm_error\"}";
            resp.getWriter().print(a);
            return;
        }
        queryStudentInfo qsi=new queryStudentInfoImpl();
        qsi.updatePwd(newPwd,id);

        //响应
        String a="{\"state\":\"true\"}";
        resp.getWriter().print(a);
//        System.out.println(1);
//        JSONObject jsonObject=new JSONObject();
//        System.out.println(2);
//        jsonObject.put("message","updatePwd");
//        System.out.println(3);
//        resp.getWriter().print(jsonObject);
//        System.out.println(4);
    }


}
