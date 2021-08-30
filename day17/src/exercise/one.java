package exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-08-30 18:28
 */
public class one {
    @Test
    public void Test1(){
        ArrayList list = new ArrayList();

        list.add(123);
        list.add(435);
        list.add(145);
        list.add(13);
        list.add(163);
        list.add(113);
        //方式一
        Collections.sort(list, new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Integer&&o2 instanceof Integer){
                    return -Integer.compare((int)o1,(int)o2);
                }
                throw new RuntimeException("输入数据错误");
            }
        });
        System.out.println(list);
    }

    @Test
    public void Test2(){
        Student p1 = new Student("yasuo", 99, "123");
        Student p2 = new Student("yongen", 91, "124");
        Student p3 = new Student("tailong", 49, "125");
        Student p4 = new Student("wanhao", 39, "126");
        Student p5 = new Student("yi", 92, "127");
        ArrayList list = new ArrayList();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        Collections.sort(list);
        Iterator iterator = list.iterator();
        for (int i = 0; i < 3; i++) {
            System.out.println(list.get(i));
        }
    }
}
