package org.qingqiao.service;

import org.qingqiao.bean.Course;
import org.qingqiao.bean.Student;

import java.util.List;

/**
 * @author hj
 * @data 2023/2/9 14:16
 */
public interface StudentService {
    List<Student> queryAll();

    List<Course> getCourse();

    int insert(Student student, String[] cids);

    Student queryById(String id);

    int update(Student student, String[] cids);

    int delete(String id);
}
