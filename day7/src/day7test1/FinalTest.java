package day7test1;
/*
 * f1na1:最终的
 * 1.f1nal可以用来修饰的结构:类、方法、变量
 * 2.final用来修饰一个类:此类不能被其他类所继承。比如: String:类、 Systema类、 String Buffer类
 * 3.final用来修饰方法:表明此方法不可以被重写比如: object:类中getC1ass();
 * 4.fina1用来修饰变量:此时的"变量”就称为是一个常量
 * 		4.1fina1修饰属性:可以考虑赋值的位置有:显式初始化、代码块中初始化、构造器中初始化
 * 		4.2final修饰局部变量:尤其是使用final修饰形参时,表明此形参是一个常量。当我们调用此方法时,给常
 * 			量形参赋一个实参。以后,就只能在方法体内使用此形参,但不能进行重新赋值。
 * static final用来修饰属性:全局常量
 */
public class FinalTest {
	public static void main(String[] args) {
		
	}
}
class Animal{	
	double weight;
	//加上final之后必须对属性进行赋值
	final double length;//默认初始化不行
	final int age=10;//显示初始化可以①
	final int tall;
	final int legs;
	{
		tall=10;//代码块中初始化也行②
	}
	
	public Animal() {
		length=12.12;
		legs = 4;//构造器中初始化也行③
	}
	
	public int Add(final int a) {
		int b=a;
		return a++;//修饰形参，不能改变形参，只能用
		
	}
	
}

//修饰方法，表明不能被重写
class A{
	int age;
	public final void printAge() {
		System.out.println(age);
	}
}

class B extends A{
	public void printAge() {//不能被重写
		System.out.println(age+1);
	}
}
//final用来修饰类
final class Person{
	String name;
	int age;
}

class Man extends Person{//不能继承
	
}
