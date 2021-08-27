package collection;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-08-27 14:03
 */
public class TreeSetTest {
    /*
    1.向TreeSet中添加的数据，要求是相同类的对象
     */

    @Test
    public void Test1(){
        TreeSet treeSet = new TreeSet();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(6);
        treeSet.add(-1);
        treeSet.add(-12);

        Iterator iterator = treeSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(treeSet);
    }
    @Test
    //自然排序（实现Comparable接口）中，比较两个对象是否相等标准为：compareTo()返回0，不再是equals()
    public void Test2(){
        TreeSet treeSet = new TreeSet();
        treeSet.add(new Person("tailong",23));
        treeSet.add(new Person("yongen",25));
        treeSet.add(new Person("yasuo",21));
        treeSet.add(new Person("jiansheng",35));
        treeSet.add(new Person("wanhao",22));
        treeSet.add(new Person("yasuo",56));

        Iterator iterator = treeSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    //定制排序
    public void Test3(){
        Comparator com=new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Person&&o2 instanceof Person){
                     Person person1=(Person)o1;
                     Person person2=(Person)o2;
                     int compare=Integer.compare(person1.getAge(), person2.getAge());
                     if(compare!=0){
                         return compare;
                     }else{
                         return person1.getName().compareTo(person2.getName());
                     }
                }else{
                    throw new RuntimeException("输入数据类型不匹配");
                }
            }
        };
        //构造器中有参数的是指定排序，指定排序优先级大于自然排序
        TreeSet treeSet = new TreeSet(com);
        treeSet.add(new Person("tailong",23));
        treeSet.add(new Person("yongen",25));
        treeSet.add(new Person("yasuo",21));
        treeSet.add(new Person("jiansheng",35));
        treeSet.add(new Person("wanhao",25));
        treeSet.add(new Person("yasuo",56));

        Iterator iterator = treeSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
