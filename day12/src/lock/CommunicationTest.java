package lock;

/**
 *
 * 线程通信的栗子：使用两个线程打印1-100，线程1，线程2交替打印
 *
 * 涉及到的三个方法
 * wait()：一旦执行此方法，当前线程就会进入阻塞状态，并释放同步监视器
 * notify()：一旦执行此方法，就会唤醒被wait阻塞的线程，如果有多个线程被wait，就唤醒
 *              优先级最高的那个
 * notifyAll()：唤醒所有被wait的线程
 *
 * 说明：
 * 1.该三个方法只能在同步代码块或者同步方法中使用，Lock都不行
 * 2.该三个方法的调用者必须是同步代码块或者同步方法中的同步监视器
 *
 * sleep和wait的异同
 * 同：一旦执行方法，都会使当前线程进入阻塞状态
 * 异：1.两个方法生命位置不同，一个是在Thread类中，一个是在Object类中
 *    2.调用的要求不同：sleep()可以在任何场景下调用，wait()必须在同步代码块或者同步方法中
 *    3.关于是否释放同步监视器：sleep不会，wait会
 * @Author mkbk
 * @Description
 * @Create 2021-08-23 11:15
 */

class Number implements Runnable{
    private int number=1;

    @Override
    public void run() {
        while(true){
            synchronized(this){
                notify();
                if(number<=100){
                    System.out.println(Thread.currentThread().getName()+"："+number);
                    number++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }
        }
    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();
    }
}
