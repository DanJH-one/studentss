package itheima.dao.impl;

import itheima.dao.UserDao;
import itheima.domin.User;

public class UserDaoImpl implements UserDao {
    //判断用户是否存在
    @Override
    public User findUser(String name,String password) {
       if (name.equals("zs") && password.equals("123")){
           return new User("zs","123");
       }
       return null;
    }
}
