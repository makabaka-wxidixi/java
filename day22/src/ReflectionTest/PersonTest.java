package ReflectionTest;

import org.junit.Test;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-09-04 17:40
 */
public class PersonTest {
    //获取Class实例的方式，Class的实例就对应着一个运行时类
    @Test
    public void Test1() throws ClassNotFoundException {
        //方式一：调用运行时类的属性class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);
        //方式二：通过运行时类的对象
        Person person = new Person();
        Class<? extends Person> clazz2 = person.getClass();
        System.out.println(clazz2);
        //方式三：通过Class的静态方法，这里必须指定所在包（用的多）
        Class<?> clazz3 = Class.forName("ReflectionTest.Person");

        clazz3 = Class.forName("java.lang.String");
//值后续是可以更改的
//        System.out.println(clazz3);
        System.out.println(clazz1 == clazz2);//true
        System.out.println(clazz1 == clazz3);//true
        //总结，加载到内存中的运行时类，会缓存一定的时间，在此时间内，可以通过不同的方式来获取此运行时类

    }

}

class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
