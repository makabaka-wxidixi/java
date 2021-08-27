package collection;

import org.junit.Test;

import java.util.*;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-08-27 9:13
 */
public class ListTest {
    @Test//遍历
    //必须是相同类的对象
    public void Test3() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(1);
        list.add("aaa");
        list.add(new Person("Tom", 21));
        list.add(new Person("yasuo", 22));

        //迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("---------------------");
        //增强for循环
        for (Object obj : list){
            System.out.println(obj);
        }
        System.out.println("---------------------");
        //普通for循环
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    @Test
    public void Test2() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(1);
        list.add(1);
        list.add("aaa");
        list.add("BB");
        list.add(new Person("Tom", 21));
        list.add(new Person("yasuo", 22));

        //int indexOf(Object obj)返回首次出现的下标
        int i = list.indexOf(1223);
        System.out.println(i);
        //int lastIndexOf(Object obj)返回最后出现的下标
        int bb = list.lastIndexOf("BB");
        System.out.println(bb);
        //Object remove(int index)删除指定下标的元素
        System.out.println(list.remove(Integer.valueOf(123)));
        System.out.println(list);
        boolean remove = list.remove(Integer.valueOf(1));
        System.out.println(remove);
        //Object set(int index,Object ele)修改指定位置上的元素为ele
        list.set(1, 8989);
        System.out.println(list);
        //List sublist(int fromIndex,int toIndex)返回从fromIndex到toIndex的一个数组
        List list1 = list.subList(2, 4);
        System.out.println(list1);

    }

    @Test
    public void Test1() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("aaa");
        list.add("BB");
        list.add(new Person("Tom", 21));
        list.add(new Person("yasuo", 22));

        System.out.println(list);
        //void add(int index,Object obj)
        list.add(1, 999);
        System.out.println(list);
        //boolean addAll(int index,Collection else)
        Collection list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        System.out.println(list);

        list.addAll(1, list1);
        System.out.println(list);
        //Object get(int index)
        System.out.println(list.get(2));
    }


}
