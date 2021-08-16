package object;

import java.util.Date;

/*
 * Object类中的toString（）的使用
 * 
 * 1.当我们输出一个对象的引用时，实际上就是调用当前对象的toString（）方法
 */
public class ToStringTest {

	public static void main(String[] args) {
		Customer cust1=new Customer("tom",21);
		System.out.println(cust1.toString());
		System.out.println(cust1);
		
		String str=new String("asd");
		System.out.println(str);
		 
		Date date=new Date(123123L);
		System.out.println(date);
		
		
	}
}
