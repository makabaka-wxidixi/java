package ThreadTest1;

/**
 * 创建多线程的方式二：实现Runnable接口
 * 1.创建一个实现了Runnable接口得类
 * 2.实现类去实现Runnable中的抽象方法：run()
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5.通过Thread类的对象调用start()
 *
 * 总结：根据run()方法内部，target是否为null，可以分为两种创建线程的方法
 *
 * @Author mkbk
 * @Description
 * @Create 2021-08-21 17:56
 */

class MThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest2 {
    public static void main(String[] args) {
        //创建实现该接口的类的对象
        MThread mThread = new MThread();
        //将该对象作为参数填入Thread的构造器
        Thread m1 = new Thread(mThread);
        //调用m1的start()，start作用是：1.启动线程。2.调用当前线程的run()\
        m1.setName("线程一");
        m1.start();

        Thread m2 = new Thread(mThread);
        m2.setName("线程二：");
        m2.start();
    }
}
