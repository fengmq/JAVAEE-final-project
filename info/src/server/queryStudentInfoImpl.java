package server;

import dao.*;
import model.User;
import model.course;
import model.relative;
import model.total_course;

import java.util.List;

public class queryStudentInfoImpl implements queryStudentInfo {
    @Override
    public List<course> queryScore(int id) {
        courseDao  cd=new courseDaoImpl();
        return cd.selectScore(id);
    }

    @Override
    public List<relative> queryRelation(int id) {
        relativeDao rd=new relativeDaoImpl();
        return rd.query(id);
    }

    @Override
    public boolean updatePwd(String newPwd, int id) {
        userDao ud=new userDaoImpl();
        return ud.updatePwd(newPwd, id);
    }

    @Override
    public boolean updateInfo(User u) {
        userDao ud=new userDaoImpl();
        return ud.update(u);
    }


    @Override
    public boolean insert(int id,relative rl[]) {
        System.out.println("-----------------queryStudentInfoImpl-------------------");
        relativeDao rd=new relativeDaoImpl();
        return rd.insert(id,rl);
    }

    @Override
    public boolean select( int id,total_course ttc) {
        courseDao cd=new courseDaoImpl();
        return cd.add(id,ttc);
    }

}
