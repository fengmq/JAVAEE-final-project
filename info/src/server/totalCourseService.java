package server;

import model.total_course;

import java.util.List;

public interface totalCourseService {
    public List<total_course> query();
    public total_course query_one(int id);
}
