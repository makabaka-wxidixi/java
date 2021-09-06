import java.util.Objects;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-09-06 14:42
 */
public class doubleLInkedLIstTest {
    public static void main(String[] args) {
        doubleLinkedList list = new doubleLinkedList();
        list.add(new Node(12));
        list.add(new Node(23));
        list.add(new Node(14));
        list.add(new Node(65));
        list.add(new Node(32));

        list.list();
        System.out.println("-------删除-------");
        list.delete(new Node(32));
        list.list();

        System.out.println("-------查找-------");
        Node node = list.checkNode(1);
        System.out.println(node);

        System.out.println("--------结点数--------");
        System.out.println(list.getCount());

        System.out.println("--------修改----------");
        list.update(new Node(12), new Node(100));
        list.list();
    }
}

class doubleLinkedList {
    //创建头节点
    private Node head = new Node(0);
    private static int count = 0;

    //定义计数器3
    int getCount() {
        return count;
    }

    //增
    void add(Node node) {
        Node temp = head;
        Node curr = null;
        while (true) {
            if (temp.next == null) {
                temp.next = node;
                node.prev = temp;
                count++;
                return;
            }
            curr = temp.next;
            if (curr.getId() > node.getId()) {
                node.next=curr;
                node.prev=curr.prev;
                node.prev.next=node;
                node.next.prev=node;
                count++;
                return;
            }
            temp = temp.next;
        }
    }

    //删
    void delete(Node node) {
        Node temp = head.next;
        while (true) {
            if (temp == null) {
                System.out.println("没有找到指定结点，删除失败");
                return;
            }
            if (temp.equals(node)) {
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }
                temp.prev.next = temp.next;
                System.out.println("删除成功");
                count--;
                return;
            }
            temp = temp.next;
        }
    }

    //查
    Node checkNode(int k) {
        Node temp = head;
        if (k > count || k <= 0) {
            System.out.println("填入数据非法");
            return null;
        }
        for (int i = 0; i < k; i++) {
            temp = temp.next;
        }
        return temp;
    }

    //改
    void update(Node oldNode, Node newNode) {
        if (oldNode == null || newNode == null) {
            System.out.println("输入数据为null");
            return;
        }
        Node temp = head.next;
        while (true) {
            if (temp == null) {
                System.out.println("没有找到对应节点");
                return;
            }
            if (temp.equals(oldNode)) {
                temp.setId(newNode.getId());
                System.out.println("修改完毕");
                return;
            }
            temp = temp.next;
        }
    }

    //遍历
    void list() {
        Node temp = head.next;
        while (true) {
            if (temp == null) {
                return;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

}

class Node {
    private int id;
    private static int ID = 100;
    Node next;
    Node prev;

    public Node() {
        id = ID++;
    }

    public Node(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return id == node.id;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                '}';
    }
}
