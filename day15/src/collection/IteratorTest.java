package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-08-26 20:54
 */
public class IteratorTest {

    @Test
    public void Test1(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("yasuo",21));
        coll.add(new Person("shitouren",21));
        coll.add("AA");
//生成一个迭代器
        Iterator iterator = coll.iterator();

//        方式一
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());

//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
