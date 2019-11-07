package dao;

import model.User;

public interface userDao {
    User checkLoginDao(String name, String pwd);
    String  addDao(String name,String pwd);
    boolean updatePwd(String newPwd,int id);
    boolean update(User u);
}
