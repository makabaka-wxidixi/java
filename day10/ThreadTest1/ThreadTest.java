package ThreadTest1;

/**
 * 多线程的创建，方式一：继承于Thread类
 * 1.创建一个继承Thread类的子类
 * 2.重写Thread类的run()-->将此线程执行的操作声明中次run方法中
 * 3.创建Thread类的子类的对象-->在主线中去做
 * 4.通过此对象调用start()
 *
 * 优先级
 * MAX_PRIORITY   10
 * MIN_PRIORITY   1
 * NORM_PRIORITY  5   默认优先级
 * @Author mkbk
 * @Description
 * @Create 2021-08-21 10:16
 */

class MyThread extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
//            try {
//                sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(getName()+":"+getPriority()+":"+i);
        }
    }
}


public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.setName("子线程");
        t1.setPriority(5);//子线程优先级调到最低
        t1.start();

//        MyThread t2 = new MyThread();
//        t2.start();


        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(5);//主线程优先级调到最高
        for(int i=0;i<100;i++){
//            System.out.println("asdfasdfasdfasdfasdfasdfasdfasdf");
                System.out.println(Thread.currentThread().getName()+":"+
                        Thread.currentThread().getPriority()+"："+"-----");
//            if(i==4){
//                try {
//                    t1.join();//停下来，执行当前对象所在的线程
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
//        System.out.println(t1.isAlive());
    }
}
