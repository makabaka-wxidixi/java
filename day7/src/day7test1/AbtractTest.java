package day7test1;
/*
 * 
 * abstract关键字的使用
 * 1. abstract:抽象的
 * 2. abstract可以用来修饰的结构:类、方法
 * 3. abstract修饰类:
 * 		抽象类
 * 		>此类不能实例化>抽象类中一定有构造器,便于子类实例化时调用(涉及:子类对象实例化的全过程)
 * 		>开发中,都会提供抽象类的子类,让子类对象实例化,完成相关的操作
 * 4, abstract修饰方法:
 * 		抽象方法
 * 		>抽象方法只有方法的声明,没有方法体
 * 		>包含抽象方法的类,一定是一个抽象类。反之,抽象类中可以没有抽象方法的。
 * 		>若子类重写了父类中的所有的抽象方法后,此子类方可实例化若子类没有重写父类中的所有的抽
 * 			象方法,则此子类也是一个抽象类,需要使用 abstract修饰
 */
public class AbtractTest {
	public static void main(String[] args) {
		Student stu=new Student();
		stu.identity();
		Student stu1=new Student("黎明",40);
		stu1.name();
		stu1.age();
	}

}

abstract class Person9{//抽象类
	String name;
	int age;
	
	public Person9() {
		
	}
	public Person9(String name,int age) {
		this.name=name;
		this.age=age;
	}
	public abstract void identity();
	public abstract void name();
	public abstract void age();
	
}
class Student extends Person9{//虽然类是抽象的，但是可以通过子类来造对象

	public Student() {
		
	}
	public Student(String name,int age) {
		super(name,age);
	}
	public void identity() {
		System.out.println("身份：学生");
	}
	public void name() {
		System.out.println("姓名："+name);
	}
	public void age() {
		System.out.println("年龄："+age);
	}
}
