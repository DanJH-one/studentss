package itheima.service.impl;

import itheima.dao.impl.StudentDaoImpl;
import itheima.domin.Student;
import itheima.service.StudentService;

import java.util.List;

public class StudentServiceIpml implements StudentService {
    private StudentDaoImpl studao = new StudentDaoImpl();

    //初始化数据
    public void showstuSer() {
        studao.showliststu();

    }

    //添加数据方法
    public void inserStuService(Student student) {
        studao.inserStuDao(student);
    }

    //查询所有学生方法
    @Override
    public List<Student> findAll() {
        return studao.findAll();
    }

    //删除方法
    @Override
    public void deleStu(String sid) {
       studao.deleStu(sid);
    }

    public void updete(String name,String age,String source,String sid) {
       studao.update(name, age, source, sid);

    }
}