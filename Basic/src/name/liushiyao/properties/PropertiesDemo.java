package name.liushiyao.properties;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by 北岭山下 on 2017/6/23.
 */


/**
 * 相关问题：如何读取src文件夹下的文件？
 *
 *      1. 使用class.getResourceAsStream();获取目录下的文件输入流
 *      2. 使用绝对路径
 *
 *      注：访src外部的文件时，不需要考虑这些
 */
public class PropertiesDemo {


        public static void main ( String[] args ) throws IOException {

                Properties properties = new Properties (  );
                InputStream fileInputStream = PropertiesDemo.class.getResourceAsStream ( "/myproperties.properties" );
                 properties.load ( fileInputStream );
                String name = properties.getProperty ( "jdbc.username" );
                System.out.println ("name = "+name );

        }

        @Test
        public void isExists(){
                File file =  new File ( "books.xml" ) ;
                System.out.println ("File isHas: "+file.exists () );

        }







}
