package com.excel.core.service.impl;

import com.excel.core.bean.Json;
import com.excel.core.dao.ExcelDao;
import com.excel.core.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExcelServiceImpl implements ExcelService{
    @Autowired
    private ExcelDao excelDao;
    public void addJson(String json) {
         excelDao.addJson(json);
    }
}
