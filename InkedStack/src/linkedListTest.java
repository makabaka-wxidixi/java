import java.util.LinkedList;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-09-07 19:35
 */
public class linkedListTest {
    public static void main(String[] args) {
//        linkedList linkedList = new linkedList();
//        linkedList.push(new Person("亚索", 23));
//        linkedList.push(new Person("永恩", 24));
//        linkedList.push(new Person("石头人", 25));
//        linkedList.push(new Person("塞拉斯", 26));
//        System.out.println(linkedList.size());
//        linkedList.list();
//        linkedList.pop();
//        System.out.println(linkedList.size());
//        linkedList.list();
//        System.out.println("--------------");
//        linkedList.clear();
//        System.out.println(linkedList.size());
//        System.out.println(linkedList.isEmpty());

        linkedList<String> list = new linkedList<>();
        list.push("我是你爸爸");
        list.push("真伟大");
        list.push("养你这么大");
        list.push("你还不听话");
        list.list();

    }
}

class linkedList<T> {
    private Node<T> base;
    private Node<T> top;
    private int count = 0;

    linkedList() {
        Node<T> node = new Node();
        base = node;
        top = node;
        base.data = null;
    }

    void push(T obj) {
        Node<T> newNode = new Node();
        newNode.data = obj;
        newNode.next = top;
        top = newNode;
        count++;
    }

    T pop() {
        if (isEmpty()) {
            try {
                throw new RuntimeException("栈空");
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        T ret = top.data;
        top = top.next;
        count--;
        return ret;
    }

    void list() {
        if (isEmpty()) {
            return;
        }
        Node<T> temp = top;
        while (true) {
            if (temp == base) {
                return;
            }
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    boolean isEmpty() {
        if (top == base) {
            return true;
        }
        return false;
    }

    T getTop() {
        return top.data;
    }

    void clear() {
        if (!isEmpty()) {
            top = base;
        }
        count = 0;
        return;
    }

    int size() {
        return count;
    }
}

class Node<T> {
    Node next;
    public T data;
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
