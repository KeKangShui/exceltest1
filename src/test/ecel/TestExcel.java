package ecel;

import com.excel.core.bean.Excel;
import com.excel.core.bean.Json;
import com.excel.core.bean.User;
import com.excel.core.service.ExcelService;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2018/4/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestExcel {
    //需求：将Json 对象 以存储数据库中，以Json格式
    //首先要注入操作service类
    @Autowired
    private ExcelService excelService;

    //先写一个测试类的方法
    @Test
    public void insertJson(){
        //创建多个存储对象
        List<Json> list =new ArrayList<Json>();

        //分割字符串
        String table = "<table border=\"1\" bordercolor=\"#000000\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td colspan=\"8\" rowspan=\"1\">灵芝专家调研表</td></tr><tr><td colspan=\"1\" rowspan=\"1\">姓  名</td><td colspan=\"1\" rowspan=\"1\"> </td><td colspan=\"1\" rowspan=\"1\">性别</td><td colspan=\"1\" rowspan=\"1\"> </td><td colspan=\"1\" rowspan=\"1\">出生年月</td><td colspan=\"3\" rowspan=\"1\"> </td></tr><tr><td colspan=\"1\" rowspan=\"1\">所在单位</td><td colspan=\"3\" rowspan=\"1\"> </td><td colspan=\"1\" rowspan=\"1\">职务</td><td colspan=\"1\" rowspan=\"1\"> </td><td colspan=\"1\" rowspan=\"1\">职称</td><td colspan=\"1\" rowspan=\"1\"> </td></tr><tr><td colspan=\"1\" rowspan=\"2\">详细通\n" +
                "讯地址</td><td colspan=\"3\" rowspan=\"2\"> </td><td colspan=\"1\" rowspan=\"1\">固定电话</td><td colspan=\"1\" rowspan=\"1\"> </td><td colspan=\"1\" rowspan=\"1\">手机</td><td colspan=\"1\" rowspan=\"1\"> </td></tr><tr><td colspan=\"1\" rowspan=\"1\">邮箱</td><td colspan=\"1\" rowspan=\"1\"> </td><td colspan=\"1\" rowspan=\"1\">邮政编码</td><td colspan=\"1\" rowspan=\"1\"> </td></tr><tr><td colspan=\"8\" rowspan=\"1\">  您从事了灵芝哪些项目的研究（科研项目名称、级别（国家、省市、县级）研究结果</td></tr><tr><td colspan=\"8\" rowspan=\"1\">  您的哪些灵芝科研项目荣获×××等级奖（国家、省市、县级）\n" +
                "\n" +
                "\n" +
                "\n" +
                "</td></tr><tr><td colspan=\"8\" rowspan=\"1\">  您撰写了哪些有关灵芝图书、论文、科普文章，发表在何处\n" +
                "（××年月，××出版社，××期刊。（最好能提供样本）\n" +
                "\n" +
                "\n" +
                "\n" +
                "</td></tr><tr><td colspan=\"8\" rowspan=\"1\">  您培育了哪些灵芝优良品种：研发了××灵芝产品：荣获了××专利\n" +
                "(专利号、年月）。\n" +
                "\n" +
                "\n" +
                "\n" +
                "</td></tr></table>";
        String[] split = table.split("<tr>|</tr>");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
            list.add(new Json(split[i]));

        }

        JSONObject object = null;
        for (int i = 0; i < list.size(); i++) {
            object = JSONObject.fromObject(list.get(i));
            System.out.println(object);
            excelService.addJson(i,object.toString());
        }
        System.out.println("-----------------------");
        JSONArray array = JSONArray.fromObject(list);
        System.out.println(array);
    }


    //需求点：实现从数据库中读取json格式并返回到前端页面
   @Test
    public void selectJson(){
        //从数据库读取内容就需要涉及数据层的操作
//      String s= excelService.selectJsonById();
       JSONArray jsonobject = JSONArray.fromObject(excelService.selectJsonById());
       String s = null;
       for (int i = 0; i < jsonobject.size(); i++) {
           JSONObject json = JSONObject.fromObject(jsonobject.get(i));
           s =json.get("json").toString();
          s = s.replace("{\"json\":\"","");
           s =s.replace("\"}","");
           s = s.replace("\\","");
           System.out.println(s);
       }

       List<Excel> excel= (List<Excel>)JSONArray.toCollection(jsonobject,Excel.class);
       for (int i = 0; i < excel.size(); i++) {
           JSONObject jsonObject = JSONObject.fromObject(excel.get(i));

//           System.out.println(jsonObject.get("json"));
       }
    }
}
