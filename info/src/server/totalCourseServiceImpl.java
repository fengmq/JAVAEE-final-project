package server;

import dao.totalCourseDao;
import dao.totalCourseDaoImpl;
import model.total_course;

import java.util.List;

public class totalCourseServiceImpl implements totalCourseService {
    @Override
    public List<total_course> query() {
        totalCourseDao ttcD=new totalCourseDaoImpl();
        return ttcD.query();
    }

    @Override
    public total_course query_one(int id) {
        totalCourseDao ttc=new totalCourseDaoImpl();
        return ttc.query_one(id);
    }
}
