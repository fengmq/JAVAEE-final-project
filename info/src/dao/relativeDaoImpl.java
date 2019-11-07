package dao;

import model.User;
import model.course;
import model.relative;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class relativeDaoImpl implements relativeDao{
    @Override
    public List<relative> query(int id) {
        List<relative> relativesList=new ArrayList<>();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=GMT","root","root");
            String  sql="select * from relative where student_id=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next())
            {
                relative c=new relative();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setRelation(rs.getString("relation"));
                c.setAge(rs.getInt("age"));
                c.setStudent_id(id);
                c.setWork_unit(rs.getString("work_unit"));
                relativesList.add(c);
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
        return relativesList;
    }

    @Override
    public boolean insert(int id,relative r[]) {
        Connection conn=null;
        PreparedStatement ps=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=GMT","root","root");
            String sql1="delete from relative where student_id=?";
            ps=conn.prepareStatement(sql1);
            ps.setInt(1,id);
            ps.executeUpdate();
            for(int i=0;i<r.length;i++) {
                if(r[i]!=null) {
                    String sql2 = "insert into relative values(default,?,?,?,?,?)";
                    ps = conn.prepareStatement(sql2);
                    ps.setString(1, r[i].getName());
                    ps.setInt(2, r[i].getAge());
                    ps.setInt(3, id);
                    ps.setString(4, r[i].getWork_unit());
                    ps.setString(5, r[i].getRelation());
                    ps.executeUpdate();
                }
            }

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
