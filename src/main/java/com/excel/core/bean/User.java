package com.excel.core.bean;

/**
 * Created by ASUS on 2018/4/15.
 */
public class User {
    private int id;
    private String user_name;
    private String sex;

//    public User(String user_name){
//        this.user_name =user_name;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getUser_name() {
        return user_name;
    }

    public User setUser_name(String user_name) {
        this.user_name = user_name;
        return null;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
