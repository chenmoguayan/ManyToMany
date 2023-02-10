package org.qingqiao.mapper;

import org.apache.ibatis.annotations.Param;
import org.qingqiao.bean.Course;
import org.qingqiao.bean.Student;

import java.util.List;

/**
 * @author hj
 * @data 2023/2/9 14:14
 */
public interface StudentMapper {
    List<Student> queryAll();

    List<Course> getCourse();

    void insertStudent(Student student);

    void insertStuCou(@Param("sid") Integer id,@Param("cid") String cid);

    Student queryById(String id);

    void updateStudent(Student student);

    void deleteStuCou(int id);

    void deleteStudent(String id);
}
