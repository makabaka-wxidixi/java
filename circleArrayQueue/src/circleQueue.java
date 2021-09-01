import java.util.Scanner;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-09-01 21:11
 */
public class circleQueue {
    public static void main(String[] args) {
        arrayQueue queue = new arrayQueue(4);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        char key = ' ';
        while (flag) {
            System.out.println("a(add):添加数据");
            System.out.println("g(get):取出数据");
            System.out.println("p(print):打印数据");
            System.out.println("e(exit):退出");
            key = scanner.next().charAt(0);
            switch (key) {
                case 'a':
                    System.out.println("请输入要添加的数据");
                    int value = scanner.nextInt();
                    try {
                        queue.addQueue(value);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'g':
                    int queue1 = 0;
                    try {
                        queue1 = queue.getQueue();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'p':
                    queue.printQueue();
                    break;
                case 'e':
                    flag = false;
                    System.out.println("退出成功");
                    break;
                default:
                    System.out.println("输入数据错误，请重新输入");
                    break;
            }
        }
        //关流
        scanner.close();
    }
}

class arrayQueue {
    private int maxSize;
    private int rear;
    private int front;
    private int[] arr;

    public arrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public void printQueue() {
        int count = 0;
        for (int i = front; i < front + number(); i++) {
            System.out.println("arr["+(count++)+ "]=" + arr[i % maxSize]);
        }
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {//满的时候返回true
        return (rear + 1) % maxSize == front;
    }

    public int number() {
        return (rear + maxSize - front) % maxSize;
    }

    public void addQueue(int add) throws RuntimeException {
        if (isFull()) {
            throw new RuntimeException("队列已满，无法添加数据");
        } else {
            arr[rear] = add;
            rear = (rear + 1) % maxSize;
        }
    }

    public int getQueue() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("队列以空，无法取出数据");
        } else {
            int get = arr[front];
            front = (front + 1) % maxSize;
            return get;
        }
    }
}
