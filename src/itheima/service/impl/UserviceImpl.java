package itheima.service.impl;

import itheima.dao.impl.UserDaoImpl;
import itheima.domin.User;
import itheima.service.Uservice;

public class UserviceImpl implements Uservice {
    private UserDaoImpl udao = new UserDaoImpl();

    @Override
    public User findUserService(String name, String password) {
        return udao.findUser(name, password);
    }
}
