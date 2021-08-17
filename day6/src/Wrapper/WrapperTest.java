package Wrapper;

import org.junit.Test;

/*
 * 包装类的使用：
 * 1.java提供了8种基本数据类型对应的包装类，使得基本数据类型的变量有类的特征
 * 
 * 2.掌握基本数据类型、包装类、String三者之间的相互转换
 */
public class WrapperTest {
	
	/*
	 * String类型--->基本数据类型、包装类：调用包装类的parseXxx(String s)
	 */
	@Test
	public void test5(){
		String str1="123";
		int num2=Integer.parseInt(str1);
		System.out.println(str1);
		
		String str2="true1";
		boolean b1=Boolean.parseBoolean(str2);
		System.out.println(b1);
	}
	/*
	 * 基本数据类型、包装类--->String类型：调用String重载的valueOf(Xxx xxx)
	 */
	@Test
	public void test4(){
		int num1=10;
		//方式1：连接运算
		String str1=num1+"";
		System.out.println(str1);
		//方式2：调用String的valueOf（）方法
		float f1=12.3f;
		String str2=String.valueOf(f1);
		System.out.println(str2);
	}
	
	/*
	 * jdk5.0新特性：自动装箱和自动拆箱
	 * 
	 */
	@Test
	public void test3() {
		//自动装箱
		int num=10;
		Integer in1=num;
		System.out.println(in1.toString());
		
		boolean b1=true;
		Boolean b2=b1;
		System.out.println(b2);
		//自动拆箱
		int num2=in1;
		System.out.println(num2+1);   	
		
	}
	
	//包装类--->基本数据类型：调用包装类的xxxValue()
	@Test
	public void test2() {
		Integer in1=new Integer(12);
		
		int i1=in1.intValue();
		System.out.println(i1+1);
		
		Float f1=new Float(12.12f);
		float f2=f1.floatValue();
		System.out.println(f2+1);
	}
	
	//基本数据类型--->包装类，调用包装类的构造器
	@Test
	public void test1() {
		
		int num1=10;
		//System.out.println(num1.toString());错误写法，num1是一个基本数据类型
		Integer Int1=new Integer(num1);
		System.out.println(Int1.toString());
		
		Integer Int2=new Integer("123");
		System.out.println(Int2.toString());
		
//		Integer Int3=new Integer("123abc");里面必须存粹是个数
//		System.out.println(Int3.toString());
		
		Float f1=new Float(12.3f);
		Float f2=new Float("12.3");
		System.out.println(f1.toString());
		System.out.println(f2.toString());
		
		Boolean b1=new Boolean(true);
		Boolean b2=new Boolean("tRue");
		System.out.println(b2);
		Boolean b3=new Boolean("True123");
		System.out.println(b3.toString());
		
		Order order=new Order();
		System.out.println(order.isMale);
		System.out.println(order.isFemale);//变成引用数据类型了
	}
}

class Order{
	boolean isMale;
	Boolean isFemale;
}
