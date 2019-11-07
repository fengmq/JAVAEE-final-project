package server;

import model.User;
import model.course;
import model.relative;
import model.total_course;

import java.util.List;

public interface queryStudentInfo{
    public List<course> queryScore( int id);
    public List<relative> queryRelation(int id);
    public boolean updatePwd(String newPwd,int id);
    public boolean updateInfo(User u);
    public boolean insert(int id,relative rl[]);
    public boolean select( int id,total_course ttc);
}
