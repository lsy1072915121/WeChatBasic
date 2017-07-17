package name.liushiyao.json;

/**
 * Created by 北岭山下 on 2017/6/23.
 */
public class Book {

        private String name;
        private Integer sroce;
        private Integer price;

        public Book(){

        }

        public Book ( String name, Integer sroce, Integer price ) {
                this.name = name;
                this.sroce = sroce;
                this.price = price;
        }

        public String getName ( ) {
                return name;
        }

        public void setName ( String name ) {
                this.name = name;
        }

        public Integer getSroce ( ) {
                return sroce;
        }

        public void setSroce ( Integer sroce ) {
                this.sroce = sroce;
        }

        public Integer getPrice ( ) {
                return price;
        }

        public void setPrice ( Integer price ) {
                this.price = price;
        }




}
