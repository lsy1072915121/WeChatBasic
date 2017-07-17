package name.liushiyao.json;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by 北岭山下 on 2017/6/23.
 */
public class ParserJsonDemo {

        public static void main ( String[] args ) throws FileNotFoundException {

                Gson gson = new Gson();
                JsonReader jsonReader = new JsonReader ( new FileReader ( "myjson.json" ) );
                //jsonData :需要解析的Json，User ：对象
                Book book =gson.fromJson(jsonReader, Book.class);
                System.out.println("name="+ book.getName());
//                System.out.println("age="+ book.getName ());


        }


        @Test
        public void toGsonTest(){

                Gson gson =  new Gson () ;
                String string = gson.toJson ( new Book ( "java编程思想",10,101 ) );
                System.out.println (string );

        }
        @Test
        public void fromGsonTest() throws IOException {
                String jsonDate = "{\"name\":\"《Java编程思想2》\",\"sroce\":10,\"price\":90}";


                Gson gson = new Gson ();
                Book book = gson.fromJson (jsonDate ,Book.class );
                System.out.println (book.getName () );

        }


}
