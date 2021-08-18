package day7test1;

public class Test {
	public static void main(String[] args) {
		
	}
}

class customer{
	final int id=0;
	static int init=1001;
	{
		id+=init++;//被final修饰的变量就是常量，常量不能被修改
	}
}
