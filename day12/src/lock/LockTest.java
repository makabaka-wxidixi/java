package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题方式三：Lock锁---jdk5.0新增
 * 和synchronized与Lock有什么区别
 * 相同：二这都可以解决线程安全问题
 * 不同：1.synchronized机制在执行玩相应的同步代码之后，自动释放同步监视器
 *      2.lock需要手动的启动同步，同时结束同步也需要手动的实现
 *
 * @Author mkbk
 * @Description
 * @Create 2021-08-23 9:55
 */

class Window implements Runnable {
    private int ticket = 100;
    //实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();//默认是false

    @Override
    public void run() {
        while (true) {
            try{
//                上锁
                lock.lock();

                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "卖票，票号为" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }finally {
//                解锁
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}


