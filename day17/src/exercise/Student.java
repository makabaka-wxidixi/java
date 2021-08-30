package exercise;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-08-30 18:37
 */
public class Student implements Comparable{
    private String name;
    private double score;
    private String id;

    //构造器
    public Student() {
    }

    public Student(String name, double score, String id) {
        this.name = name;
        this.score = score;
        this.id = id;
    }
    //方法


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Student){
            Student stu=(Student) o;
            return -Double.compare(this.score, stu.score);
        }
        throw new RuntimeException("输入数据类型错误");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", id='" + id + '\'' +
                '}';
    }
}
