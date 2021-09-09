/**
 * @Author mkbk
 * @Description
 * @Create 2021-09-07 15:55
 */
public class CalculatorTest {
    public static void main(String[] args) {
        //表达式
        String expression = "5+2*1*4-3";

        Stack<Double> numStack = new Stack(10);//数栈
        Stack<Character> operStack = new Stack(10);//符号栈
        char ch;
        char oper;
        Double num1;
        Double num2;
        int index = 0;
        Double operation;
        String num = "";
        while (true) {
            //得到字符
            ch = expression.substring(index, index + 1).charAt(0);
            if (!numStack.isOper(ch)) {
                while (true) {
                    num += ch;
                    //当index等于表达式的最大长度（代表遍历完毕）或者表达式下一位是运算符，就入栈并结束循环
                    if ((index == (expression.length() - 1)) || numStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Double.parseDouble(num));
                        index++;
                        num = "";
                        break;
                    } else {
                        index++;
                    }
                }
            } else {
                //如果是符号就进行判断
                if (operStack.isEmpty()) {
                    //如果是第一个符号，就直接入符号栈
                    operStack.push(ch);
                    index++;
                } else {
                    if (operStack.getPriority(operStack.getTop()) < operStack.getPriority(ch)) {
                        //否则，就和栈顶元素进行比较，如果优先级大于符号栈顶元素，就直接入栈
                        operStack.push(ch);
                        index++;
                    } else {
                        //如果优先级小于等于符号栈顶元素，就从数栈中出两个数，从符号栈中出一个，进行运算
                        //运算结果再入数栈，将符号入符号栈
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        operation = numStack.operation(num1, num2, oper);
                        numStack.push(operation);//新数据压入数栈
                        operStack.push(ch);//符号入栈
                        index++;
                    }
                }
            }
            if (index > expression.length() - 1) {
                break;
            }
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
        System.out.println(numStack.pop());
    }
}

class Stack<T> {
    private T[] arr;
    private int maxSize;
    private int top = -1;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        arr = (T[]) new Object[maxSize];
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

//    //比较优先级
//    boolean priority(char ch) {
//        if (ch == '*' || ch == '/') {
//            if (getTop() == '+' || getTop() == '-') {
//                return true;
//            } else {
//                return false;
//            }
//        }
//        return false;
//    }

    private static final int ADD = 1;
    private static final int SUB = 1;
    private static final int MUL = 2;
    private static final int DIV = 2;

    int getPriority(char ch) {
        switch (ch) {
            case '+':
                return ADD;
            case '-':
                return SUB;
            case '*':
                return MUL;
            case '/':
                return DIV;
            default:
                return 0;
        }
    }

    //得到栈顶元素
    T getTop() {
        return (T) arr[top];
    }

    public <T extends Number> double operation(T num1, T num2, char ch) {
        double one = num1.doubleValue();
        double two = num2.doubleValue();
        if (isOper(ch)) {
            switch (ch) {
                case '+':
                    return one + two;
                case '-':
                    return two - one;
                case '*':
                    return one * two;
                case '/':
                    return two / one;
            }
        } else {
            try {
                throw new RuntimeException();
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        return 0.0;
    }

    void push(T ch) {
        if (isFull()) {
            try {
                throw new RuntimeException("栈满");
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        arr[++top] = ch;
    }

    T pop() {
        if (isEmpty()) {
            try {
                throw new RuntimeException("栈空");
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        return arr[top--];
    }

    void list() {
        if (isEmpty()) {
            try {
                throw new RuntimeException("栈空");
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        for (int i = top; i >= 0; i--) {
            System.out.println("arr[" + i + "]=" + arr[i]);
        }
    }
}