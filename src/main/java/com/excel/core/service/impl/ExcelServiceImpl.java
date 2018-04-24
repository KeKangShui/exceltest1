package com.excel.core.service.impl;

import com.excel.core.bean.Excel;
import com.excel.core.dao.ExcelDao;
import com.excel.core.service.ExcelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService{
    @Resource
    private ExcelDao excelDao;

    public void addJson(int excel_id,String json) {
         excelDao.addJson(excel_id,json);
    }

     public List<Excel> selectJsonById() {
        return excelDao.selectJsonById();
    }
}
