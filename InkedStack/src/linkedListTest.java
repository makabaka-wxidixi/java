

/**
 * @Author mkbk
 * @Description
 * @Create 2021-09-07 19:35
 */
public class linkedListTest {
    public static void main(String[] args) {
        linkedList linkedList = new linkedList();
        linkedList.push(new Person("亚索", 23));
        linkedList.push(new Person("永恩", 24));
        linkedList.push(new Person("石头人", 25));
        linkedList.push(new Person("塞拉斯", 26));
        System.out.println(linkedList.size());
        linkedList.list();
        linkedList.pop();
        System.out.println(linkedList.size());
        linkedList.list();
        System.out.println("--------------");
        linkedList.clear();
        System.out.println(linkedList.size());
        System.out.println(linkedList.isEmpty());
    }
}

class linkedList {
    private Node base;
    private Node top;
    private int count = 0;

    linkedList() {
        Node node = new Node();
        base = node;
        top = node;
        base.data = null;
    }

    void push(Object obj) {
        Node newNode = new Node();
        newNode.data = obj;
        newNode.next = top;
        top = newNode;
        count++;
    }

    Object pop() {
        if (isEmpty()) {
            try {
                throw new RuntimeException("栈空");
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        Object ret = top.data;
        top = top.next;
        count--;
        return ret;
    }

    void list() {
        if (isEmpty()) {
            return;
        }
        Node temp = top;
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

    Object getTop() {
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

class Node {
    Node next;
    public Object data;
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
