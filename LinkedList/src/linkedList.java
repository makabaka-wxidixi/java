import java.util.Objects;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-09-02 22:17
 */
public class linkedList {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.add(new HeroNode("亚索", 1, "战士"));
        list.add(new HeroNode("悠米", 99, "辅助"));
        list.add(new HeroNode("泰隆", 23, "刺客"));
        list.add(new HeroNode("卡莎", 5, "射手"));
        //遍历链表
        list.list();

        list.check(99);

        HeroNode heroNode = new HeroNode("青钢影", 5, "战士");
        list.modify(heroNode);
        list.list();

        list.delete(new HeroNode("永恩", 24, "战士"));
        list.list();


    }
}

class SingleLinkedList {
    //定义头节点
    private HeroNode head = new HeroNode("", 0, "");

    //添加头结点
    public void add(HeroNode heroNode) {
        //定义一个指针变量，指向头结点
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = heroNode;
                return;
            }
            if (temp.next.id == heroNode.id) {
                System.out.println("输入数据重复");
                return;
            }
            if (temp.next.id > heroNode.id) {
                heroNode.next = temp.next;
                temp.next = heroNode;
                return;
            }
            temp = temp.next;
        }
    }

    public void modify(HeroNode heroNode) {
        //定义一个指针变量，指向首元结点
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.id == heroNode.id) {
                flag = true;//找到对应id就返回
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode.name;
            temp.occupation = heroNode.occupation;
            System.out.println("修改完成");
        } else {
            System.out.println("没有找到要修改的对象");
        }
    }

    //插入指定对象
    public void delete(HeroNode heroNode) {
        //指针指向头结点
        HeroNode temp = head;
        while (true) {
            if(temp.next==null){
                System.out.println("找不到要删除的对象");
                return;
            }
            if (temp.next.id == heroNode.id) {
                if(temp.next.equals(heroNode)){
                    temp.next = temp.next.next;
                    System.out.println("删除成功");
                    return;
                }else{
                    System.out.println("对象信息错误");
                    return;
                }
            }
            temp = temp.next;
        }
    }

    //用于查找指定id的结点，找到就返回该节点
    public void check(int id) {
        //定义一个指针变量，指向首元结点
        HeroNode temp = head.next;
        boolean flag = false;//定义一个标记
        while (true) {
            if (temp == null) {
                break;
            } else {
                if (temp.id == id) {
                    flag = true;
                    break;
                }
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("找到了，信息如下");
            System.out.println(temp);
        } else {
            System.out.println("没有找到");
        }
    }

    //用于遍历链表
    public void list() {
        //定义一个指向首元结点的指针
        HeroNode temp = head.next;
        if (temp == null) {
            return;
        }
        while (true) {
            if (temp == null) {
                return;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HeroNode {
    public String name;
    public int id;
    public String occupation;
    public HeroNode next;

    public HeroNode(String name, int id, String occupation) {
        this.name = name;
        this.id = id;
        this.occupation = occupation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeroNode heroNode = (HeroNode) o;
        return id == heroNode.id && Objects.equals(name, heroNode.name) && Objects.equals(occupation, heroNode.occupation);
    }


    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}