package WindowTicket;

/**
 * 使用同步方法解决实现Runnable接口的线程安全问题
 *
 * 关于同步方法的总结：
 *  1.同步方法任然涉及到同步监视器，只是不需要我们显示的声明
 *  2.非静态的同步方法，同步监视器是this
 *    静态同步方法，同步监视器是当前类本身
 *
 * @Author mkbk
 * @Description
 * @Create 2021-08-22 19:51
 */
class Window4 extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {

            show();

        }
    }
    private synchronized static void show(){//同步监视器是该类本身
        if (ticket > 0) {

            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "：卖票，票号为" + ticket);
            ticket--;
        }
    }
}

public class WindowsTest4 {
    public static void main(String[] args) {
        Window4 w1 = new Window4();
        Window4 w2 = new Window4();
        Window4 w3 = new Window4();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();
    }
}
