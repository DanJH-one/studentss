package itheima.dao;

import itheima.domin.Student;

import java.util.List;

public interface StudentDao {
    //初始化数据
    void showliststu();

    //添加数据方法
    void inserStuDao(Student student);

    //查询所有学生方法
    List<Student> findAll();

    //删除方法
    void  deleStu(String sid);

    //更新方法
    void update(String name,String age,String source,String sid);
}
