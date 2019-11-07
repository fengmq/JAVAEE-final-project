package server;

import dao.userDao;
import dao.userDaoImpl;

public class registerServiceImpl implements registerService {
    @Override
    public String add(String name, String pwd) {
        userDao userdao=new userDaoImpl();
        String state=userdao.addDao(name,pwd);
        return state;
    }
}
