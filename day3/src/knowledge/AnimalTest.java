package knowledge;
/*
 * 面向对象的特征一：封装与隐藏
 * 1.解释
 * 当我们不想被用户直接修改对象属性时，我们可以通过对属性进行封装，此时就要在属性前面加一个private
 * 之后相对该属性进行修改时就需要依靠接口来实现。我们可以趁机加一些条件来限制用户的输入。
 * 2.封装性的体现
 * 我们将类的属性xxx私有化（private)，同时，提供公共的（public）方法来获取（getxxx）和设置（setxxx）
 * 此属性
 * 拓展：封装性的体现：1，如上；2，不对外暴露的私有的方法；3，单列模式...
 * 3.封装性的体现，需要权限修饰符来配合
 * 		3.1 权限从小到大依次是：private 缺省 protected public
 * 		3.2 四种权限可以用来修饰类及类的内部结构：属性、方法、构造器、内部类
 *   	3.3 具体来讲：4种权限都也可用来修饰类的内部结构：属性，方法，构造器，内部类
 *   				 修饰类的话，只能用，缺省，public
 * 4.总结封装性：java提供了四种权限修饰符来修饰类以及类的内部结构，体现类及类内部在被调用时可见性的大小
 */
public class AnimalTest {
	public static void main(String[] args) {
		Animal dog=new Animal();
		dog.setLegs(4);
		dog.getLegs();
		System.out.println(dog.name);
		System.out.println(dog.age);
	}
}

class Animal{
	String name;
	int age;
	private int legs;//封装属性
	
	public void getLegs() {//接口
		System.out.println("腿的个数为："+legs);
	}
	public void setLegs(int number) {//接口，用于修改属性
		if(number>0&&number<=4)	legs=number;
		else System.out.println("输入错误");
	}
}
