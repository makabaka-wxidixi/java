package ReflectionTest;

import org.junit.Test;

import java.util.Random;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-09-04 19:13
 * <p>
 * 通过反射创建对应的运行时类的对象
 */
public class NewInstanceTest {
    @Test
    public void Test1() throws InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;
        //newInstance方法来创建运行时类的对象，调用了运行时类的空参构造器
        Person o = clazz.newInstance();
        System.out.println(o);
    }

    //理解反射的动态性
    @Test
    public void Test2(){
        for (int i = 0; i < 100; i++) {
            int num = new Random().nextInt(3);
            String classPath = "";
            switch (num) {
                case 0:
                    classPath = "ReflectionTest.Person";
                    break;
                case 1:
                    classPath = "java.util.Date";
                    break;
                case 2:
                    classPath = "java.lang.Object";
                    break;
            }
            Object o = null;
            try {
                o = getInstance(classPath);
                System.out.println(o);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public Object getInstance(String path) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        //clazz就是运行时类，这一步决定将要创建的对象是何种类型的
        Class clazz = Class.forName(path);
        //得到运行时类的对象
        return clazz.newInstance();
    }
}
