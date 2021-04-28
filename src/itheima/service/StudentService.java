package itheima.service;

import itheima.domin.Student;

import java.util.List;

public interface StudentService {
    //初始化数据方法
    void showstuSer();

    //添加学生信息方法
    void inserStuService(Student student);

    //查询所有学生方法
    List<Student> findAll();

    //删除方法
    void  deleStu(String sid);

    //更新方法
    void updete(String name,String age,String source,String sid);
}
