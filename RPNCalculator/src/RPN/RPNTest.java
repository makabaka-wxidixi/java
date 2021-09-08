package RPN;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-09-08 8:36
 */
public class RPNTest {
    public static void main(String[] args) {
        //(3+4)*5-6  =>  3 4 + 5 * 6 -
//        String expression = "3 4 + 5 * 6 -";
//        List<String> array = getStringArray(expression);
//        System.out.println(array);
//        //逆波兰计算器
//        int result = calculator(array);
//        System.out.println(result);
//
//        //(3+4)*5-6  =>   3 4 + 5 * 6 -
//        expression = "(3+4)*5-6";
//        List list = arraysOrder(expression);//得到中序的集合
//        //将ArrayList中的数据转换成逆波兰表达式
//        System.out.println(list);
//        String s = reversalOrder(list);
//        System.out.println(s);

        String test = "3+(5+(9-2))*4";
        //用集合存储
        List<String> listTest = arraysOrder(test);
        //逆序表达式
        List s = reversalOrder(listTest);
        //计算器
        System.out.println(calculator(s));
    }

    private static List reversalOrder(List<String> tempList) {
        //创建一个list，用来存储中间数据
        ArrayList list = new ArrayList();
        //创建一个栈，用于存储运算符
        Stack<String> stack = new Stack<>();
        //遍历每一个集合中的数据
        for (String str : tempList) {
            if (str.matches("\\d+")) {
                //遇到数，就录入list
                list.add(str);
            } else { //遇到运算符
                if ("(".equals(str)) {
                    //如果是"("，就压入栈中
                    stack.push(str);
                } else if (")".equals(str)) {
                    //如果遇到")"，就依次弹出栈中的运算符到list中，遇到"("才停止，然后丢弃这一对括号
                    while (true) {
                        if ("(".equals(stack.peek())) {
                            break;
                        }
                        list.add(stack.pop());
                    }
                    //丢弃"("
                    stack.pop();
                } else {//遇到的是运算符
                    while (true) {
                        if (stack.isEmpty() || "(".equals(stack.peek())) {
                            stack.push(str);
                            break;
                        } else if (getPriority(stack.peek()) < getPriority(str)) {
                            //如果运算符的优先级比栈顶运算符优先级高，就压入栈
                            stack.push(str);
                            break;
                        } else {
                            //和栈顶运算符相比优先级相等或者小于，就将栈顶运算符弹出并录入list中，然后该运算符就和栈中新的栈顶元素相比较（循环）
                            list.add(stack.pop());
                        }
                    }
                }
            }
        }
        //将栈中的所有运算符全部弹出到list中，得到的list在化成String形，进行返回
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //获取运算符优先级
    private static int getPriority(String str) {
        int result = 0;
        switch (str) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                try {
                    throw new RuntimeException("输入运算符错误");
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
        }
        return result;
    }

    private static List<String> arraysOrder(String expression) {
        //将expression存到ArrayList中
        String str = "";
        int index = 0;
        ArrayList<String> list = new ArrayList<String>();
        do {
            //下一个字符
            String ch = expression.substring(index, index + 1);
            //如果是运算符就录入list
            if (isOper(ch)) {
                list.add(ch);
                index++;
            } else {
                //如果是数字,就判断下一个是不是数字，如果是就进行组合（循环），然后录入list
                do {
                    ch = expression.substring(index, index + 1);
                    str += ch;
                    index++;
                    //不是最后一个字符，并且下一个还是数字，就进行循环
                } while ((index < expression.length()) && expression.charAt(index) <= 57 && expression.charAt(index) >= 48);
                //录入list中
                list.add(str);
                str = "";
            }
        } while (index < expression.length());
        return list;
    }

    public static boolean isOper(String str) {//字符串的比较用equals
        return "(".equals(str) || ")".equals(str) || "+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str);
    }

    public static List<String> getStringArray(String string) {
        String[] s = string.split(" ");
        ArrayList<String> list = new ArrayList<String>();
        for (String ee : s) {
            list.add(ee);
        }
        return list;
    }

    //逆波兰计算器
    public static int calculator(List<String> arr) {
        //从左到右，遇到数字就入栈，遇到运算符就弹出两个数据，然后：后弹出的-先弹出的，再将结果入栈
        //遍历数组
        Stack<String> stack = new Stack<String>();
        int num1;
        int num2;
        String ret;
        for (String str : arr) {
            //如果是数字，入栈
            if (str.matches("\\d+")) {
                stack.push(str);
            } else {
                //如果是运算符就弹出两个数据，并做运算，然后再压入栈中
                num1 = Integer.parseInt(stack.pop());
                num2 = Integer.parseInt(stack.pop());
                ret = operation(num1, num2, str) + "";
                stack.push(ret);
            }
        }
        //最后栈中剩一个元素，就是结果
        return Integer.parseInt(stack.pop());
    }

    static int operation(int num1, int num2, String str) {
        int result = 0;
        switch (str) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num2 - num1;
                break;
            case "*":
                result = num2 * num1;
                break;
            case "/":
                result = num2 / num1;
                break;
            default:
                try {
                    throw new RuntimeException("运算符输入错误");
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
        }
        return result;
    }
}
