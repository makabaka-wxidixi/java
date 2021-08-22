package WindowTicket;

/**
 *
 * 栗子：创建三个窗口卖票，总票数为100张，使用实现Runnable接口的方式
 * 问题：卖票过程中，出现了重票、错票————>出现了线程安全问题
 * 问题的原因：当某个线程操作车票过程中，尚未完成操作，其他线程也参与进来，也操作车票。
 * 解决：当线程a在操作ticket时，其他线程都不能参与进来，直到线程a操作完ticket时，其他线程才可以开始操作ticket
 *      即使线程a出现了阻塞也不能被改变
 * 在java中，我们通过同步机制，来解决线程安全问题
 * 方式一：同步代码块
 *
 * synchronized(同步监视器){
 *     //需要被同步的代码
 * }
 * 说明：1.操作共享数据的代码，即为需要被同步的代码
 *      2.共享数据：多个线程共同操作的变量。比如：ticket就是共享数据
 *      3.同步监视器，俗称，锁。任何一个类的对象，都可以充当锁。
 *              要求：多个线程必须用一把锁
 *
 * 方式二：同步方法
 *
 *
 * 同步的方法：解决了线程安全的问题。
 *            局限性：操作同步代码时，只能有一个线程参与，其他线程等待，相当于是一个单线程，效率低
 * @Author mkbk
 * @Description
 * @Create 2021-08-21 18:37
 */
class Window1 implements Runnable{
    private int ticket=100;

    @Override
    public void run() {
        while(true){
            synchronized(this){
                if(ticket>0){

                    //sleep使当前线程等待，这时候cpu会切换线程执行，可能会有其他线程也进入这个run，此时就出现了线程安全问题
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+"卖票，票号为："
                            +ticket);
                    ticket--;
                }else{
                    break;
                }
            }
        }
    }
}

public class WindowsTest1 {
    public static void main(String[] args) {
        Window1 window1 = new Window1();
        //三个线程来执行一个对象，相当于默认加了一个static
        Thread w1 = new Thread(window1);
        Thread w2 = new Thread(window1);
        Thread w3 = new Thread(window1);

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();

    }
}
