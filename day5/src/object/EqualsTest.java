
package object;

/*
 * 二、equals（）方法的使用
 * 1.是一个方法，而非运算符
 * 2.只能适用于引用数据类型
 * 3.Object类中equals（）和==作用相同，都是比较对象的地址值是否相等，及两个引用是否指向同一个地址
 * 4.想String,Date,File、包装类等都重写了Object类中的equals（）方法。重写以后比较的就是实际的值的
 * 		大小了
 * 5.通常情况下，我们自定义的类型如果要使用equals（）的话，也通常是比较两个对象的“实体内容”是否相同
 * 		那么我们就需要对Object类中的equals（）进行重写
 * 
 * 练习：编写Order类，有int型的orderId，String型的orderName，
 * 相应的getter()和setter()方法，两个参数的构造器
 * 重写父类的equals()方法：public boolean equals(Object obj)
 * 并判断测试类中创建的两个对象是否相等	
 */
public class EqualsTest {  
	public static void main(String[] args) {
		Order order1=new Order(2, "asdf");
		Order order2=new Order(2, "sdf");
		System.out.println(order1.equals(order2));
		Order order3=new Order(2, "asdf");
		System.out.println(order1.equals(order3));
	}
}
 
class Order extends Object{
	private int orderId;
	private String orderName;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public Order(int orderId, String orderName) {
		this.orderId = orderId;
		this.orderName = orderName;
	}
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj instanceof Order) {
			Order order = (Order)obj;
			return this.orderId==order.orderId&&
					this.orderName.equals(order.orderName);
		}
		return false;
	}
	
}
