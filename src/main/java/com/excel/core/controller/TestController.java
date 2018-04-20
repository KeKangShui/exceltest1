package com.excel.core.controller;

import com.excel.common.ExcelUtils;
import com.excel.core.bean.Excel;
import com.excel.core.bean.Json;
import com.excel.core.bean.User;
import com.excel.core.service.ExcelService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ASUS on 2018/4/15.
 */
@Controller("index")
public class TestController {
    @Autowired
    private UserService service;
    @Autowired
    private ExcelService jsonService;

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
    public StringBuffer testExcel(Excel excel, @RequestParam MultipartFile file, HttpServletResponse response, HttpServletRequest request
    , ModelMap modelMap) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        List<String[]> res = ExcelUtils.readExcel(file);

  /*      Json[] jsons =new Json[res.size()];
        for (int i = 0; i < res.size(); i++) {
            String [] strings =res.get(i);
            for (int j = 0; j < strings.length; j++) {
//                jsonService.addJson(bean);
                jsons[j].setJson((strings[j]));

                System.out.println(excel.getJson(jsons[j]));
            }
        }
        JSONArray ob =JSONArray.fromObject(excel);
        System.out.println(ob);
//        excel.getJson(Json[i])
        modelMap.addAttribute("json",ob);//
*/

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

        Map<String,Object> map =new HashMap<String, Object>();
        String test ="hello world";
        map.put("file",file);
//        map.put("res",res);
        modelMap.addAttribute("test",test);
        modelMap.addAttribute("map",map);


//        modelMap.addAttribute("str",list);
//        request.setAttribute("list", str);
        request.setAttribute("res",res);
        request.getRequestDispatcher("/WEB-INF/page/show.jsp").forward(request,response);

        return buffer;
        //这种只是将数据直接返回到网页前端
//        return json;

    }






    @RequestMapping(value = "/mytest.do",method = RequestMethod.POST)
    public String test(HttpServletRequest request,HttpServletResponse response,@RequestParam MultipartFile file,ModelMap modelMap) throws ServletException, IOException {

        System.out.println("您已进入该方法！！！");
        String filename = file.getOriginalFilename().toString();
        System.out.println(filename);
  /*      Map<String,String> map = new HashMap<String, String>();
        map.put("A","what");
        map.put("B","the");
        map.put("C","fuck");
        modelMap.addAttribute("filename",filename);
        modelMap.addAttribute("map",map);
        request.getRequestDispatcher("WEB-INF/page/pic.jsp").forward(request,response);
  */
        String stest = ExcelUtils.responseExcel(file);
//        System.out.println(stest);
//        modelMap.addAttribute("test",stest); //这个与下面的作用是一样的
        request.setAttribute("test",stest);

        //在这里转换为json格式存到数据库
        jsonService.addJson(stest);

//        request.getRequestDispatcher("WEB-INF/page/show.jsp").forward(request,response);
        return "show";
    }

}
