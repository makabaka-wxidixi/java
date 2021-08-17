package Singleton;
/*
 * 懒汉式
 */
public class OrderTest {
	public static void main(String[] args) {
		Order a=Order.getInstance();
		Order b =Order.getInstance();
		System.out.println(a==b);
	}
}
class Order{
	//1.私有化类的构造器
	private Order(){	
		
	}
	//2.声明当前类对象
	//4.此对象也必须声明为static
	private static Order instance=null;
	//3.声明public,static的返回当前类对象的方法
	public static Order getInstance() {
		if(instance==null) {
			instance=new Order();
			return instance;
		}
		else return instance;
	}
}
