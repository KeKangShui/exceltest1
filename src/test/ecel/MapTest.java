package ecel;

import com.excel.core.bean.User;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {
/*
    public static void main(String[] args) {
        User ming = new User("");
        ming.setId(1);
        ming.setUser_name("小明");

        User ming1 = new User("");
        ming1.setId(2);
        ming1.setUser_name("小明2");

        User ming2 = new User("");
        ming.setId(3);
        ming2.setUser_name("小明3");

        Map<String,User> per =new HashMap<String, User>();
        per.put("a",ming);
        per.put("a1",ming1);
        per.put("a2",ming2);

        for (Map.Entry<String,User> entry:per.entrySet() ) {
            String key =entry.getKey().toString();
            User value =entry.getValue();
            System.out.println(key+"=======================:"+value.getUser_name());
        }
        System.out.println("----------------------");
        Iterator iterator = per.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry =(Map.Entry)iterator.next();
            Object key = entry.getKey();
            User v = (User) entry.getValue();
            System.out.println(key+"---------"+v.getUser_name());
        }
        Map<String,User[]> map =new HashMap<String, User[]>();
        User[] users =new User[]{new User("老王"),new User("李武"),new User("BB")};
        map.put("userliast",users);

        User[] users1=null;

        for (Map.Entry<String, User[]> en: map.entrySet() ) {

            String id =en.getKey();
            users1 =en.getValue();
            System.out.println(id+"__________"+users1);
            */
/*for (User user:users1){
                System.out.println(user+"是高级用户");
            }*//*


        }
        for (int i =0;i<users1.length;i++){
            System.out.println(users1[i].getUser_name());
        }


    }
*/
public static void main(String[] args) {
      long a =2048*2048*204;
    System.out.println(a);
}
}
