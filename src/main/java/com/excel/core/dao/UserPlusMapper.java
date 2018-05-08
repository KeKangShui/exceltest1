package com.excel.core.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Select;
import com.excel.core.bean.UserPlus;
import java.util.List;

public interface UserPlusMapper extends BaseMapper<UserPlus> {

    @Select("selectUserList")
    List<UserPlus> selectUserList(Pagination pagination,String state);
}

