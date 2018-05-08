package com.excel.core.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.excel.core.dao.UserPlusMapper;
import com.excel.core.bean.UserPlus;
import org.springframework.stereotype.Service;

@Service
public class UserPlusService extends ServiceImpl<UserPlusMapper,UserPlus> {

    public Page<UserPlus> selectUserPlusPage(Page<UserPlus> plusPage,String state){
        plusPage.setRecords(baseMapper.selectUserList(plusPage,state));
        return plusPage;
    }
}
