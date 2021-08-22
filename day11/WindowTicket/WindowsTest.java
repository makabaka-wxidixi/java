package WindowTicket;

/**
 * 使用同步代码块来解决继承Thread类的方式的线程安全问题
 * 栗子：创建三个窗口来买票，总票数为100张
 * 存在线程安全问题，待解决
 *
 * @Author mkbk
 * @Description
 * @Create 2021-08-21 17:38
 */
class Window extends Thread {
    private static int ticket = 100;
    //需要创建一个单例，来创建锁
    private static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (ticket > 0) {

                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(getName() + "：卖票，票号为" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowsTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();
    }
}
