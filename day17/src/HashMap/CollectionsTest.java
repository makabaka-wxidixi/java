package HashMap;

import org.junit.Test;

import java.util.*;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-08-30 16:45
 */
public class CollectionsTest {
    /*
    CollectionsTest是用来操作Collection和Map的工具类
     */

    @Test
    public void Test1(){
        List list = new ArrayList();

        list.add(123);
        list.add(145);
        list.add(345);
        list.add(345);
        list.add(345);
        list.add(12);
        list.add(98);

        System.out.println(list);
        //reverse()：翻转
        Collections.reverse(list);
        System.out.println(list);
        //shuffle()：乱序
        Collections.shuffle(list);
        System.out.println(list);
        //sort()：排序
        //自然排序
        Collections.sort(list);
        System.out.println(list);
        //定制排序
        Collections.sort(list, new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Integer&&o2 instanceof Integer){
                    Integer int1=(Integer) o1;
                    Integer int2=(Integer) o2;
                    return -Integer.compare(int1, int2);
                }
                throw new RuntimeException("输入数据错误");
            }
        });
        System.out.println(list);

        //swap()
        Collections.swap(list, 2, 3);
        System.out.println(list);
        //max()求最大值   min()
        Comparable max = Collections.max(list);
        System.out.println(max);
        //max(list,Comparator)可以自己定制规则  min(list,Comparator)
        //int frequency(Collection(多态),Object)，返回指定集合中元素出现的次数
        int frequency = Collections.frequency(list, 345);
        System.out.println(frequency);
    }

    @Test
    public void Test2(){

        //copy(dest,src)
        List list = new ArrayList();

        list.add(123);
        list.add(145);
        list.add(345);
        list.add(12);
        list.add(98);

        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest, list);
        System.out.println(dest);

        //int synchronizedList(list)线程安全
        List list1 = Collections.synchronizedList(list);


    }
}
