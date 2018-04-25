package com.excel.core.service;


import com.excel.core.bean.Excel;

import java.util.List;

public interface ExcelService {
    /**
     * 基本插入
     */
    void addJson(int excel_id,String json);

    /**
     * 根据主键选择
     * @return
     */
    List<Excel> selectJsonById();

    /**
     * 查询i的列表
     */
    List<Excel> selectById();
}
