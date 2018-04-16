package com.excel.core.controller;

import com.excel.common.ExcelUtils;
import com.excel.core.bean.User;
import com.excel.core.service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
/**
 * Created by ASUS on 2018/4/15.
 */
@Controller("index")
public class TestController {
    @Autowired
    private UserService service;
   /* @RequestMapping(value = "/")
    @ResponseBody
    public String index(){
        return "hello world";
    }*/

    @RequestMapping("/test.do")
    public String test(User user, ModelMap map) {
//        this.user =user;
//        若不将属性加入map 当中，就等于没有设置属性值

        map.addAttribute("user_name", user.getUser_name());
        System.out.println(user.getUser_name());
        System.out.println(user.getSex());
        map.addAttribute("sex", user.getSex());
        service.addUser(user);
        JSONObject ob = JSONObject.fromObject(user);
//        service.addUser(ob);
        System.out.println(ob);
        return "test";
    }

    @RequestMapping(value = "/upload.do", method = RequestMethod.POST)
    @ResponseBody
    public String testExcel(@RequestParam MultipartFile file, HttpServletResponse response)throws IOException{
        response.setCharacterEncoding("UTF-8");
        List<String[]> res = ExcelUtils.readExcel(file);
        System.out.println("测试已经进入该方法");
        String json =null;
        if (res != null && res.size() > 0) {
            //存库或者其他操作
            JSONArray jsonArray =JSONArray.fromObject(res);

            json = jsonArray.toString();

            System.out.println(json);
            System.out.println("-------------------");
            System.out.println(jsonArray);
        }
        return json;
    }

}
