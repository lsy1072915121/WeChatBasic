package name.liushiyao.json;

/**
 * Created by 电子小孩 on 2016/8/9.
 */

/**
 * 账号：1072915121
 * 名字：lsy
 * 年龄：21
 * 性别：男
 * 病史：content
 * 注意事项：content
 * <p>
 * “account”:”1072915121”
 * "password":"123456"
 * “name”:”lsy”
 * “age”:”21"
 * “sexy”:”man”
 * “medical_history”:”content”
 * “attention”:”content”
 * “device”：“null”/”xx2”
 */
public class User {

    private String name;
    private String sex;
    private int age;

    public User (){}

    public User ( String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
