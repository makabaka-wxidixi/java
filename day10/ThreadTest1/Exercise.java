package ThreadTest1;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-08-21 13:28
 */
public class Exercise {
    public static void main(String[] args) {
        myThread1 t1 = new myThread1();
        t1.setName("子线程");
        t1.start();

        Thread.currentThread().setName("主线程");
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {

                        System.out.println(Thread.currentThread().getName() + ":" + i);

                }
            }
        }.start();

    }
}

class myThread1 extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {

                System.out.println(myThread1.currentThread().getName() + ":" + i);

            if(i%2==0){
                myThread1.yield();
            }
        }
    }
}

