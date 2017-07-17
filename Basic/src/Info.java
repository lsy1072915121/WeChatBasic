/**
 * Created by 北岭山下 on 2017/6/23.
 */

/**
 *
 *                              用于“微信二次开发”中所有使用到的技术进行总结归纳
 *
 *                              1. properties属性文件的解析
 *                              2. XML数据格式创建与解析
 *                                      1）DOM4J
 *                              3. Json数据格式创建与解析
 *                                      1）Gson
 *                                      2）JSON
 *
 *
 *
 *
 *
 *
 */

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.List;

/**
 *                      遗留问题：1. TypeToken <List <Book>> 的用法 - 2017年6月30日01:45:04
 *                                              TypeToke的出现是解决“泛型擦除”问题的。
 *                                              因为在Java泛型机制中，List<Book>和List<User>两个字节码只要一个，那就是List.class
 *                                              所以，使用TypeToken来将数据解析成List<String>;      -2017年7月4日15:54:36
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

public class Info {





        public static void main ( String[] args ) {



        }
        @Test
        public void typeTokenTest(){

                /*Gson gson = new Gson();
                String jsonArray = "[\"Android\",\"Java\",\"PHP\"]";
                String[] strings = gson.fromJson(jsonArray, String[].class);
                System.out.println ( Arrays.toString (strings ) );*/

                Gson gson = new Gson();
                String jsonArray = "[\"Android\",\"Java\",\"PHP\"]";
//                String[] strings = gson.fromJson(jsonArray, String[].class);
                List<String> stringList = gson.fromJson(jsonArray, new TypeToken<List<String >> (){}.getType ());//new TypeToken<List<String>> () {}.getType());
                System.out.println (stringList.get ( 0 ) );
        }




}
