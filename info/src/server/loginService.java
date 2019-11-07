package server;

import model.User;

public interface loginService {
    User checkLogin(String name,String pwd);
}
