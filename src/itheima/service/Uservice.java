package itheima.service;

import itheima.domin.User;

public interface Uservice {
    //判断用户是否存在
    User findUserService(String name,String password);
}
