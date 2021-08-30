package HashMap;

import org.junit.Test;

import java.util.*;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-08-30 15:08
 */
public class TreeMapTest {
    /*
    向TreeMap中添加键值对，要求key必须是由同一个类创建的对象，
    因为要按照key进行排序：自然排序、定制排序
     */
    @Test
    public void Test1() {
        Person p1 = new Person("tom", 21);
        Person p2 = new Person("qwe", 22);
        Person p3 = new Person("yasuo", 20);
        Person p4 = new Person("yongen", 25);

        TreeMap treeMap = new TreeMap();

        treeMap.put(p1, 16);
        treeMap.put(p2, 13);
        treeMap.put(p3, 14);
        treeMap.put(p4, 15);

        Set set = treeMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }

    @Test
    public void Test2() {
        Person p1 = new Person("tom", 21);
        Person p2 = new Person("qwe", 22);
        Person p3 = new Person("yasuo", 20);
        Person p4 = new Person("yongen", 25);

        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person) {
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return Integer.compare(p1.getAge(), p2.getAge());
                }
                throw new RuntimeException("输入数据错误");
            }
        });

        treeMap.put(p1, 16);
        treeMap.put(p2, 13);
        treeMap.put(p3, 14);
        treeMap.put(p4, 15);

        Set set = treeMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + "---->" + entry.getValue());
        }

    }
}
