package generic;


import org.junit.Test;

import java.util.*;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-08-31 17:48
 */
public class genericTest1 {

    /*
    遍历Map的key集，value集，key-value集，使用上泛型,三种遍历方式
     */
    @Test
    public void Test1() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("qwe", 12);
        map.put("asd", 13);
        map.put("zxc", 14);

        Set<String> key = map.keySet();
        for (String k : key) {
            System.out.println(k);
        }

        Collection<Integer> values = map.values();
        Iterator<Integer> iterator = values.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator1 = entries.iterator();
        while (iterator1.hasNext()) {
            Map.Entry<String, Integer> next = iterator1.next();
            String keys = next.getKey();
            Integer value = next.getValue();
            System.out.println(keys + "------>" + value);
        }
    }

}
