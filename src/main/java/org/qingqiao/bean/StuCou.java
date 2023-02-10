package org.qingqiao.bean;

/**
 * @author hj
 * @data 2023/2/9 14:13
 */
public class StuCou {
    private Student student;
    private Course course;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public StuCou() {
    }

    public StuCou(Student student, Course course) {
        this.student = student;
        this.course = course;
    }
}
