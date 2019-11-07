package dao;

import model.course;
import model.total_course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class totalCourseDaoImpl implements totalCourseDao {
    @Override
    public List<total_course> query() {
        List<total_course>  ttc=new ArrayList<total_course>();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=GMT","root","root");
            String  sql="select * from total_course";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next())
            {
                total_course c=new total_course();
                c.setId(rs.getInt("id"));
                c.setCourse_name(rs.getString("course_name"));
                c.setTeacher(rs.getString("teachers"));
                c.setCredit(rs.getInt("credit"));
                ttc.add(c);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                ps.close();
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return ttc;
    }

    @Override
    public total_course query_one(int id) {
        total_course  c=new total_course();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=GMT","root","root");
            String  sql="select * from total_course where id=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next())
            {
                c.setId(rs.getInt("id"));
                c.setCourse_name(rs.getString("course_name"));
                c.setTeacher(rs.getString("teachers"));
                c.setCredit(rs.getInt("credit"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                ps.close();
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return c;
    }
}
