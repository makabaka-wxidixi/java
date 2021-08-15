package study;
/*
 * 面向对象的特征之二：继承性
 * 
 * 一、继承性的好处
 * 1。减少了代码的冗余，提高了代码的复用性
 * 2. 便于功能的扩展
 * 3. 为之后多态性的使用，提供了前提
 * 二、继承性的格式：class A extends B{}
 * 		A：子类、派生类、subclass
 * 		B：父类、超类、基类、superclass
 * 	体现：一旦子类继承了父类，子类中就有了父类中声明的结构：所有的属性、方法（私有的也是）
 * 		子类直接继承的父类称为直接父类
 * 		子类间接继承的父类称为间接父类
 * 		子类继承父类以后，就获取了直接父类以及所有间接父类中声明的属性和方法
 * 四、1.如果我们没有显示声明一个类的话，则此类继承与java.lang.object类
 * 		2.所有的java类（除java.lang.object类之外）都直接或间接继承与java.lang.object类
 * 		3.意味着，所有的java类具有java.lang.object类声明的功能
 * 
 * 方法的重写(override/overwrite)
 * 1.重写：子类继承父类以后，可以对父类中同名参数的方法，进行覆盖操作
 * 2.应用：重写以后，当创建子类对象以后，通过子类对象调用子父类中的同名同参数的方法时，实际执行的是子类重写父类的方法
 * 3.细节：
 * 		1.子类重写的方法的权限修饰符权限不小于父类被重写的方法的权限修饰符
 * 		2.子类不能重写父类中声明为private权限的方法
 * 		3.父类被重写的方法的返回值类型如果是void，则子类重写的方法的返回值类型只能是void
 * 		4.父类被重写的方法的返回值类型如果是A类型，则子类重写的方法的返回值类型可以是A类也可以是A类的子类
 * 		5.父类被重写的方法的返回值类型如果是基本数据类型，泽子类重写的方法的返回值类型必须是相同的基本数据类型
 * 	
 * 			
 */
public class ExtendsTest {
	public static void main(String[] args) {
		Student s=new Student();
		s.age=12;
		System.out.println(s.getAge());
		System.out.println(s.getName());
		Person p=new Person();
		p.name="tom";
		System.out.println(p.getName());
	}
}
