package dao;

import model.total_course;

import java.util.ArrayList;
import java.util.List;

public interface totalCourseDao {
    List<total_course> query();
    total_course query_one( int id);

}
