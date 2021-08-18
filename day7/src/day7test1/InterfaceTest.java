package day7test1;
/*
 * 接口的使用
 * 1.接口使用interface来定义
 * 2.Java中,接口和类是并列的两个结构
 * 3.如何定义接口:定义接口中的成员
 * 		3.1JDK7及以前:只能定义全局常量和抽象方法	
 * 			>全局常量:public static final的.但是书写时，可以省略不写
 * 			>抽象方法:public abstract的
 * 		3.2 JDK8:除了定义全局常量和抽象方法之外，还可以定义静态方法、默认方法(略)
 * 4．接口中不能定义构造器的!意味着接口不可以实例化
 * 5.Java开发中,接口通过让类去实现(implements)的方式来使用．
 * 		如果实现类覆盖了接口中的所有抽象方法，则此实现类就可以实例化如果实现类没有覆盖
 * 			接口中所有的抽象方法,则此实现类仍为一个抽象类
 * 6.Java类可以实现多个接口--->弥补了Java单继承性的局限性
 * 			格式：class AA extends BB implements CC, DD,EE
 * 7．接口与接口之间可以继承，而且可以多继承
 * *******************************
 * 8.接口的具体使用，体现多态性
 * 9.实际上，接口就可以看做一种规范 
 */
public class InterfaceTest {
	public static void main(String[] args) {
		System.out.println(Flyable.MAX_SPEED);
		System.out.println(Flyable.MIN_SPEED);
		
		Plane plane=new Plane();
		plane.fly();
		plane.stop();
		
		rocketOfMan r1=new rocketOfMan();
		r1.stop();
		r1.fly(); 
		
		Fighter f22=new Fighter();
		f22.fly();
		f22.shot();
		f22.stop();
		
	}
}


interface Flyable{
	//全局常量
	public static final int MAX_SPEED=7900;
	int MIN_SPEED=1;//省略了public static final
	
	//抽象方法
	public abstract void fly();
	
	void stop();//省略public abstract 
	
}
interface fight{	
	public abstract void shot();
}

class Plane implements Flyable{

	@Override
	public void fly() {//接口中抽象方法的实现
		// TODO Auto-generated method stub
		System.out.println("通过引擎起飞");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("通过驾驶员减速"); 
	}
	
}
abstract class rocket implements Flyable{
	public void fly() {
		System.out.println("火柴点火");
	}
}

class rocketOfMan extends rocket implements Flyable{
	public void stop() {
		System.out.println("通过驾驶员手动停止");
	}
}

class Fighter extends Plane implements fight{//继承的类如果已经实现了接口，子类相当于也实现了

	@Override
	public void shot() {
		// TODO Auto-generated method stub
		System.out.println("发射导弹");
	}
	
}