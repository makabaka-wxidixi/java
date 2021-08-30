package HashMap;

import org.junit.Test;

import java.util.*;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-08-30 12:19
 */
public class HashMapTest {
    @Test
    public void Test1() {
        //put
        //添加
        Map map = new HashMap();
        map.put(134, "AA");
        map.put(345, "BB");
        map.put(456, "CC");
        //替换：此时key都一样，就会发生替换操作，value等于后者
        map.put(345, "DD");
        System.out.println(map);//“DD”
        //putAll
        Map map1 = new HashMap();
        map1.put(234, "EE");
        map1.put(223, "FF");
        map1.put(254, "GG");
        map.putAll(map1);
        System.out.println(map);
        //remove
        //如果删除的key不存在，那就返回null
        Object remove = map.remove(234);
        System.out.println(remove);
        System.out.println(map);
        //clear()
        map.clear();
        System.out.println(map.size());
    }

    @Test
    public void Test2() {
        HashMap map = new HashMap();
        map.put(123, "qwe");
        map.put(234, "asd");
        map.put(345, "zxc");
        //get()，得到key对应的value
        System.out.println(map.get(123));
        //containKey()
        boolean b = map.containsKey(345);
        System.out.println(b);
        //containValue()
        b = map.containsValue("asd");
        System.out.println(b);
        //size()
        System.out.println(map.size());
        //isEmpty()
        System.out.println(map.isEmpty());
        //equals()，括号中放的是map对象
        HashMap map1 = new HashMap();
        map1.put(123, "qwe");
        map1.put(234, "asd");
        map1.put(345, "zxc");
        System.out.println(map.equals(map1));
    }

    @Test
    public void Test3() {
        HashMap map = new HashMap();
        map.put(123, "BB");
        map.put(142, "PP");
        map.put("KKK", "AB");
        //遍历所有的key集，keySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //遍历所有的value集，values()
        Collection values = map.values();
        for (Object value : values) {
            System.out.println(value);
        }
        System.out.println(values);

        //遍历所有的key-value
        //方式一：entrySet()
        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()) {
            Object next = iterator1.next();
            //此处必须强转之后才可以.  因为多态性是运行时行为，编译时看的是左边
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + "----->" + entry.getValue());
        }
        //方式二：
        Set set2 = map.keySet();
        Iterator iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "=====" + value);
        }
    }
}
