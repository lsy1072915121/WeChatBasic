package name.liushiyao.utlis;

import com.google.gson.reflect.TypeToken;
import name.liushiyao.json.Book;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 北岭山下 on 2017/6/30.
 */
public class JsonUtilTest {


        //=======================================Gson===========================================//
        /*
       测试一：将对象转换成Json字符串
        */
        /*User user = new User("刘石尧", "nan", 21);
        String userJson = JsonUtils.toJson(user);
        System.out.println("将User对象转成json字符串\n" + userJson);*/
        @Test
        public void toJson ( ) throws Exception {

                Book book = new Book ( "《Java编程思想》", 100, 9 );
                String dataString = JsonUtil.toJson ( book );
                System.out.println ( "转换成Json:" + dataString );

        }

        /*
                测试二：将Json字符串转换成对象
                 */
        /*String json = "{\"name\":\"刘石尧\",\"sex\":\"nan\",\"age\":21}";
        User user1 = (User) JsonUtils.fromJson(json, User.class);
        System.out.println("将Json字符串转换成User对象\n" +
                "name：" + user1.getName() + " sex:" + user1.getSex() + " age:" + user1.getAge());*/
        @Test
        public void fromJson ( ) throws Exception {

                BufferedReader bufferedReader = new BufferedReader ( new FileReader ( "book.json" ) );
                String string = null;
                string = bufferedReader.readLine ( );
                Book book = ( Book ) JsonUtil.fromJson ( string, Book.class );
                System.out.println ( "将Json字符串转换成Json ：" + "\n书名：" + book.getName ( ) + "\n价格：" +
                        book.getPrice ( ) + "\n评分：" + book.getSroce ( )
                );
                bufferedReader.close ( );

        }

        /*
       测试三：将数组型Json字符串解析成多个对象
        */
        /*List<User> userList = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User userTemp = new User();
            userTemp.setAge(21 + i);
            userTemp.setName("user" + i);
            userTemp.setSex("nan");
            userList.add(userTemp);
        }
        //将useList转化成Json字符串
        String userJsons = JsonUtils.toJson(userList);
        System.out.println(userJsons);
        List<User> users = (List<User>) JsonUtils.fromJson(userJsons, new TypeToken<List<User>>() {
        }.getType());
        for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
            User u = (User) iterator.next();
            System.out.println("User对象的名字：" + u.getName());
        }*/
        /*
                过程：1. 创建10个Book对象并进行初始化，存取ArrayList 中。
                          2. 将ArrayList中的Book对象写入Json
                          3. 从Json获取Book对象数组
         */
        @Test
        public void fromJson1 ( ) throws Exception {

                List <Book> bookList = new ArrayList <Book> ( );
                for ( int i = 0 ; i < 10 ; i++ ) {
                        Book book = new Book ( );
                        book.setName ( " book" + i );
                        book.setSroce ( 10 );
                        book.setSroce ( 1 );
                        bookList.add ( book );
                }
                //将对象转换成Json字符串
                String bookJson = JsonUtil.toJson ( bookList );
                System.out.println ("输出Json:" );
                System.out.println (bookJson );
                //从数组型Json解析
                 List<Book> books = ( List <Book> ) JsonUtil.fromJson ( bookJson,new TypeToken<List<Book>> (){}.getType () );
               //使用TypeToken<>(){}.getType();是因为getType是protected修饰的
                for ( Book book : books ) {
                        System.out.println ("name:"+book.getName () );
                }



        }
        //=======================================JSON======================================//

        /**
         * 使用JSON创建Json
         *  将数值转化成Json，重点是把握数组与对象的关系
         *      对象中存储键值对；
         *      数组存储的是对象；
         */

      @Test
        public void JSONCreateTest (){

              //创建Json 对象
              JSONObject jsonObject = new JSONObject();
              //创建JSONArray对象
              JSONArray jsonArray1 = new JSONArray();
              //创建一个子Json对象
              JSONObject member1 = new JSONObject();
              member1.put("name","liushiyao");
              member1.put("age","21");
              member1.put("sex","nan");
              jsonArray1.add(member1);

              //创建另外一个子Json对象
              JSONArray jsonArray2 = new JSONArray();
              JSONObject member2 = new JSONObject();
              member2.put("name","lsy");
              member2.put("age","21");
              member2.put("sex","nan");
              jsonArray2.add(member2);
              jsonObject.put("user1",jsonArray1);
              jsonObject.put("user2",jsonArray2);
              System.out.println(jsonObject.toString());


      }


}