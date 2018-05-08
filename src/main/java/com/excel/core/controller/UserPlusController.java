package com.excel.core.controller;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.excel.core.bean.UserPlus;
import com.excel.core.service.UserPlusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserPlusController{
    @Autowired
    private UserPlusService userService;



    @ResponseBody
    @RequestMapping("/page")
    public Object selectPage(Model model){

        Page page=new Page(1,10);
        page = userService.selectUserPlusPage(page, "NORMAL");
        return page;
    }


    public void test(){
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.setEntity(new UserPlus());
        String name ="kekangshui";
        Integer age = 23;
        entityWrapper.where("name={0}",name).andNew("age > {0}",age).orderBy("age");

        List<UserPlus> page = userService.selectList(entityWrapper);
        System.out.println(page);

    }
}
