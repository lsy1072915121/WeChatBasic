package name.liushiyao.utlis;

/**
 * Created by 北岭山下 on 2017/6/23.
 */

import com.google.gson.Gson;
import com.google.gson.JsonNull;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * 使用的Gson包
 */

/**
 * Json
 * 语法规则：
 * 数据在键值对中
 * 数据由逗号分隔
 * 花括号保存对象
 * 方括号保存数组
 *
 * 数据类型：
 * 字符串：String（在双引号中）
 * 数字：number（整型或浮点数）
 * 对象：object（花括号中）
 * 数组：array（方括号中）
 * 布尔：boolean（true或false）
 * 空：null
 *
 * 注：最后一个元素都不添加“，”
 */
public class JsonUtil {
        //采取单例模式
        private static Gson gson = new Gson ( );

        private JsonUtil ( ) {
        }

        /**
         * @param src :将要被转化的对象
         * @return :转化后的JSON串
         * @MethodName : toJson
         * @Description : 将对象转为JSON串，此方法能够满足大部分需求
         */
        public static String toJson ( Object src ) {
                if ( src == null ) {
                        return gson.toJson ( JsonNull.class );
                }
                return gson.toJson ( src );
        }

        /**
         * @param json
         * @param classOfT
         * @return
         * @MethodName : fromJson
         * @Description : 用来将JSON串转为对象，但此方法不可用来转带泛型的集合
         */
        public static <T> Object fromJson ( String json, Class <T> classOfT ) {
                return gson.fromJson ( json, ( java.lang.reflect.Type ) classOfT );
        }

        /**
         * @param json
         * @param typeOfT
         * @return
         * @MethodName : fromJson
         * @Description : 用来将JSON串转为对象，此方法可用来转带泛型的集合，如：Type为
         * new TypeToken<List<T>>(){}.getType()
         * ，其它类也可以用此方法调用，就是将List<T>替换为你想要转成的类
         */
        public static Object fromJson ( String json, java.lang.reflect.Type typeOfT ) {
                return gson.fromJson ( json, typeOfT );
        }

        public static void main ( String[] argm ) {








                /**
                 * 使用JSON解析Json
                 */
                String jsonData = "{\n" +
                        "  \"user1\": [\n" +
                        "    {\n" +
                        "      \"name\": \"liushiyao\",\n" +
                        "      \"age\": \"21\",\n" +
                        "      \"sex\": \"nan\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"user2\": [\n" +
                        "    {\n" +
                        "      \"name\": \"lsy\",\n" +
                        "      \"age\": \"21\",\n" +
                        "      \"sex\": \"nan\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}";
                //创建一个JSONObject对象
                JSONObject jsonObject = JSONObject.fromObject ( jsonData );
                //创建一个JSONArray对象，接收“user1”
                JSONArray jsonArray1 = jsonObject.getJSONArray ( "user1" );
                for ( int i = 0 ; i < jsonArray1.size ( ) ; i++ ) {
                        JSONObject user = ( JSONObject ) jsonArray1.get ( i );
                        System.out.println ( user.toString ( ) );
                }
                //创建一个JSONArray对象，接收“user2”
                JSONArray jsonArray2 = jsonObject.getJSONArray ( "user2" );
                for ( int i = 0 ; i < jsonArray2.size ( ) ; i++ ) {
                        JSONObject user = ( JSONObject ) jsonArray2.get ( i );
                        System.out.println ( user.toString ( ) );
                }


        }
}