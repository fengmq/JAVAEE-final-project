package dao;

import model.course;
import model.total_course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class courseDaoImpl implements courseDao {

    @Override
    public List<course> selectScore(int id) {
        List<course>  courseList=new ArrayList<>();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=GMT","root","root");
            String  sql="select * from course where users_key=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next())
            {
                course c=new course();
                c.setId(rs.getInt("id"));
                c.setScore(rs.getInt("score"));
                c.setCourse_name(rs.getString("course_name"));
                c.setUser(rs.getInt("users_key"));
                courseList.add(c);
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
        return courseList;
    }

    @Override
    public boolean add(int id, total_course ttc) {
        Connection conn=null;
        PreparedStatement ps=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=GMT","root","root");
            String  sql="insert into course values(default,?,null,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1,ttc.getCourse_name());
            ps.setInt(2,id);
            ps.executeUpdate();
        }catch(Exception e)
        {
            e.printStackTrace();
            try {
                conn.rollback();//回滚
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
