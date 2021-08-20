package domain;

/**
 * @author liu
 * @create 2021-08-20 11:28
 */
public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;

    //构造器

    public Employee() {
    }

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    //方法

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmployee(){
        return id + "\t\t" + name + "\t\t" + age + "\t\t\t" + salary;
    }

    @Override
    public String toString() {
        return getEmployee();
    }
}
