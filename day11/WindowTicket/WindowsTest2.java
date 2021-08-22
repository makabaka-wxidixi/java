package WindowTicket;

/**
 * 同步方法解决实现Runnable接口的线程安全问题
 *
 * @Author mkbk
 * @Description
 * @Create 2021-08-22 19:08
 */
class Window3 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {

            show();

        }
    }

    private synchronized void show(){//锁就是this
        if (ticket > 0) {

            //sleep使当前线程等待，这时候cpu会切换线程执行，可能会有其他线程也进入这个run，此时就出现了线程安全问题
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "卖票，票号为："
                    + ticket);
            ticket--;
        }
    }
}

public class WindowsTest2 {
    public static void main(String[] args) {
        Window3 window3 = new Window3();
        //三个线程来执行一个对象，相当于默认加了一个static
        Thread w1 = new Thread(window3);
        Thread w2 = new Thread(window3);
        Thread w3 = new Thread(window3);

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();

    }
}

