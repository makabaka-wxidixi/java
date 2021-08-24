package String;

import org.junit.Test;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-08-24 11:36
 */
public class StringBufferBuilderTest {
    /*
    String .StringBuffer.StringBuilder三者的异同
    String:不可变得字符序列：使用char型数组进行存储
    StringBuffer:可变得字符序列：线程安全的，效率低:使用char型数组进行存储
    StringBuilder:可变得字符序列：jdk5.0新增，线程不安全，效率高:使用char型数组进行存储
     */
    @Test
    public void Test1() {
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(1, 'd');
        System.out.println(sb1);
    }
    @Test
    public void Test2(){
        StringBuffer sb1=new StringBuffer("abc");
        String s1=new String(sb1);
        System.out.println(s1);
        s1=sb1.toString();
        String sb2=new String("l");
        sb1.append(1);
        sb1.append('1');
        System.out.println(sb1);
        sb1.reverse();
        System.out.println(sb1);
        sb1.delete(2, 4);
        //在原来的基础上操作
        System.out.println(sb1);
        sb1.replace(2, 3, "hello");
        System.out.println(sb1);
        System.out.println(sb1.indexOf(sb2, 4));
        String str1 = sb1.substring(2, 5);
        System.out.println(str1);
        System.out.println(sb1.charAt(2));
        sb1.setCharAt(2, 'p');
        System.out.println(sb1.charAt(2));


    }

}
