package name.liushiyao.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by 北岭山下 on 2017/6/23.
 */
public class ParseXMLDemo {

        public static void main ( String[] args ) throws DocumentException {

        }
        //使用DOM4J创建XML

        /**
         *
         * @throws IOException
         */
        @Test
        public void DOM4JCreateXMl ( ) throws IOException {


                Document document = DocumentHelper.createDocument ( );
                //配置需要写入XMl的属性数据
                Element books = document.addElement ( "books" );
                Element book = books.addElement ( "book" );
                Element name = book.addElement ( "name" );
                name.setText ( "Web前端开发" );
                Element score = book.addElement ( "score" );
                score.setText ( "10" );
                Element price = book.addElement ( "price" );
                price.setText ( "60" );
                //将XML数据属性写入XML
                try {
                        File file = new File ( "myBook.xml" );
                        FileWriter fileWriter = new FileWriter ( file );
                        //创建XMLWriter输出流
                        XMLWriter xmlWriter = new XMLWriter ( fileWriter );
                        xmlWriter.write ( document );
                        xmlWriter.close ( );

                } catch ( IOException e ) {
                        e.printStackTrace ( );
                }


        }

        @Test
        public void DOM4JParserXML ( ) {

                File file = new File ( "books.xml" );
                SAXReader saxReader = new SAXReader ( );
                try {
                        Document document = saxReader.read ( file );
                        Element books = document.getRootElement ( );
                        for ( Iterator iterator = books.elementIterator ( ) ; iterator.hasNext ( ) ; ) {
                                Element book = ( Element ) iterator.next ( );
                                for ( Iterator iterator1 = book.elementIterator ( ) ; iterator1.hasNext ( ) ;)
                                {
                                        Element a = ( Element ) iterator1.next ( );
                                        for ( Iterator iterator2 = a.elementIterator ( ) ; iterator2.hasNext ( ) ; ) {
                                                Element node = ( Element ) iterator2.next ( );
                                                System.out.println ( node.getName ()+":"+node.getData ( ) );

                                        }

                                }
                        }
                } catch ( DocumentException e ) {
                        e.printStackTrace ( );
                }


        }


}
