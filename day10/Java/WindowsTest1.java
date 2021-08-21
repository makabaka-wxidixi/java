package Java;

/**
 *
 * 栗子：创建三个窗口卖票，总票数为100张，使用实现Runnable接口的方式
 * @Author mkbk
 * @Description
 * @Create 2021-08-21 18:37
 */
class Window1 implements Runnable{
    private int ticket=100;

    @Override
    public void run() {
        while(true){
            if(ticket>0){
                System.out.println(Thread.currentThread().getName()+"卖票，票号为："
                +ticket);
                ticket--;
            }else{
                break;
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
