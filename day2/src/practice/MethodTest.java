package practice;
/*
 * 类中方法的声明和使用
 * 
 * 方法：描述类应该具有的功能
 * 比如：Math类：sqrt()\random()....
 * 		Scanner类：next--()...
 * 		Arrays类：sort()	\binarySearch()\toString()\equals()\....
 * 1，举例：
 * public void eat(){}，无形参，无返回
 * public void sleep(int hour){}，有形参，无返回
 * public String getName(){}，无形参，有返回
 * public String getNation(String nation){}，有形参，有返回
 * 
 * 2，方法的声明：权限修饰符 返回值类型 方法名（形参列表）{
 * 					方法体
 *  			}
 *  
 *  3，方法的使用中，可以调用当前类的属性或方法
 *  				方法中不可以定义方法
 * 
 * 
 */
public class MethodTest {
	public static void main(String[] args) {
		Customer people1=new Customer();
		people1.eat();
		people1.sleep(12);
		String nation=people1.getNation("中国");
		String name=people1.getName();
		System.out.println(nation);
		System.out.println(name);
	}
}

class Customer{
	//属性
	String name;
	int age;
	boolean isMale;
	
	//方法
	public void eat() {
		System.out.println("人类可以吃");
	}
	public void sleep(int hour) {
		System.out.println("该顾客睡了"+hour+"个小时");
	}
	public String getName() {
		return name="张二炮";
	}
	public String getNation(String nation) {
		String info="该顾客国籍是"+nation;
		return info;
	}
	
	
	
}
