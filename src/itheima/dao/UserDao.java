package itheima.dao;

import itheima.domin.User;

public interface UserDao {
    //判断用户是否存在
    User findUser (String name,String password);
}
