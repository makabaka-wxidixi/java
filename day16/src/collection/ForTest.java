package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/** 增强for循环，用于遍历数组、集合
 * @Author mkbk
 * @Description
 * @Create 2021-08-27 8:49
 */
public class ForTest {
    @Test
    public void Test1(){
        Collection coll = new ArrayList();
        coll.add("ABC");
        coll.add("aa");
        coll.add(new String("yasuo"));
        coll.add(123);
        coll.add(456);
        coll.add(new Person("shitouren", 23));

        for(Object obj:coll){
            System.out.println(obj);
        }
    }
}
