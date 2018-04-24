package com.excel.core.dao;

import com.excel.core.bean.Excel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExcelDao {
    /**
     * 基本插入
     */
    /*@Insert("insert into excel(json) values(#{json})")*/
    void addJson(@Param("excel_id") int excel_id,@Param("json") String json);

    /**
     * 根据主键查询
     */
//     @Select("select json from excel where excel_id >`1`")
    List<Excel> selectJsonById();
}
