package lock;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口的方式JDK5.0
 * 相比run()方法可以有返回值
 * 方法可以抛出异常
 * 支持泛型的返回值
 * 需要借助FutureTask类
 *
 * @Author mkbk
 * @Description
 * @Create 2021-08-23 13:44
 */
//创建一个实现Callable接口的实现类
class MyThread implements Callable {
    //重写实现类中的call方法
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }

        return sum;//装箱
    }
}

public class ThreadNew {
    public static void main(String[] args) {
        //实现类的实例化
        MyThread myThread = new MyThread();
        //创建一个FutureTask类的对象，将myThread的实例化对象作为参数放入构造器
        FutureTask futureTask = new FutureTask(myThread);
        //开启一个线程，由于FutureTask也实现了Callable接口，所以也可以做参数
        new Thread(futureTask).start();
        try {//get方法返回值是调用FutureTask构造器中Callable接口实现类中重写的call方法的返回值
            //创建一个对象来接收call的返回值
            Object sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
