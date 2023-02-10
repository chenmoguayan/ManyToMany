package org.qingqiao.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.qingqiao.bean.Course;
import org.qingqiao.bean.Student;
import org.qingqiao.mapper.StudentMapper;

import java.io.IOException;
import java.util.List;

/**
 * @author hj
 * @data 2023/2/9 14:16
 */
public class StudentServiceImpl implements StudentService {
    SqlSession session;
    StudentMapper mapper;

    {
        try {
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            session = sessionFactory.openSession();
            mapper = session.getMapper(StudentMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Student> queryAll() {
        return mapper.queryAll();
    }

    @Override
    public List<Course> getCourse() {
        return mapper.getCourse();
    }

    @Override
    public int insert(Student student, String[] cids) {
        int i = 0;
        try {
            mapper.insertStudent(student);
            for (String cid:cids) {
                mapper.insertStuCou(student.getId(), cid);
            }
            session.commit();
            i = 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public Student queryById(String id) {
        return mapper.queryById(id);
    }

    @Override
    public int update(Student student, String[] cids) {
        int i = 0;
        try {
            mapper.updateStudent(student);
            deleteStuCou(student.getId());
            for (String cid:cids) {
                mapper.insertStuCou(student.getId(),cid);
            }
            session.commit();
            i = 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int delete(String id) {
        int i = 0;
        try {
            deleteStuCou(Integer.parseInt(id));
            mapper.deleteStudent(id);
            session.commit();
            i = 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    public void deleteStuCou(int id){
        mapper.deleteStuCou(id);
    }
}
