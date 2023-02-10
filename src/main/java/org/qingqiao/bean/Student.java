package org.qingqiao.bean;

import java.util.List;

/**
 * @author hj
 * @data 2023/2/9 14:13
 */
public class Student {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private List<StuCou> sc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<StuCou> getSc() {
        return sc;
    }

    public void setSc(List<StuCou> sc) {
        this.sc = sc;
    }

    public Student() {
    }

    public Student(Integer id, String name, String sex, Integer age, List<StuCou> sc) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.sc = sc;
    }
}
