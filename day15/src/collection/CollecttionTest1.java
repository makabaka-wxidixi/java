package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-08-26 18:41
 */
public class CollecttionTest1 {

    @Test
    public void Test1(){
        Collection coll=new ArrayList();
//        add()
        coll.add("asd");
        coll.add("AA");
        coll.add(123);
        coll.add(new Date());
//        size()
        System.out.println(coll.size());
//        addAll()
        Collection coll1=new ArrayList();
        coll1.add("efg");
        coll1.add("BB");
        coll1.add("CC");
        coll.addAll(coll1);
        System.out.println(coll.size());
//        clear()
        coll.clear();
//        isEmpty()
        System.out.println(coll.isEmpty());

        System.out.println(coll);
    }
}
