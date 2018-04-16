package com.excel.core.dao;

import com.excel.core.bean.User;

import java.util.List;

/**
 * Created by ASUS on 2018/4/15.
 */
public interface UserDao {
    /**
     * 基本插入
     * @param user
     * @return
     */
    Integer addUser (User user);

    /**
     * 根据主键查找
     * @param id
     * @return
     */
    User getUserByKy(Integer id);

    /**
     * 根据主键批量查找
     * @param users
     * @return
     */
    List<User> getUserByKeys(List<User> users);
}
