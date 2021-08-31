package generic;

import org.junit.Test;

import java.util.*;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-08-31 18:00
 */
public class genericTest2 {
    /*
    提供一个方法，用于遍历获取HashMap<String,String>中的所有value，并存放在list中使用，考虑集合中反省的使用
     */
    @Test
    public void Test1() {
        HashMap<String, String> map = new HashMap<>();
        map.put("AA", "BB");
        map.put("CC", "DD");
        map.put("EE", "FF");
        map.put("GG", "HH");

        List list = getValues(map);
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }

    private List<String> getValues(HashMap<String, String> map) {
        Collection<String> values = map.values();
        ArrayList<String> list = new ArrayList<>();
        for (String str : values) {
            list.add(str);
        }
        return list;
    }
}
