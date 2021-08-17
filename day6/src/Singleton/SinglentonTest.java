package Singleton;
/*
 * 饿汉式
 */
public class SinglentonTest {
	public static void main(String[] args) {
		Bank b1=Bank.getInstance();
		Bank b2=Bank.getInstance();
		System.out.println(b1==b2);//true，证明两个对象的地址相同，是同一个       
	}
}

class Bank{	
	//1.私有化类的构造器
	private Bank() {
		
	}
	//2.内部创建类的对象
	//4.要求此对象也必须是声明为静态的
	private static Bank instance=new Bank();
	//3.提供公共的静态的方法，返回类的的对象
	
	public static Bank getInstance() {
		return instance;
	}
}