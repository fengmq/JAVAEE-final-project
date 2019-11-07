package dao;

import model.relative;

import java.util.List;

public interface relativeDao {
   /**
    * 根据学生ID查询所有的家属
    * @param id
    * @return
    */
   List<relative> query(int id);

   boolean insert(int id,relative r[]);
}
