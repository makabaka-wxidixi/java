package String;

import org.junit.Test;

import java.util.Date;

/**
 * JDK 8之前日期和时间的api测试
 *
 * @Author mkbk
 * @Description
 * @Create 2021-08-24 13:39
 */
public class DataTimeTest {

    /*
    java.util.Date类
            |--java.sql.Date类
        1.两个构造器的使用

        2.两个方法的使用
        toString():
     */
    @Test
    public void Test2() {
        //构造器一：Date（）:创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());//Tue Aug 24 13:54:28 CST 2021
        System.out.println(date1.getTime());//1629784468499
        //构造器二：创建一个指定毫秒数的Date对象
        Date date2 = new Date(1629784468499L);
        System.out.println(date2.toString());

        //如何将java.util.Date对象转化成java.sql.Date对象
        //情况一
        Date date3 = new java.sql.Date(1629784468499L);//创建一个子类，多态
        java.sql.Date date4 = (java.sql.Date) date3;//父类强转为子类
        System.out.println(date4.toString());
        //情况二
        Date date5=new Date();//创建一个父类，之后通过父类获取当前微秒数，将其作为参数传入构造器
        java.sql.Date date6=new java.sql.Date(date5.getTime());
        System.out.println(date6.toString());
    }


    @Test
    public void Test1() {
        long time = System.currentTimeMillis();
        System.out.println(time);
    }
}
