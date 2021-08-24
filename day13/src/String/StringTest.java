package String;

import org.junit.Test;

/**
 * String的使用
 *
 * @Author mkbk
 * @Description
 * @Create 2021-08-23 16:18
 */
public class StringTest {

    /*
    结论：
    1.常量与常量的拼接结果在常量池中，且常量池中不会存在相同内容的常量
    2.只要其中有一个是变量，结果就在堆中
    3.如果拼接的结果调用intern方法，那么返回值就在常量池中
     */
    @Test
    public void test3() {
        String s1 = "abc";
        String s2 = "def";
        String s3 = "abc" + "def";
        String s4 = "abc" + s1;
        String s5 = s1 + s2;
        String s6 = "abcdef";

        System.out.println(s1 == s2);//false
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s4);//false
        System.out.println(s1 == s5);//false
        System.out.println(s3 == s4);//false
        System.out.println(s3 == s5);//false
        System.out.println(s6 == s3);//true

        //该方法会返回在方法区中的地址，所以也就相等
        System.out.println(s6==s5.intern());//true

    }

    /*
    String的实例化方式：
    方式一：通过字面量定义的方式
    方式二：通过new+构造器的方式
    通过String s=new String("abc")方式创建的对象，在内存中创建了两对象
            1.在堆区中new了一个对象
            2.char[]对应的常量池中的数据：abc
     */
    @Test
    public void test2() {
        //字面量定义的方式
        String s1 = "abc";
        String s2 = "abc";
        //通过new + 构造器的方式
        String s3 = new String("abc");
        String s4 = new String("abc");
        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s4);//false
        System.out.println(s3 == s4);//false
    }

    /*
    String:字符串，使用一对“”引用来表示
    1.String声明为final，不可被继承
    2.String实现了Serializable接口：表示字符串是可序列化的
            实现了Comparable接口：表示String可以比较大小
    3.String内部定义了final char[] value用与存储字符串数据
    4.String：代表不可变的字符串序列。简称：不可变性。
            体现：1.当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原来的地址
                  2.当对现有字符串进行连接操作时，也是需要在方法区重新开辟空间
                  3.调用String中的replace（）方法修改指定字符或者字符串时，也是需要重新
                        开辟空间
    5.通过字面量的方式（区别于new）给一个字符串赋值，此时的字符串值声明在字符串常量池中
    6.字符串常量池中没有相同的数据
     */
    @Test
    public void test1() {

    }
}
