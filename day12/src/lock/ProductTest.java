package lock;

/**
 * 线程通信的应用：经典例题：生产者、消费者问题
 * <p>
 * 生产者(Productor)讲产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如：20)，如果生产者试图生产更多的产品，店员，
 * 会叫生产者停一下，如果店中有空位放了产品了，再通知生产者继续生产：如果店中没有产品
 * 店员会叫消费者等一下，如果有产品了再通知消费者来取走
 * <p>
 * 分析
 * 1.是否有多线程问题？是，生产者线程，消费者线程
 * 2.是否有共享数据？是，店员（或产品）
 * 3.如何解决线程的安全问题？同步机制，有三种
 * 4.是否设计线程的通信？是
 *
 * @Author mkbk
 * @Description
 * @Create 2021-08-23 11:50
 */
//店员
class Clerk {
    private int productCount = 0;

    public void consumeProduct() {
        synchronized(this){
            if(productCount>0){
                System.out.println(Thread.currentThread().getName()+"开始消费第"+productCount+"个产品");
                productCount--;
                notify();
            }else{
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void produceProduct() {
        synchronized(this){
            if(productCount<20){
                productCount++;
                System.out.println(Thread.currentThread().getName()+"开始生产第"+productCount+"个产品");
                notify();
            }else{
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Customerr extends Thread {
    private Clerk clerk;

    public Customerr(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("开始消费...");
        while (true) {

            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}

class Productor extends Thread {
    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    public void run() {
        System.out.println("开始生产...");
        while (true) {

            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }

}

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Customerr c1 = new Customerr(clerk);
        Productor p1 = new Productor(clerk);
        Customerr c2=new Customerr(clerk);

        c1.setName("消费者");
        p1.setName("生产者");
        c2.setName("消费者");

        c1.start();
        c2.start();
        p1.start();
    }
}
