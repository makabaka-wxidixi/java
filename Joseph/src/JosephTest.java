/**
 * @Author mkbk
 * @Description
 * @Create 2021-09-06 16:45
 */
public class JosephTest {
    public static void main(String[] args) {
        CircleLinkedList list = new CircleLinkedList();
        list.add(5);

//        list.customAdd(new Child(12));
//        list.customAdd(new Child(23));
//        list.customAdd(new Child(34));
//        list.customAdd(new Child(21));
//        list.customAdd(new Child(2));
        list.outOfRanks(1, 2, 5);
//        list.list();

    }

}

class CircleLinkedList {
    private Child first = null;
    private static Child temp = null;

    //创建环形链表
    void add(int nums) {
        if (nums < 1) {
            System.out.println("输入数据错误");
            return;
        }
        //移动指针
        Child curr = null;
        for (int i = 1; i <= nums; i++) {
            Child child = new Child(i);
            if (i == 1) {
                first = child;
                curr = first;
                curr.setNext(first);
                temp = first;
            } else {
                //指向新结点
                curr.setNext(child);
                //新结点指向首元结点
                child.setNext(first);
                temp = child;
                //指针后移
                curr = child;
            }
        }
        return;
    }

    //自定义添加数据
    void customAdd(Child child) {
        if (child == null && child instanceof Child) {
            System.out.println("数据输入错误");
            return;
        }
        if (first == null) {
            first = child;
            child.setNext(first);
            temp = first;
            return;
        }
        temp.setNext(child);
        child.setNext(first);
        temp = child;
        return;
    }

    //遍历链表
    void list() {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        Child temp = first;
        while (true) {
            System.out.println(temp);
            if (temp.getNext() == first) {
                return;
            }
            temp = temp.getNext();
        }
    }


    /**
     * 开始淘汰，并给出淘汰顺序
     *
     * @param start 起始位置
     * @param step  步长
     * @param nums  队伍总人数
     */
    void outOfRanks(int start, int step, int nums) {
        if (first == null || start > nums || nums <= 0 || start <= 0) {
            System.out.println("输入数据有误");
            return;
        }
        //指向first前一个结点
        Child helper = first;
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        int i=0;
        //循环nums-1次，最后一个就确定了
        for (i = 1; i < nums; i++) {
            if (helper == first) {
                break;
            }
            for (int j = 0; j < step - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("第" + i + "个淘汰的是" + first);
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("第" + i + "个淘汰的是" + first);
    }
}

class Child {
    private int id;
    private Child next;

    public Child() {
    }

    public Child(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Child getNext() {
        return next;
    }

    public void setNext(Child next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                '}';
    }
}
