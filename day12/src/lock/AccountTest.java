package lock;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-08-23 10:28
 */

class Customer extends Thread {
    private int index = 3;
    private static int balance = 0;//账户余额
    private static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (index <= 0) {
                    break;
                } else {
                    balance += 1000;
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("当前账户余额为" + balance + "，是" + Thread.currentThread().getName() + "存的");
                    index--;
                }
            }
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Customer p1 = new Customer();
        Customer p2 = new Customer();

        p1.setName("储户一");
        p2.setName("储户二");

        p1.start();
        p2.start();
    }
}
