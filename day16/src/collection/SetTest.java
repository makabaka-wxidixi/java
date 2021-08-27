package collection;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-08-27 11:22
 */
public class SetTest {
    /*
    set:存储无序的、不可重复的数据
    无序性：不等于随机性。存储的数据在底层数组中，并非都是按照数组索引的顺序添加的，而是根据数据的哈希值

    不可重复性：保证添加的新元素按照equals（）判断时，不能返回true，也就是，相同的元素真能存在一个
     */
    @Test
    public void Test1(){
        Set set=new HashSet();
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("abc");
        set.add(new Person("yasuo",21));
        set.add(new Person("yasuo",21));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }

    @Test
    /*
    LinkedHashSet的使用：
    作为HashSet的子类，再添加数据时，每个数据还维护了两个引用，记录数据存入数组的先后
    优点：对于频繁的遍历操作，LinkedHashSet的效率就高于HashSet
     */
    public void Test2(){
        Set set=new LinkedHashSet();
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("abc");
        set.add(new Person("yasuo",21));
        set.add(new Person("yasuo",21));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
