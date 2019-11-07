package servlet;

import model.User;
import model.relative;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import server.queryStudentInfo;
import server.queryStudentInfoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "updateRelationServlet")
public class updateRelationServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("--------------updateRelationServlet-----------------");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //获取请求信息
        HttpSession hs=req.getSession();
        User u= (User) hs.getAttribute("user");
        String info[][]=new String[5][5];
        for( int i=0;i<5;i++)
        {
            String name1="name"+i;
            String name2="relation"+i;
            String name3="age"+i;
            String name4="work"+i;
            info[i][0] = req.getParameter(name1);
            info[i][1] = req.getParameter(name2);
            info[i][2] = req.getParameter(name3);
            info[i][3] = req.getParameter(name4);
        }
        //处理请求
            //生成关系对象
            relative rl[]=new relative[5];
            for(int i=0;i<5;i++)
            {
                rl[i]=null;
            }
            for(int i=0;i<5;i++) {
                if (!info[i][0].equals("")) {
                    rl[i]=new relative();
                    rl[i].setInfo(info[i][0], info[i][1], Integer.parseInt(info[i][2]), u.getId(), info[i][3]);
                    rl[i].show();
                }
            }
            queryStudentInfo qsi=new queryStudentInfoImpl();
             //先delete所有关系，再insert
             qsi.insert(u.getId(),rl);
        //响应
        String a="{\"state\":\"true\"}";
        resp.getWriter().print(a);
    }
}
