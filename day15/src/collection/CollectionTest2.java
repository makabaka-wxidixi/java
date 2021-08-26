package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-08-26 19:16
 */
public class CollectionTest2 {
    @Test
    public void Test1() {
//        contains()
        Collection coll = new ArrayList();
        coll.add("ABC");
        coll.add("aa");
        coll.add(new String("yasuo"));
        coll.add(123);
        coll.add(456);
        coll.add(new Person("shitouren", 23));

        System.out.println(coll.contains(new String("yasuo")));
//形参中的对象所在的方法必须要重写equals方法，也是从同到尾全部遍历一遍
        System.out.println(coll.contains(new Person("shitouren", 23)));
        //containAll()  Arrays.asList()，返回值为ArrayList()
        Collection coll1 = Arrays.asList(123, new String("yasuo"), new Person("shitouren", 23));
        System.out.println(coll.containsAll(coll1));
    }

    @Test
    public void Test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(456);
        coll.add(new Person("yasuo", 21));
        coll.add("AA");
        coll.add("CCC");
        coll.add(new Person("yasuo", 21));
        coll.add(new Person("yasuo", 21));
        coll.add(new Person("yasuo", 21));
        coll.add(new Person("yasuo", 21));
//remove()该方法只会移除第一个。也需要重写equals()方法
        coll.remove(new Person("yasuo", 21));
        System.out.println(coll);
//         removeAll()，移除该集合中出现的所有元素，有多个一样的也会被移除
        Collection coll1 = Arrays.asList(123, 456);
        coll.removeAll(coll1);//移除成功返回一个true，也可以不设置返回值
        System.out.println(coll);
        //已除交际，不同与remove，只移除一个
        Collection coll2 = Arrays.asList(new Person("yasuo", 21));
        coll.removeAll(coll2);
        System.out.println(coll);
    }

    @Test
    public void Test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(456);
        coll.add(456);
        coll.add("aa");
        coll.add("BB");
        coll.add("cc");
        coll.add(new Person("yasuo", 21));
        coll.add(new Person("yasuo", 21));
        coll.add(new Person("yasuo", 21));
//似乎只要是集合集合之间的运算都会将集合中所有元素都先遍历一遍
//        Collection coll1=Arrays.asList(123,456);//那么这里自然返回的就是搜有满足的值
//        coll.retainAll(coll1);
//        System.out.println(coll);
//拿着子集里面的内容和主集合里面的元素一个一个比
        Collection coll2 = Arrays.asList(new Person("yasuo", 21));
        coll.retainAll(coll2);
        System.out.println(coll);
    }

    @Test
    public void Test4() {
        //equals
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("yasuo",21));
        coll.add(new Person("shitouren",21));
        coll.add("AA");

        Collection coll1=new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll1.add(new Person("yasuo",21));
        coll1.add(new Person("shitouren",21));
        coll1.add("AA");

        System.out.println(coll.equals(coll1));
    }
    @Test
    public void Test5(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(4);
        coll.add("asd");
        coll.add("BB");
        System.out.println(coll.hashCode());
    }

    @Test
    public void Test6(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(4);
        coll.add("asd");
        coll.add("BB");
//集合到数组的转换
        Object[] objects = coll.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
//      数组到集合的转换，括号中位可变形参，括号中如果传入数组，那就不能有别的值
        List doubles = Arrays.asList(new String[]{"asd","qwe","zxcv"});
        System.out.println(doubles);
//形参是可变形参，如果传入的是数组，必须是二维，夫走返回的是地址值。要么直接就传数值
        //但是可以使用包装类
        List integers1 = Arrays.asList(new Integer[]{123, 213, 543});
        System.out.println("Integer:"+integers1);
        List ints = Arrays.asList(new int[]{12, 34});
        List integers = Arrays.asList(123, 345);
        System.out.println(integers);
        System.out.println("int[]:"+ints);
    }
}
