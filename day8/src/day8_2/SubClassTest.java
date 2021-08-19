package day8_2;

public class SubClassTest {
	public static void main(String[] args) {
		//这里只可以调用默认方法，静态方法无法调用
		SubClass s=new SubClass();
		s.method2();
		//如果子类在没有重写此方法的前提下，默认调用的是父类中的同名同参的方法。->类优先则
		s.method3();
		//但是通过接口可以直接调用
		CompareA.method1();
		//总结：接口中的静态方法，只能通过静态方法来调用。
	}
}

class SubClass extends SuperClass implements CompareA{//实现类
	
	public void method3() {//重写
		System.out.println("SubClass：郑州");
	}
}

class SuperClass{
	public void method2() {
		System.out.println("SuperClass：上海");
	}
}