package practice;

/*
 * 类中属性的使用
 * 
 * 属性（成员变量）vs（局部变量）
 * 1，相同点：
 * 		定义变量的格式：数据类型 变量名=变量值
 * 		先声明，后使用
 * 		变量都有其对应的作用域
 * 
 * 2，不同点：
 * 		2.1 定义位置以及权限
 * 		属性：直接定义在类的{	}中
 * 		局部变量：声明在方法内，方法形参，代码块内，构造器形参，构造其内部的变量
 * 		属性可以加权限：public,private,缺省,protect
 * 		2.2默认初始化值不同
 * 		属性：类的属性，根据其类型，都有默认初始化值
 * 			整形：（byte、short、int、long）0
 * 			浮点型：（float、double）0.0
 * 			字符型：（char）0或者“\u0000”
 * 			布尔型：（boolean），false
 * 
 * 			引用数据类型（类，数组，接口）：null
 * 		局部变量：没有默认初始化值
 * 			意味着：我们再调用局部变量之前，一定要赋值
 * 
 * 		2.3在内存中加载的位置
 * 		属性：加载到堆空间中（非stasic）
 * 		局部变量：加载到栈空间
 * 		
 */
public class AttributeTest {
	public static void main(String[] args) {
		User u1=new User();
		System.out.println(u1.name);
		System.out.println(u1.age);
		System.out.println(u1.isMale);
	}
}

class User {
	String name;
	int age;
	boolean isMale;
}
