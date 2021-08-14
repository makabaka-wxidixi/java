package knowledge;
/*
 * this关键字的使用
 * 1.this可以用来修饰：属性、方法、构造器
 * 2.this修饰属性和方法
 *   this理解为：当前对象
 *   
 *   在类的方法（或者构造器）中，我们可以使用“this.属性”或者“this.方法”的方式，调用当前对象的属性或者方法
 *   但是通常情况下我们都选择省略。当方法的形参和类的属性同名时，必须用this加以区分
 * 3.this调用构造器
 * 		3.1我们在类的构造器中，可以显示的使用“this（形参列表）”方式，调用本类中指定的其它构造器
 * 		3.2构造器中不能通过“this（形参列表）”方式调用自己
 * 		3.3如果一个类中最多有n个构造器，则最多有n-1个构造器中使用了this（形参列表）
 * 		3.4规定：“this（形参列表）”必须声明在当前构造器首行
 * 		3.5规定：一个构造器最多有一个“this（形参列表）”
 */
public class PersonThis {
	public static void main(String[] args) {
		Person1 p1=new Person1("yasuo");
//		p1.setName("yasuo");
		p1.getName();
//		p1.setAge(20);
		p1.getAge();
	}
}

class Person1{
	
	private String name;
	private int age;
	
	//构造器
	public Person1() {
		this.age=18;
	}
	public Person1(String name) {
		this();//调用空参的构造器
		this.name=name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	public void getName() {
		System.out.println("名字为："+name);
	}
	public void setAge(int age) {
		this.age=age;
	}
	public void getAge() {
		System.out.println("年龄为："+age);
	}
}