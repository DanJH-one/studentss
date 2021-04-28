package itheima.dao.impl;

import itheima.dao.StudentDao;
import itheima.domin.Student;

import java.util.*;

public class StudentDaoImpl implements StudentDao {
    private static List<Student> list = new ArrayList<>();

    @Override
    public void showliststu() {
        String[] srr = {"张", "孙", "钱"};
        String[] rr = {"小花", "明", "宁", "水", "小环"};
        Random random = new Random();
        for (int i = 0; i < srr.length; i++) {
            for (int i1 = 0; i1 < rr.length; i1++) {
                int age = random.nextInt(15) + 10;
                int source = random.nextInt(20) + 50;
                String uuid = UUID.randomUUID().toString();
                Student student = new Student();
                student.setName(srr[i] + rr[i1]);
                student.setAge(age);
                student.setSid(uuid);
                student.setSource(source);
                list.add(student);
            }
        }
    }

    //添加数据
    public void inserStuDao(Student student) {
        list.add(student);
        for (Student student1 : list) {
            System.out.println(student1);
        }
    }

    //查询所有学生方法
    @Override
    public List<Student> findAll() {
        return list;
    }

    //删除方法
    @Override
    public void deleStu(String sid) {
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            Student next = iterator.next();
            if (sid.equals(next.getSid())) {
                iterator.remove();
            }
        }
    }

    //更新方法
    @Override
    public void update(String name, String age, String source, String sid) {
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (sid.equals(student.getSid())) {
                student.setName(name);
                student.setAge(Integer.valueOf(age));
                student.setSource(Integer.valueOf(source));
                student.setSid(sid);
            }
        }
    }

}
