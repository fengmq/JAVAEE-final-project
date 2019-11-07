package dao;

import model.course;
import model.total_course;

import java.util.List;

public interface courseDao {
    List<course> selectScore(int id);

    boolean add(int id, total_course ttc);
}
