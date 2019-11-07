package dao;

import model.User;

import java.sql.*;

public class userDaoImpl implements userDao{
    @Override
    public User checkLoginDao(String name, String pwd)
    {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        User u=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=GMT","root","root");
            String  sql="select * from users where name=? and pwd=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,pwd);
            rs=ps.executeQuery();
            while(rs.next())
            {
                u=new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setSex(rs.getString("sex"));
                u.setPwd(rs.getString("pwd"));
                u.setBirth(rs.getDate("birth"));
                u.setNative_place(rs.getString("native_place"));
                u.setPhone(rs.getString("phone"));
                u.setPolitics_status(rs.getString("politics_status"));
                u.setQq(rs.getString("qq"));
                u.setEmail(rs.getString("email"));
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
        return u;
    }

    @Override
    public String addDao(String name, String pwd) {
        Connection conn=null;
        PreparedStatement ps=null;
        User u=checkLoginDao(name,pwd);
        if(u!=null)
        {
            return  "have registered";
        }
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=GMT","root","root");
            String  sql="insert into users values(default,?,?,default,null,null,null,null,null,null)";
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,pwd);
            ps.executeUpdate();
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
  return "success";
    }

    @Override
    public boolean updatePwd(String newPwd,int id) {
        Connection conn=null;
        PreparedStatement ps=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=GMT","root","root");
            String  sql="update users set pwd=? where id=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,newPwd);
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

    @Override
    public boolean update(User u) {
        Connection conn=null;
        PreparedStatement ps=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=GMT","root","root");
            String  sql="update users set name=?,sex=?,phone=?,politics_status=?,birth=?,native_place=?,qq=?,email=? where id=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,u.getName());
            ps.setString(2,u.getSex());
            ps.setString(3,u.getPhone());
            ps.setString(4,u.getPolitics_status());
            ps.setDate(5,new java.sql.Date(u.getBirth().getTime()));
            ps.setString(6,u.getNative_place());
            ps.setString(7,u.getQq());
            ps.setString(8,u.getEmail());
            ps.setInt(9,u.getId());
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
