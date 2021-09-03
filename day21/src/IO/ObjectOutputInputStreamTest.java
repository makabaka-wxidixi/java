package IO;

import org.junit.Test;

import java.io.*;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-09-03 13:29
 */
public class ObjectOutputInputStreamTest {
    @Test
    public void ObjectOutputStreamTest(){
        ObjectOutputStream oos = null;
        try {
            //序列化
            oos = new ObjectOutputStream(new FileOutputStream("文件.bat"));
            oos.writeObject(new String("亚索打不过永恩"));
            oos.flush();//刷新缓存

            oos.writeObject(new Person("泰隆",21));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos==null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void ObjectInputStreamTest(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("文件.bat"));
            Object o = ois.readObject();
            Person o1 = (Person)ois.readObject();
            System.out.println(o);
            System.out.println(o1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
        if(ois==null){
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }
    }
}

//除了保证Person是可序列化的，也需要保证内部所有属性也是可序列化的
//默认情况下，基本数据类型都是可序列化的，自定义类要实现可序列化接口
//用static和transient修饰的属性是不可序列化的
class Person implements Serializable{//实现序列化接口

    private static final long serialVersionUID=23124124123L;

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}