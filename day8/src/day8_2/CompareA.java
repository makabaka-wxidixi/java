package day8_2;

public interface CompareA {
	//静态方法
	public static void method1() {
		System.out.println("CompareA：北京");
	}
	
	//默认方法
	public default void method2() {
		System.out.println("CompareB：上海");
	}
	
	default void method3() {//这里的public可以省略
		System.out.println("CompareC：郑州");
	}
}
