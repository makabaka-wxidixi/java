package object;

/*
 * java.lang.object类
 * 1.Object类是所有java类的根父类
 * 2.如果在类的声明中未使用extends关键字指明其父类，则默认父类为java.lang.object类
 * 3.Object类中的功能（属性、方法）就具有通用性
 * 
 * 4.Object类中只声明了一个空参构造器
 * 
 * 
 */
public class Object {
	public static void main(String[] args) {
		 Order1 order=new Order1();
		 System.out.println(order.getClass().getSuperclass());
	}
}

class Order1{
	
}
