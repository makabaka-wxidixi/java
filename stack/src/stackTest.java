import jdk.jfr.StackTrace;
import org.junit.Test;

import java.util.Scanner;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-09-07 11:56
 */
public class stackTest {

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        Scanner scanner = new Scanner(System.in);
        String key = "";
        while (true) {
            System.out.println("push");
            System.out.println("pop");
            System.out.println("print");
            System.out.println("exit");
            System.out.println("请选择：");
            key = scanner.next();
            switch (key) {
                case "push":
                    System.out.println("请输入要压入的数据");
                    int i = scanner.nextInt();
                    try {
                        stack.push(i);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "pop":
                    try {
                        System.out.println("弹出的数据为：" + stack.pop());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "print":
                    stack.print();
                    break;
                case "exit":
                    scanner.close();
                    System.out.println("程序退出");
                    return;
                default:
                    System.out.println("输入数据错误");
                    break;
            }
        }
    }
}

class Stack {
    private int[] arr;
    private int maxsize;
    private int top = -1;

    public Stack(int maxsize) {
        this.maxsize = maxsize;
        arr = new int[maxsize];
    }

    public int getMaxsize() {
        return maxsize;
    }

    boolean isFull() {
        if (top == (maxsize - 1)) {
            return true;
        }
        return false;
    }

    boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    //入栈
    void push(int sum) throws RuntimeException {
        if (isFull()) {
            throw new RuntimeException("栈满");
        }
        arr[++top] = sum;
    }

    //出栈
    int pop() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return arr[top--];
    }

    //显示栈
    void print() {
        if (isEmpty()) {
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println("arr["+i+"]=" + arr[i]);
        }
    }
}
