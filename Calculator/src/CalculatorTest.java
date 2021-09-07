/**
 * @Author mkbk
 * @Description
 * @Create 2021-09-07 15:55
 */
public class CalculatorTest {
    public static void main(String[] args) {
        Stack numStack = new Stack(10);//数栈
        Stack operStack = new Stack(10);//符号栈
        //表达式
        String expression = "50+23*1*4-3";
        char ch;
        char oper;
        int num1;
        int num2;
        int index = 0;
        int operation;
        String num = "";
        while (true) {
            //得到字符
            ch = expression.substring(index, index + 1).charAt(0);
            if (!numStack.isOper(ch)) {
                //如果是数，就入栈
                num += ch;
                //看看下一个是不是数字
                if (index == (expression.length() - 1) || numStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                    int i = Integer.parseInt(num);
                    numStack.push(i);
                    num = "";
                }
            } else {
                //如果是符号就进行判断
                if (operStack.isEmpty()) {
                    //如果是第一个符号，就直接入符号栈
                    operStack.push(ch);
                } else {
                    if (operStack.priority(ch)) {
                        //否则，就和栈顶元素进行比较，如果优先级大于符号栈顶元素，就直接入栈
                        operStack.push(ch);
                    } else {
                        //如果优先级小于等于符号栈顶元素，就从数栈中出两个数，从符号栈中出一个，进行运算
                        //运算结果再入数栈，将符号入符号栈
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        operation = numStack.operation(num1, num2, oper);
                        numStack.push(operation);//新数据压入数栈
                        operStack.push(ch);//符号入栈
                    }
                }
            }
            if (index == expression.length() - 1) {
                break;
            }
            index++;
        }
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            //数栈出两个，符号栈出一个，进行运算，然后入栈
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            operation = numStack.operation(num1, num2, oper);
            numStack.push(operation);
        }
        //最后数栈中还剩一个元素，这就是结果
        int pop = numStack.pop();
        System.out.println(pop);
    }
}

class Stack {
    private int[] arr;
    private int maxSize;
    private int top = -1;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    boolean isFull() {
        if (top == maxSize - 1) {
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

    //判断是否是运算符
    boolean isOper(char ch) {
        return ch == '-' || ch == '+' || ch == '*' || ch == '/';
    }

    //比较优先级
    boolean priority(char ch) {
        if (ch == '*' || ch == '/') {
            if (getTop() == '+' || getTop() == '-') {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    //得到栈顶元素
    char getTop() {
        return (char) arr[top];
    }

    int operation(int num1, int num2, char ch) {
        if (isOper(ch)) {
            switch (ch) {
                case '+':
                    return num1 + num2;
                case '-':
                    return num2 - num1;
                case '*':
                    return num1 * num2;
                case '/':
                    return num2 / num1;
            }
        } else {
            try {
                throw new RuntimeException();
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        return -999;
    }


    void push(int ch) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        arr[++top] = ch;
    }

    char pop() {
        try {
            if (isEmpty()) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (char) arr[top--];
    }

    void list() {
        if (isEmpty()) {
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println("arr[" + i + "]=" + arr[i]);
        }
    }
}