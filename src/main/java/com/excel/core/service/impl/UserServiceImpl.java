package com.excel.core.service.impl;

import com.excel.core.bean.User;
import com.excel.core.dao.UserDao;
import com.excel.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ASUS on 2018/4/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public Integer addUser(User user) {
        return userDao.addUser(user);
    }

    public User getUserByKy(Integer id) {
        return userDao.getUserByKy(id);
    }

    public List<User> getUserByKeys(List<User> users) {
        return userDao.getUserByKeys(users);
    }
}
