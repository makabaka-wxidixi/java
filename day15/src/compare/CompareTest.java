package compare;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一、说明：java中的对象，正常情况下，只能进行比较==或者!=。不能使用>或者<，但是在开发环境中，我们需要
 * 将多哥对象进行比较，如何实现？使用两个接口中的任何一个Comparable或Comparator
 *
 * @Author mkbk
 * @Description
 * @Create 2021-08-25 11:42
 */
public class CompareTest {
    /*
    Comparable接口的使用
    1.像String、包装类等实现了Comparable接口，重写了compareTo(obj)方法，给出了比较两个对象的方式
    2.像String、包装类重写compareTo()方法以后，进行了从小到大的排列
    3.重写compareTo(obj)的规则
        如果当前对象this大于形参对象obj，则返回正整数
        如果当前对象this小于形参对象obj，则返回负整数
        如果当前对象this等于形参对象obj，则返回0
    4.对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo(obj)，在
        compareTo(obj)中知名如何排序
    5.永久性
     */
    @Test
    public void Test1() {
        String[] arr = new String[]{"tt", "ii", "gg", "ss", "pp", "cc", "aa"};
        Arrays.sort(arr);//排序需要先比较大小，默认实现Comparable
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void Test2() {
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("lenovoMouse", 34);
        arr[1] = new Goods("dellMouse", 43);
        arr[2] = new Goods("xiaomiMouse", 12);
        arr[3] = new Goods("huaweiMouse", 34);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
    Comparator接口的使用：定制排序
    1.背景
    当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，或者实现了java.lang.Comparable接口
    的排列规则不适合当前的操作，那么可以考虑使用Comparator的对象来排序
    2.重写compare(Object o1,Object o2)方法，比较o1和o2的大小：
    如果方法返回正整数，则表示o1大于o2
    如果方法返回负整数，则表示o1小于o2
    如果方法返回0，则表示o1等于o2
    3.一次性
     */
    @Test
    public void Test3() {
        String[] arr = new String[]{"tt", "ii", "gg", "ss", "pp", "cc", "aa"};
        //创建一个接口的实现类的对象
        Arrays.sort(arr, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("输入数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));

    }

    @Test
    public void Test4() {
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovoMouse", 34);
        arr[1] = new Goods("dellMouse", 43);
        arr[2] = new Goods("xiaomiMouse", 12);
        arr[3] = new Goods("huaweiMouse", 34);
        arr[4] = new Goods("huaweiMouse", 67);
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods && o2 instanceof Goods) {
                    Goods g1 = (Goods) o1;
                    Goods g2 = (Goods) o2;
                    if(g1.getName().equals(g2.getName())){
                        return Double.compare(g1.getPrice(), g2.getPrice());
                    }else{
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("输入数据类型不一致");
            }
        });

        System.out.println(Arrays.toString(arr));
    }
}
