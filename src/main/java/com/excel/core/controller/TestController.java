package com.excel.core.controller;

import com.excel.common.ExcelUtils;
import com.excel.core.bean.User;
import com.excel.core.service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
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
    public StringBuffer testExcel(@RequestParam MultipartFile file, HttpServletResponse response, HttpServletRequest request
    ,ModelMap modelMap) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        List<String[]> res = ExcelUtils.readExcel(file);
        System.out.println("测试已经进入该方法");
        String json = null;
        String[] array = null;
        List list = new ArrayList();
        String[] str = null;
        StringBuffer buffer = new StringBuffer();
        if (res != null && res.size() > 0) {
            //存库或者其他操作
            JSONArray jsonArray = JSONArray.fromObject(res);

            json = jsonArray.toString();

            System.out.println(json);
            System.out.println("-------------------");
            System.out.println(jsonArray);
        }
        for (int j = 0; j < res.size(); j++) {

            str = res.get(j);
            for (int i = 0; i < str.length; i++) {
                System.out.println(str[i]);
                buffer.append(str[i]);
            }
        }
//        modelMap.addAttribute("str",list);
        request.setAttribute("list", str);
//        request.getRequestDispatcher("/WEB-INF/page/show.jsp").forward(request,response);
        return buffer;
        //这种只是将数据直接返回到网页前端
//        return json;

    }


}
