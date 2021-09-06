import java.net.InetAddress;
import java.util.Stack;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-09-06 8:29
 */
public class linkedList {
    public static void main(String[] args) {
        singleLinkedList list = new singleLinkedList();
        list.addNode(new Node(2));
        list.addNode(new Node(6));
        list.addNode(new Node(3));
        list.addNode(new Node(6));

        System.out.println("利用栈逆序打印");
        list.reversePrint();

        System.out.println("遍历链表");
        list.list();

        int count = list.nodeCount();
        System.out.println("有 " + count + " 个结点");

        list.checkFormEnd(3);

        System.out.println("------反转链表------");
        list.reversalList3();
        list.list();

        singleLinkedList list2 = new singleLinkedList();
        list2.addNode(new Node(1));
        list2.addNode(new Node(3));
        list2.addNode(new Node(4));
        list2.addNode(new Node(7));
        list2.addNode(new Node(12));
        //遍历链表list2
        System.out.println("遍历有序链表list2");
        list2.list();
        //合并两个有序链表
        System.out.println("合并两个有序链表");
        list.mergeList(list2);
        list.list();
    }
}

class singleLinkedList {
    //建立头节点
    private Node head = new Node(0);

    Node getHead() {
        return head;
    }

    //添加结点(从小到大)
    void addNode(Node node) {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = node;
                return;
            }
            if (temp.next.id >= node.id) {
                node.next = temp.next;
                temp.next = node;
                return;
            }
            temp = temp.next;
        }
    }

    //查找链表节点个数
    int nodeCount() {
        if (head.next == null) {
            return 0;
        }
        Node temp = head.next;
        int count = 0;
        while (true) {
            if (temp == null) {
                return count;
            }
            count++;
            temp = temp.next;
        }
    }

    //遍历链表
    void list() {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                return;
            }
            System.out.println(temp.next);
            temp = temp.next;
        }
    }

    //逆序打印
    void reversePrint() {
        if (nodeCount() <= 0) {
            //链表为空
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node curr=head.next;
        while(curr!=null){
            stack.push(curr);
            curr=curr.next;//指针后移
        }
        while(stack.size()>0){
            System.out.println(stack.pop());
        }

    }

    //查找结点链表中倒数第k个结点
    void checkFormEnd(int k) {
        if (k <= 0) {
            System.out.println("输入数据非法--checkFromEnd");
            return;
        }
        Node temp = head;
        if (nodeCount() < k) {
            if (nodeCount() == 0)
                System.out.println("链表为空--checkFromEnd");
            else
                System.out.println("输入数据非法--checkFromEnd");
            return;
        }
        //转换成正数的结点
        int len = nodeCount() - k + 1;
        for (int i = 0; i < len; i++) {
            temp = temp.next;
        }
        System.out.println(temp);
    }

    //头插法进行链表反转
    void reversalList3() {
        if (nodeCount() <= 0) {
            return;
        }
        Node newHead = new Node(0);
        Node curr = head.next;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = newHead.next;
            newHead.next = curr;
            curr = next;
        }
        head.next = newHead.next;
    }

    //利用头插法进行反转
    singleLinkedList reversalList2() {
        if (nodeCount() <= 0) {//链表为空
            return null;
        }
        //定义一个头结点
        singleLinkedList list = new singleLinkedList();
        Node newHead = list.getHead();
        Node curr = null;
        while (true) {
            if (head.next == null) {
                return list;
            }
            curr = head.next;
            head.next = head.next.next;
            curr.next = newHead.next;
            newHead.next = curr;
        }
    }

    //直接在原链表上进行反转
    void reversalList() {
        if (nodeCount() <= 0) {
            return;
        }
        //指向头节点
        Node prev = head;
        Node curr = head.next;
        Node rear = curr.next;
        boolean flag = true;
        while (true) {
            if (flag) {
                curr.next = null;
                flag = false;
            } else {
                curr.next = prev;
            }
            if (rear == null) {
                head.next = curr;
                return;
            }
            prev = curr;
            curr = rear;
            rear = rear.next;
        }
    }

    void mergeList(singleLinkedList list) {
        //定义头节点
        Node temp = head;
        Node temp1 = head.next;//首元结点
        Node temp2 = list.getHead().next;//首元结点
        while (true) {
            //只要有一个为null，就退出循环
            if (temp1 == null || temp2 == null) {
                break;
            }
            if (temp1.id < temp2.id) {
                temp.next = temp1;
                temp = temp.next;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp = temp.next;
                temp2 = temp2.next;
            }
        }
        temp.next = temp1 == null ? temp2 : temp1;
    }
}

class Node {
    private static int ID = 100;
    int id;
    Node next;

    Node() {
        id = ID++;
    }

    Node(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                '}';
    }
}
