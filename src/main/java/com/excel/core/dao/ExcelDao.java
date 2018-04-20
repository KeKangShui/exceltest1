package com.excel.core.dao;


import org.apache.ibatis.annotations.Insert;

public interface ExcelDao {
    /**
     * 基本插入
     */
    /*@Insert("insert into excel(json) values(#{json})")*/
    void addJson(String json);
}
