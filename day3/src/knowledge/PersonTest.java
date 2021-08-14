package knowledge;

/*
 * 类的结构之三：构造器（或构造方法，constructor）的使用
 * construct:建设、建造
 * 一、构造器的作用
 * 1.创建对象
 * 2.初始化对象的信息
 * 3.一个类中定义的多个构造器，彼此构成重载
 * 4.一旦我们显示了定义了构造器之后，系统就不太提供了
 * 二、说明
 * 1.如果没有显式的定义类的构造器的话，则系统默认提供给一个空参的构造器
 * 2.定义构造器的格式，权限修饰符 类名（形参列表）{}
 */
public class PersonTest {
	public static void main(String[] args) {
		//创建类的对象：new+构造器
		Person p1 = new Person();
		p1.getAge();
		Person p2 = new Person("yasuo");
		p2.getName();
	}
}

class Person{
	//属性
	String name;
	int age;
	int weight;
	//构造器
	public Person(){
		System.out.println("person()...");
	}
	
	public Person(String s) {
		name = s;
	}
	//方法
	public void getName() {
		System.out.println(name);
	}
	
	public void getAge() {
		System.out.println(age);
	}
}
