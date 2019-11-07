package server;

import dao.userDao;
import dao.userDaoImpl;
import model.User;

public class loginServiceImpl implements loginService{
    userDao userdao=new userDaoImpl();
    @Override
    public User checkLogin(String name, String pwd) {
        return userdao.checkLoginDao(name,pwd);
    }
}
