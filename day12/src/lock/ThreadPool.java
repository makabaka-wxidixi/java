package lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建线程的方式四：使用线程池
 *
 * @Author mkbk
 * @Description
 * @Create 2021-08-23 14:45
 */

class NumberThread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class NumberThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {

        //创建一个线程池，池中最大线程数为10
        ExecutorService service = Executors.newFixedThreadPool(10);
//        System.out.println(service.getClass());
//        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
//        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime(12);
        //调用池中的线程，线程会调用重写的run方法，提供事项Runnable或者Callable接口的实现类的对象
        service.execute(new NumberThread1());//适用于Runnable
        service.execute(new NumberThread2());
//        service.submit(Callable callable);submit适用于Callable
        //关闭线程池
        service.shutdown();
    }
}
